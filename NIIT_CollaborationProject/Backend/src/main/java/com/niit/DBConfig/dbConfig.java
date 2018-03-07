package com.niit.DBConfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.BlogDao;
import com.niit.daoImpl.BlogDaoImpl;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit")

public class dbConfig {
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("hr");
		dataSource.setPassword("hr");
		System.out.println("Datasource Connected");
		return dataSource;

	}

	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.show_sql", "true");
		hibernateProp.put("hibernate.format_sql", "true");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
		sessionFactoryBuilder.scanPackages("com.niit");
		sessionFactoryBuilder.addProperties(hibernateProp);
		SessionFactory sessionFactory = sessionFactoryBuilder.buildSessionFactory();
		System.out.println("SessionFactory Object created");
		return sessionFactory;
	}

	/*
	 * @Bean(name = "blogdao") public BlogDao getBlogDao() {
	 * System.out.println("-----------BlogDao method--------"); return new
	 * BlogDaoImpl();
	 * 
	 * }
	 */

	@Bean("transactionManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);

	}

}
