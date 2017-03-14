package com.gwtjs.core.entity;


/**
 * 统一的返回类型
 * @author aGuang
 *
 */
public class ResultWrapper {
	
	private static final int SUCCESS_STATUS = 1; //成功返回
	
	private static final int ERROR_STATUS = 0; //错误返回
	
	private static final int FAULT_STATUS = 2; //Fault
	
	private String msg = ""; //返回的信息
	
	private int status = 1; //返回的状态
	
	private Object obj; //返回的对象
	
	public ResultWrapper(){}
	
	public ResultWrapper(String msg,int status,Object obj){
		this.msg = msg;
		this.status = status;
		this.obj = obj;
	}
	
	/**
	 * 成功的返回
	 * @param msg
	 * @param obj
	 * @return
	 */
	static public ResultWrapper successResult()
	{
		ResultWrapper war = new ResultWrapper();
		war.setMsg("操作成功!");
		//war.setObj(obj);
		war.setStatus(SUCCESS_STATUS);
		return war;
	}
	
	/**
	 * 成功的返回
	 * @param msg
	 * @param obj
	 * @return
	 */
	static public ResultWrapper successResult(Object obj)
	{
		ResultWrapper war = new ResultWrapper();
		war.setMsg("操作成功!");
		war.setObj(obj);
		war.setStatus(SUCCESS_STATUS);
		return war;
	}
	
	/**
	 * 成功的返回
	 * @param msg
	 * @param obj
	 * @return
	 */
	static public ResultWrapper successResult(Object msg,Object obj)
	{
		ResultWrapper war = new ResultWrapper();
		war.setMsg(msg.toString());
		war.setObj(obj);
		war.setStatus(SUCCESS_STATUS);
		return war;
	}
	
	/**
	 * 成功的返回
	 * @param msg
	 * @param obj
	 * @return
	 */
	static public ResultWrapper successResult(String msg,Object obj)
	{
		ResultWrapper war = new ResultWrapper();
		war.setMsg(msg);
		war.setObj(obj);
		war.setStatus(SUCCESS_STATUS);
		return war;
	}
	
	/**
	 * 错误的返回
	 * @param msg
	 * @param obj
	 * @return
	 */
	static public ResultWrapper faultResult(String msg,Object obj)
	{
		ResultWrapper war = new ResultWrapper();
		war.setMsg(msg);
		war.setObj(obj);
		war.setStatus(FAULT_STATUS);
		return war;
	}
	
	/**
	 * 错误的返回
	 * @param msg
	 * @param obj
	 * @return
	 */
	static public ResultWrapper errorResult(String msg,Object obj)
	{
		ResultWrapper war = new ResultWrapper();
		war.setMsg(msg);
		war.setObj(obj);
		war.setStatus(ERROR_STATUS);
		return war;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}
