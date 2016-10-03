package com.gwtjs.icustom.services;

import javax.jws.WebService;

/**
 * 测试类，测试服务效果
 * @author aGuang
 *
 */
@WebService
public interface HelloWorldService {
	public String sayHello(String name);
	public String sayBye(String name);
}
