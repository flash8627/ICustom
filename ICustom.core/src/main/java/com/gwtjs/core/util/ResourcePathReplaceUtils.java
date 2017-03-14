package com.gwtjs.core.util;

public class ResourcePathReplaceUtils {
	
	/**
     * 获取url地址，将*转化成web/*,并处理图片路径\空串等逻辑
     * @param url
     */
    static public String getResourcePath(String url){
    	System.out.println("in:"+url);
    	String resource = "";
		if(url!=null && !url.equals("")){
			//
		}
    	//
    	System.out.println("out:"+resource);
    	return resource;
    }
    
    public static void main(String[] args) {
    	
    	//后缀名无意思，需要使用"."匹配任意；总原则，把**/*.*替换成/web/**/*.*
    	//只需要把路径前面加/web即可,如果找不到资源，IO为空，则是404;
    	
    	String url = "";
		String result = getResourcePath(url);
		System.out.println(result);

		url = "/";
		result = getResourcePath(url);
		System.out.println(result);

		url = "/web/ResourceTest.html";
		result = getResourcePath(url);
		System.out.println(result);
		
		url = "/NavigationTreeGridManager/NavigationETree.html#";
		result = getResourcePath(url);
		System.out.println(result);
		
		url = "/web/ResourceTest.html";
		result = getResourcePath(url);
		System.out.println(result);
		
		url = "/web/ResourceTest.html";
		result = getResourcePath(url);
		System.out.println(result);
		
		url = "/video/";
		result = getResourcePath(url);
		System.out.println(result);
		
		url = "/video";
		result = getResourcePath(url);
		System.out.println(result);
		
		url = "/services/nav?_wadl";
		result = getResourcePath(url);
		System.out.println(result);
		
		url = "/resources/jquery/themes/icons/filesave.png";
		result = getResourcePath(url);
		System.out.println(result);
		
		url = "/resources/jquery/themes/icons/filesave.png";
		result = getResourcePath(url);
		System.out.println(result);
		
		url = "/resources/jquery/themes/css/style.png";
		result = getResourcePath(url);
		System.out.println(result);
		
		url = "/resources/jquery/themes/images/icons.png";
		result = getResourcePath(url);
		System.out.println(result);
		
		url = "/resources/jquery/themes/default/images/loading.gif";
		result = getResourcePath(url);
		System.out.println(result);
		
		url = "/resources/fonts/fontawesome-webfont.woff2";
		result = getResourcePath(url);
		System.out.println(result);
		
	}
	
}
