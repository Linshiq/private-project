package com.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年8月10日 下午3:25:51 
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
 *         <li>2017年8月10日-下午3:25:51</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
@Configuration  
@EnableWebMvc  
@ComponentScan(basePackages = "com.demo.controller")  
@PropertySource(value = "classpath:application.properties")  
public class MvcConfig extends WebMvcConfigurerAdapter {  
	
	 private static final Logger logger = LoggerFactory.getLogger(MvcConfig.class);  
	    @Autowired  
	    LoginInterceptor loginInterceptor;  
	  
	   /* *//** 
	 
	     * <p> 
	     *     视图处理器 
	     * </p> 
	     * 
	     * @return 
	     *//*  
	    @Bean  
	    public ViewResolver viewResolver() {  
	        logger.info("ViewResolver");  
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();  
	        viewResolver.setPrefix("/WEB-INF/jsp/");  
	        viewResolver.setSuffix(".jsp");  
	        return viewResolver;  
	    }  */
	  
	    /** 
	     * 拦截器配置 
	     * @param registry 
	     */  
	    @Override  
	    public void addInterceptors(InterceptorRegistry registry) {  
	        // 注册监控拦截器  
	        registry.addInterceptor(loginInterceptor)  
	                .addPathPatterns("/templates/backstage/**")  ;
	        /* .excludePathPatterns("/configuration/ui");  */
	  
	    }  
	  
	    @Override  
	    public void addCorsMappings(CorsRegistry registry) {  
	        registry.addMapping("/**")  
	                .allowedOrigins("*")  
	                .allowedHeaders("*/*")  
	                .allowedMethods("*")  
	                .maxAge(120);  
	    }  
	  
	    /** 
	     * 资源处理器 
	     * @param registry 
	     */  
	    @Override  
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {  
	        logger.info("addResourceHandlers");  
	        registry.addResourceHandler("/swagger-ui.html")  
	                .addResourceLocations("classpath:/style/");  
	        registry.addResourceHandler("/style/**")  
	                .addResourceLocations("classpath:/style/");  
	    }  
}
