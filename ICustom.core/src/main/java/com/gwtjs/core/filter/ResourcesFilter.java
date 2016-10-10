package com.gwtjs.core.filter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;

import com.gwtjs.core.servlet.HtmlInputStreamUtils;

/**
 * Servlet Filter implementation class ResourceFilter
 */
@WebFilter(urlPatterns = "*")
public class ResourcesFilter implements Filter {

	/**
	 * 获取url地址，将*转化成web/*,并处理图片路径\空串等逻辑 如果web目录没有直接取，直接到不到就返回404;
	 * 
	 * @param url
	 */
	/**
	 * 请求以/开头的都以/web/返回
	 */
	private static final String FILTER_PATH = "/web/";

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURI();

		// url = getResourcePath(url);
		String name = FILTER_PATH + url;
		name = name.replaceAll("//", "/");
		String headFile = "";
		String footerFile = "";
		headFile = "/web/header.html";
		footerFile = "/web/footer.html";
		InputStream headIn = null;
		InputStream footerIn = null;
		InputStream in = this.getClass().getClassLoader()
				.getResourceAsStream(name);
		headIn = this.getClass().getClassLoader()
				.getResourceAsStream(headFile);
		footerIn = this.getClass().getClassLoader()
				.getResourceAsStream(footerFile);
		/*System.out.println("url:"+url);
		System.out.println("name:"+name);*/
		// 只有首页需要这样的判断
		if (url != null && "/".equals(url)) {
			
			name = name + "index.html";
			in = this.getClass().getClassLoader().getResourceAsStream(name);
			// headIn+in+footerFile;
			String html = convertStreamToString(headIn);
			html += inputBodyStreamString(in);
			html += convertStreamToString(footerIn);
			InputStream inWithCode = new ByteArrayInputStream(
					html.getBytes("UTF-8"));

			// jar包资源目录下未找到首页文件
			if (in != null) {
				try {
					IOUtils.copy(inWithCode, response.getOutputStream());
				} finally {
					IOUtils.closeQuietly(headIn);
					IOUtils.closeQuietly(in);
					IOUtils.closeQuietly(footerIn);
				}
			} else {
				chain.doFilter(request, response);
			}

		} else if (in != null && url != null && !"/".equals(url)) {
			
			int htmlFlag = name.lastIndexOf(".html");
			InputStream inWithCode = null;
			//如果是html
			if (htmlFlag != -1) {
				String html = convertStreamToString(headIn);
				html += inputBodyStreamString(in);
				html += convertStreamToString(footerIn);
				inWithCode = new ByteArrayInputStream(
						html.getBytes("UTF-8"));
			}else{
				inWithCode = in;
			}
			
			try {
				IOUtils.copy(inWithCode, response.getOutputStream());
			} finally {
				IOUtils.closeQuietly(headIn);
				IOUtils.closeQuietly(in);
				IOUtils.closeQuietly(footerIn);
			}
		}else if (in == null && url != null && !"/".equals(url)) {//没有取到内容，地址不为空,不是首页
			if(name.lastIndexOf(".js")!=-1){
				boolean jarResources = false;
				//优先到webapp下面找
				in = this.getClass().getClassLoader().getResourceAsStream(url);
				
				if(in==null){
					//到jar包里找
					try {
						in = HtmlInputStreamUtils.getInputStream(this.getClass(), name);
						if(in!=null){
							jarResources = true;
						}
					} catch (Exception e) {
						//还是没有找到，直接转发得了,自己　会报404的
						chain.doFilter(request, response);
					}
				}
				
				//找到内容，拼装文件
				if(in!=null&&jarResources){
					try {
						IOUtils.copy(in, response.getOutputStream());
					} finally {
						IOUtils.closeQuietly(headIn);
						IOUtils.closeQuietly(in);
						IOUtils.closeQuietly(footerIn);
					}
				}else{
					chain.doFilter(request, response);
				}
				
			}
			//如果是html文件
			else if(name.lastIndexOf(".html")!=-1){
				
				//优先到webapp下面找
				in = this.getClass().getClassLoader().getResourceAsStream(url);
				
				if(in==null){
					//到jar包里找
					try {
						in = HtmlInputStreamUtils.getInputStream(this.getClass(), name);
					} catch (Exception e) {
						//还是没有找到，直接转发得了,自己　会报404的
						chain.doFilter(request, response);
					}
				}
				
				InputStream inWithCode = null;
				//找到内容，拼装文件
				if(in!=null){
					/*byte[] buff = new byte[1024];
					int count = in.read(buff);
					StringBuilder result = new StringBuilder();
					while(count>0) {
						String string =new String(buff, 0, count);
						result.append(string);
					}*/
					
					String html = convertStreamToString(headIn);
					html += inputBodyStreamString(in);
					html += convertStreamToString(footerIn);
					inWithCode = new ByteArrayInputStream(html.getBytes("UTF-8"));
					
					try {
						IOUtils.copy(inWithCode, response.getOutputStream());
					} finally {
						IOUtils.closeQuietly(headIn);
						IOUtils.closeQuietly(in);
						IOUtils.closeQuietly(footerIn);
					}
				}else{
					//还是没有找到，直接转发得了,自己　会报404的
					chain.doFilter(request, response);
				}
				
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
	}
	
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		InputStream is = HtmlInputStreamUtils.getInputStream(getClass(), "");
		byte[] buff = new byte[1024];
		int count = is.read(buff);
		StringBuilder result = new StringBuilder();
		while(count>0) {
			String string =new String(buff, 0, count);
			result.append(string);
		}
		response.getWriter().write(result.toString());
	}

	/**
	 * 这种写法可以压缩字符，没有换行
	 * @param is
	 * @return
	 */
	private String convertStreamToString(InputStream is) {
		if(is==null){
			return "";
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();

	}

	private String inputBodyStreamString(InputStream in) throws IOException {
		StringBuffer out = new StringBuffer();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			out.append(new String(b, 0, n));
		}
		String result = out.toString();
		//内容部分从body内获取．去头去尾．自己的脚本参考index.html
		int bodyStart = result.lastIndexOf("<body>");
		int bodyEnd = result.lastIndexOf("</body>");
		if(bodyStart==-1){
			bodyStart = 0;
		}
		if(bodyEnd==-1){
			bodyEnd = result.length();
		}
		result = result.substring(bodyStart,bodyEnd);
		return result;
	}

	/*public static String inputStream3String(InputStream is) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i = -1;
		while ((i = is.read()) != -1) {
			baos.write(i);
		}
		return baos.toString();
	}*/

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}
