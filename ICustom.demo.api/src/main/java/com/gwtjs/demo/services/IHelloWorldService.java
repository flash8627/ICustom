package com.gwtjs.demo.services;

import javax.jws.WebService;

/**
 * 测试类，测试服务效果
 * 
 * @author aGuang
 *
 */
@WebService
public interface IHelloWorldService {
	
	public String sayHello(String name);

	public String sayBye(String name);
}
