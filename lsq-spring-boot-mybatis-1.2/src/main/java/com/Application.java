package com;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.PropertyConfigurator;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.pagehelper.PageHelper;

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
@EnableTransactionManagement
public class Application extends SpringBootServletInitializer {

	// private static final String MAPPER_SCAN_BASE_PACKAGE = "com.blog.mapper";
	private static final String TYPE_ALIASES_PACKAGE = "com.lsq.db.model";
	private static final String MAPPER_LOCATION = "classpath:/namedsql/*.xml";

	static {

		try {
			// 初始化log4j
			String log4jPath = Application.class.getClassLoader().getResource("").getPath() + "/log4j.properties";
			System.out.println("初始化Log4j。。。。");
			System.out.println("path is " + log4jPath);
			PropertyConfigurator.configure(log4jPath);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Autowired
	DataSource dataSource;

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		// 分页插件
		PageHelper pageHelper = new PageHelper();
		Properties props = new Properties();
		props.setProperty("reasonable", "true");
		props.setProperty("supportMethodsArguments", "true");
		props.setProperty("returnPageInfo", "check");
		props.setProperty("params", "count=countSql");
		pageHelper.setProperties(props);
		// 添加插件
		bean.setPlugins(new Interceptor[] { pageHelper });

		// 加载model包
		bean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);

		/*
		 * mybatis.mapperLocations：指定*Mapper.xml的位置
		 * 如果不加会报org.apache.ibatis.binding.BindingException: Invalid bound
		 * statement (not found):
		 * com.blog.mapper.MessageMapper.findMessageInfo异常
		 * 因为找不到*Mapper.xml，也就无法映射mapper中的接口方法。
		 */

		try {
			bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.setSessionTimeout(50);// 单位为S
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		/*
		 * System.setProperty("log.root",Constant.LOG_ROOT_DAILY);
		 * 
		 * System.setProperty("log.base",Constant.LOG_PATH_DAILY);
		 */
	}
}
