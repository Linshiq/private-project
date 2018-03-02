package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年12月29日 下午6:14:46 
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
 *         <li>2016年12月29日-下午6:14:46</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration // 本人表示，一定要有这个标签(不然，你会吃亏的)
@ComponentScan
@MapperScan("com.lsq.db.dao")
public class Application extends SpringBootServletInitializer{
	
	public static void main(String[] args) {  
        SpringApplication.run(Application.class, args);  
    } 
}
