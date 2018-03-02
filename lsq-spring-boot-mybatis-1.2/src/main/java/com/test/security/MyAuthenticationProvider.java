package com.test.security;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.lsq.db.dao.UserMapper;
import com.lsq.db.model.User;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年8月15日 上午11:16:27 
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
 *         <li>2017年8月15日-上午11:16:27</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

   /* @Autowired
    private MyUserDetailsService userService;*/
    
	@Autowired
	private UserMapper userService;
    
    /**
     * 自定义验证方式
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
    	String username = authentication.getName();
        
        String password = (String) authentication.getCredentials();
        
        User i;
		
        List<User> s = userService.selectAllInfo();
        System.out.println(s);
		try {
			i = userService.selectByPrimaryKey(username);
		} catch (Exception e) {
			throw new UsernameNotFoundException("user select fail");
		}
		
		if(i == null){
			throw new UsernameNotFoundException("user select fail");
		}
		
		SystemUser sysUser = new SystemUser();
        
		sysUser.setId(i.getId());
		sysUser.setPassword(password);
		sysUser.setUserName(i.getName());
		
        MyUserDetails user = new MyUserDetails(sysUser);

        
        /*if(user == null){
            throw new BadCredentialsException("Username not found.");
        }*/

        //加密过程在这里体现
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Wrong password.");
        }

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}
