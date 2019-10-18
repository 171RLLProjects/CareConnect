package com.mphasis.ocs.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan(basePackages="com.mphasis.ocs")
public class AppConfig {
	
	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@172.21.41.20:1521:XE");
		ds.setUsername("ocspro");
		ds.setPassword("ocspro");
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		 sessionFactory.setDataSource(getDataSource());
		 Properties props=new Properties();
		 props.put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
		 props.put("hibernate.hbm2ddl.auto","update");
		 props.put("hibernate.show_sql","true");
		 props.put("hibernate.format_sql","true");
		 sessionFactory.setHibernateProperties(props);
		 sessionFactory.setPackagesToScan("com.mphasis.ocs.pojos");
		 return sessionFactory;
		 		
	}

}