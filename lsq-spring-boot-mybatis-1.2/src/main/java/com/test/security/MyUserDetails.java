package com.test.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.lsq.db.model.User;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年8月15日 上午11:14:08 
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
 *         <li>2017年8月15日-上午11:14:08</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：UserDetails代表了Spring
 *         Security的用户认证实体，带有用户名、密码、权限列表、过期特性等性质，可以自己声明类实现UserDetails接口，如果不想自己声明
 *         ，也可以用SpringSecurity的默认实现org.springframework.security.core.userdetails
 *         .User 本文例子中采用自定义类：</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class MyUserDetails extends SystemUser implements UserDetails {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyUserDetails(SystemUser user) {
		
		super(user);
	}

	//@Override
	/*public Collection<? extends GrantedAuthority> getAuthorities() {
		if (roles == null || roles.size() < 1) {
			return AuthorityUtils.commaSeparatedStringToAuthorityList("");
		}
		StringBuilder commaBuilder = new StringBuilder();
		for (UserRole role : roles) {
			commaBuilder.append(role.getRole()).append(",");
		}
		String authorities = commaBuilder.substring(0, commaBuilder.length() - 1);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
	}*/

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

}
