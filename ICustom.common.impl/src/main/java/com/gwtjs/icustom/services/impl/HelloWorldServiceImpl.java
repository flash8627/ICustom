package com.gwtjs.icustom.services.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;
import org.springframework.stereotype.Service;

import com.gwtjs.icustom.services.HelloWorldService;

@Service("HelloWorldService")
@InInterceptors(interceptors={"org.apache.cxf.interceptor.LoggingInInterceptor","com.gwtjs.icustom.services.interception.AuthInterceptor"})
@OutInterceptors(classes={org.apache.cxf.interceptor.LoggingOutInterceptor.class})
@WebService(
		endpointInterface = "com.gwtjs.icustom.services.HelloWorldService", 
		name="HelloServices",
		targetNamespace="http://services.gwtjs.com:8080/services/",
		portName="HelloWorldServicesPort",
		serviceName = "HelloWorldServices"
)
public class HelloWorldServiceImpl implements HelloWorldService {
	
	@WebMethod
	public String sayHello(@WebParam String name) {
		return "Hi,"+name;
	}

	@WebMethod
	public String sayBye(@WebParam String name) {
		return "Good Bye,"+name;
	}
	
}
