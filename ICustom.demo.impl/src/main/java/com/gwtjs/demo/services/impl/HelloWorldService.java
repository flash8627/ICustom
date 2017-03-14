package com.gwtjs.demo.services.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;
import org.springframework.stereotype.Service;

import com.gwtjs.demo.services.IHelloWorldService;

@Service("HelloWorldService")
@InInterceptors(interceptors={"org.apache.cxf.interceptor.LoggingInInterceptor","com.gwtjs.demo.services.interception.AuthInterceptor"})
@OutInterceptors(classes={org.apache.cxf.interceptor.LoggingOutInterceptor.class})
@WebService
public class HelloWorldService implements IHelloWorldService {
	
	@WebMethod
	public String sayHello(@WebParam String name) {
		return "Hi,"+name;
	}

	@WebMethod
	public String sayBye(@WebParam String name) {
		return "Good Bye,"+name;
	}
	
}
