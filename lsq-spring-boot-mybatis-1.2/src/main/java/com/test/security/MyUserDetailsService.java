package com.test.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lsq.db.dao.UserMapper;
import com.lsq.db.model.User;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年8月15日 上午11:15:30 
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
 *         <li>2017年8月15日-上午11:15:30</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
@Service("MyUserDetailsImpl")
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserMapper userService;

	/*@Resource(name = "UserRoleServiceImpl")
	private UserRoleService userRoleService;*/

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User i;
		
		try {
			i = userService.selectByPrimaryKey(userName);
		} catch (Exception e) {
			throw new UsernameNotFoundException("user select fail");
		}
		
		/*if (user == null) {
			throw new UsernameNotFoundException("no user found");
		} else {
			try {
				List<UserRole> roles = userRoleService.getRoleByUser(user);
				return new MyUserDetails(user, roles);
			} catch (Exception e) {
				throw new UsernameNotFoundException("user role select fail");
			}
		}*/
		
		 return null;
	}
}
