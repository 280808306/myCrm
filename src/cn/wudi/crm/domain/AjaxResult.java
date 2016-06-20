package cn.wudi.crm.domain;

/**
 * ajax 请求返回的信息对象
 * @author zh
 */
public class AjaxResult {
	
	/**
	 * 当前请求方法执行的状态 true 成功 false 操作失败
	 */
	private boolean status = true;
	
	/**
	 * 当前请求操作的消息
	 */
	private String msg = "操作成功";
	
	/**
	 * 放回的状态码 方便记录 和 错误提示
	 */
	private int code = 200;

	/**
	 *  成功时
	 */

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
