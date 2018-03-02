package com.test.security;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年8月15日 下午1:48:27 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 * 
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年8月15日-下午1:48:27</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class SystemUser {

	private String id;

	private String userName;
	private String password;

	public SystemUser() {
	}

	public SystemUser(SystemUser user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.id = user.getId();
	}

	public String getId() {
		return id;
	}

	public void setId(String string) {
		this.id = string;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
