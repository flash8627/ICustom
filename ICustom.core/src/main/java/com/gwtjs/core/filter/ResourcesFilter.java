package com.gwtjs.core.filter;

import static com.gwtjs.core.util.InputStreamUtils.buildOutStream;
import static com.gwtjs.core.util.RequestUtil.getUserAgent;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.gwtjs.core.util.InputStreamUtils;

/**
 * Servlet Filter implementation class ResourceFilter
 */
@WebFilter(urlPatterns = "*")
public class ResourcesFilter implements Filter {
	
	private static final Logger log = LoggerFactory.getLogger(ResourcesFilter.class);
	
	/**
	 * 获取url地址，将*转化成web/*,并处理图片路径\空串等逻辑 如果web目录没有直接取，直接到不到就返回404;
	 * 
	 * @param url
	 */
	/**
	 * 请求以/开头的都以/web/返回
	 */
	private static final String FILTER_PATH = "/web/";
	
	/**
	 * 首页名称,后续改成读取项目的web.xml中的配置
	 */
	private static final String HOME_NAME = "index.html";
	
	private static final String HEAD_FILE = "/web/header.html";
	private static final String FOOTER_FILE = "/web/footer.html";
	
	/**
	 * 系统保留的路径,暂时没有启用,后续启用改成lookup配置,再使用工厂读取.
	 */
	//private static final String AVAILABLE_PATH = "/services";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		
		String userAgent = getUserAgent(req);
		int userAgentFlag = userAgent.lastIndexOf("Java/1.");
		// url = getResourcePath(url);
		if(userAgentFlag>-1){
			log.debug("\nUser-Agent init:"+userAgentFlag+" - "+userAgent);
			log.info("\nComplete system startup");
			chain.doFilter(request, response);
		}else{
			//项目主页(/)或模块目录主页(/nav/)
			String url = getRequestResourceFilePath(uri);
			boolean rootFlag = validateRootPath(uri);
			
			if(rootFlag){
				//加载项目或目录下的index.html
				String contentFile = url+HOME_NAME;
				//log.info("\n content File PATH:"+contentFile);
				InputStream contentIn = loaderHtmlResourceAsStream(contentFile);
				//log.info("\ncontent In File Stream:"+contentIn);
				
				buildPageToStream(contentIn,response);
			}else{//带有后缀的访问 ,带有html文件名
				//log.info("\n  other content File PATH:"+uri);
				//int htmlFlag = uri.lastIndexOf(".html");
				InputStream contentIn = null;
				//如果是html文件
				if(uri.lastIndexOf(".html") != -1){
					contentIn = loaderHtmlResourceAsStream(uri);
					
					//如果不空,则加载拼装html
					if(contentIn!=null){
						buildPageToStream(contentIn,response);
					}else{
						//如果是项目下的html,或是404都会朝这里走
						chain.doFilter(request, response);
					}
					
				}else if(uri.lastIndexOf(".jsp")!=-1){
					log.debug("classes目录的jsp不能访问，请改用servlet输出页面!!! ");
					chain.doFilter(request, response);
				}else{
					//如果不是html
					contentIn = loaderResourceAsStream(uri);
					
					//如果不空,则加载拼装html
					if(contentIn!=null){
						IOUtils.copy(contentIn, response.getOutputStream());
					}else{
						//如果是项目下的html,或是404都会朝这里走
						chain.doFilter(request, response);
					}
				}
				
			}
			
		}
		
	}
	
	/**
	 * 拼装上中下流文件并输出(copy)
	 * @param contentIn
	 * @param response
	 * @throws IOException
	 */
	private void buildPageToStream(InputStream contentIn,ServletResponse response) throws IOException
	{
		if(contentIn!=null){
			InputStream headIn = loaderHtmlResourceAsStream(HEAD_FILE);
			//log.info("\nhead In File Stream:"+headIn);
			InputStream footerIn = loaderHtmlResourceAsStream(FOOTER_FILE);
			//log.info("\nfooter In File Stream:"+footerIn);
			
			InputStream inWithCode = buildOutStream(headIn, footerIn, contentIn);
			try {
				IOUtils.copy(inWithCode, response.getOutputStream());
			} finally {
				closeStream(headIn,footerIn,contentIn);
				closeStream(inWithCode);
			}
		}
	}
	/**
	 * 替换双斜线
	 * @param uri
	 * @return
	 */
	private String getRequestResourceFilePath(String filePath)
	{
		//String name = FILTER_PATH + filePath;
		return filePath.replaceAll("//", "/");
	}
	
	/**
	 * 判断路径是否是"/"结束
	 * @param filepath
	 * @return
	 */
	private boolean validateRootPath(String filepath)
	{
		//log.debug("\n validateRootPath filepath:"+filepath);
		int filepathLength = filepath.length();
		
		int filePathStart = 0;
		if(filepathLength>=1){
			filePathStart = filepathLength-1;
		}
		String lastChar = filepath.substring(filePathStart);
		//log.debug("\nfilepathLength:"+filepathLength+" , "+lastChar);
		if(null!=lastChar && "/".equals(lastChar)){
			return true;
		}
		return false;
	}
	/**
	 * 加载CSS和JS资源
	 * @param url
	 * @return
	 */
	private InputStream loaderResourceAsStream(String url){
		return loaderHtmlResourceAsStream(url);
	}
	
	/**
	 * <h2>加载html</h2>
	 * 所有html,css,js,image资源都应该过滤
	 * 优先直接加载webapp目录下的资源,jar包中的资源最后加载;
	 * 加载顺序:1.优先加载项目目录; 2.加载class下的文件; 3.加载jar包下的文件;
	 * 
	 * @return
	 */
	private InputStream loaderHtmlResourceAsStream(String url)
	{	
		InputStream contentIn = null;
		//log.info("加载项目目录下的文件   url: "+url);
		//1.加载项目目录下的文件,如果是直接加载,路径起点不包含"/web/"; 
		try {
			//log.info("加载项目目录下的文件   url 1 : "+url);
			contentIn = InputStreamUtils.getInputStream(this.getClass(), url);
		} catch (Exception e) {
			//log.info("加载项目目录下的文件name java.lang.NullPointerException -> "+url);
			//log.info("加载项目目录下的文件   contentIn 1 : "+contentIn);
		}
		//2.加载class下的文件;
		if(contentIn==null){
			url = FILTER_PATH+url;
			//log.info("加载项目目录下的文件   url 2 : "+url);
			url = getRequestResourceFilePath(url);
			//log.info("加载项目目录下的文件   url 2 : "+url);
			try {
				contentIn = InputStreamUtils.getInputStream(this.getClass(), url);
			} catch (Exception e) {
				// TODO: handle exception
			}
			//log.info("加载项目目录下的文件   contentIn 2 : "+contentIn);
		}
		//3.加载jar包下的文件;
		if(contentIn==null){
			//log.info("加载项目目录下的文件   url 3 : "+url);
			contentIn = this.getClass().getClassLoader().getResourceAsStream(url);
			//log.info("加载项目目录下的文件   contentIn 3 : "+contentIn);
		}
		//三个为空时可能是项目目录下的html,也可能是404原因
		return contentIn;
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
	}
	@Override
	public void destroy() {
	}

	/**
	 * 关闭流
	 * @param headIn
	 * @param footerIn
	 * @param contentIn
	 */
	private void closeStream(InputStream headIn, InputStream footerIn, InputStream contentIn) {
		if(headIn!=null) closeStream(headIn);
		if(contentIn!=null) closeStream(contentIn);
		if(footerIn!=null) closeStream(footerIn);
	}
	
	private void closeStream(InputStream stream)
	{
		try {
			IOUtils.closeQuietly(stream);
		}finally{
			IOUtils.closeQuietly(stream);
		}
	}
	
}
