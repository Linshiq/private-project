package com.lsq.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.test.security.MyAuthenticationProvider;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年8月10日 下午2:07:55 
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
 *         <li>2017年8月10日-下午2:07:55</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
@Configuration  
@EnableWebSecurity  
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private Logger logger = Logger.getLogger(WebSecurityConfig.class);

	
	@Autowired
    private MyAuthenticationProvider provider;//自定义验证
	
	/**
	 * 登录session key
	 */
	public final static String SESSION_KEY = "login_session";
	
	 /**定义认证用户信息获取来源，密码校验规则等*/  
    @Override  
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  
    	
    	//User i = userService.selectByPrimaryKey(user);
    	
    	//inMemoryAuthentication 从内存中获取  
    	/*auth.inMemoryAuthentication().withUser("chengli").password("123456").roles("USER")  ;
    	
    	//InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> s = auth.inMemoryAuthentication();*/
    	    	
    	auth.authenticationProvider(provider);
    	
    	//jdbcAuthentication从数据库中获取，但是默认是以security提供的表结构  
        //usersByUsernameQuery 指定查询用户SQL  
        //authoritiesByUsernameQuery 指定查询权限SQL  
        //auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query).authoritiesByUsernameQuery(query);  
          
        //注入userDetailsService，需要实现userDetailsService接口  
        //auth.userDetailsService(userDetailsService);  
    }  
      
    /**定义安全策略*/  
    @Override  
    protected void configure(HttpSecurity http) throws Exception {  
        http.authorizeRequests()//配置安全策略  
            .antMatchers("/","/style/**").permitAll()//定义/请求不需要验证  
            .antMatchers("/login/","/login").permitAll()
            .anyRequest().authenticated()//其余的所有请求都需要验证  
            .and()  
        .logout()  
            .permitAll()//定义logout不需要验证  
            .and()  
        .formLogin() //使用form表单登录  
        	.loginPage("/login") // TODO 怎么解决访问一个网页登录一次的问题
        	.failureUrl("/login?error")
        	.permitAll()
        	.and()
        	.rememberMe()//登录后记住用户
        	.tokenValiditySeconds(1209600);
    }  
}
