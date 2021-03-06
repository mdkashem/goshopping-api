package com.revature.goshopping.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl(System.getenv("DB_URL"));
		dataSource.setUsername(System.getenv("DB_USERNAME"));
		dataSource.setPassword(System.getenv("DB_PASSWORD"));
	
		
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.revature.goshopping.entity");
		sessionFactory.setHibernateProperties(hibernateProperties());
		
		return sessionFactory;
	}
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		
		return transactionManager;
	}
	
	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", System.getenv("HBM2_DDL_AUTO"));
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
		
		return hibernateProperties;
	}
}
