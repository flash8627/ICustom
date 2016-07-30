package com.gwtjs.common.filter;

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
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		String url = request.getRequestURI();

		// url = getResourcePath(url);
		String name = FILTER_PATH + url;
		name = name.replaceAll("//", "/");
		String headFile = "";
		String footerFile = "";
		InputStream headIn = null;
		InputStream footerIn = null;
		InputStream in = this.getClass().getClassLoader()
				.getResourceAsStream(name);
		
		// 只有首页需要这样的判断
		if (url != null && "/".equals(url)) {
			headFile = "web/header.html";
			footerFile = "web/footer.html";
			headIn = this.getClass().getClassLoader()
					.getResourceAsStream(headFile);
			footerIn = this.getClass().getClassLoader()
					.getResourceAsStream(footerFile);
			
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
					IOUtils.copy(inWithCode, arg1.getOutputStream());
				} finally {
					IOUtils.closeQuietly(headIn);
					IOUtils.closeQuietly(in);
					IOUtils.closeQuietly(footerIn);
				}
			} else {
				arg2.doFilter(arg0, arg1);
			}

		} else if (in != null && url != null && !"/".equals(url)) {
			
			int htmlFlag = name.lastIndexOf(".html");
			InputStream inWithCode = null;
			//如果是html
			if (htmlFlag != -1) {
				headFile = "/web/header.html";
				footerFile = "/web/footer.html";
				headIn = this.getClass().getClassLoader()
						.getResourceAsStream(headFile);
				footerIn = this.getClass().getClassLoader()
						.getResourceAsStream(footerFile);
				String html = convertStreamToString(headIn);
				html += inputBodyStreamString(in);
				html += convertStreamToString(footerIn);
				inWithCode = new ByteArrayInputStream(
						html.getBytes("UTF-8"));
			}else{
				inWithCode = in;
			}
			
			try {
				IOUtils.copy(inWithCode, arg1.getOutputStream());
			} finally {
				IOUtils.closeQuietly(headIn);
				IOUtils.closeQuietly(in);
				IOUtils.closeQuietly(footerIn);
			}
		} else {
			arg2.doFilter(arg0, arg1);
		}
	}

	/**
	 * 这种写法可以压缩字符，没有换行
	 * @param is
	 * @return
	 */
	private String convertStreamToString(InputStream is) {
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
	public void init(FilterConfig arg0) throws ServletException {
	}

}
