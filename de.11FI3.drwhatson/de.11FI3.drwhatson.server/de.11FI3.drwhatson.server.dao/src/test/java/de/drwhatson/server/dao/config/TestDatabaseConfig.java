package de.drwhatson.server.dao.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = { DatabaseConfig.JPA_REPOSITORY_PACKAGE_PATH })
@EnableTransactionManagement
public class TestDatabaseConfig {

	public static final String JPA_DOMAIN_PACKAGE_PATH = "de.drwhatson.server.api.domain";
	public static final String JPA_REPOSITORY_PACKAGE_PATH = "de.drwhatson.server.dao.repositories";
	public static final String HIBERNATE_SHOW_SQL = "true";
	public static final String HIBERNATE_DIALECT = "org.hibernate.dialect.H2Dialect";
	public static final String HIBERNATE_HBM2DDL_AUTO = "update";
	public static final String HIBERNATE_HBM2DDL_AUTO_PROP = "hibernate.hbm2ddl.auto";
	public static final String HIBERNATE_DIALECT_PROP = "hibernate.dialect";
	public static final String HIBERNATE_SHOW_SQL_PROP = "hibernate.show_sql";

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setJpaProperties(additionalJpaProperties());
		factory.setPackagesToScan(JPA_DOMAIN_PACKAGE_PATH);
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	public Properties additionalJpaProperties() {
		Properties properties = new Properties();
		properties.setProperty(HIBERNATE_HBM2DDL_AUTO_PROP, HIBERNATE_HBM2DDL_AUTO);
		properties.setProperty(HIBERNATE_DIALECT_PROP, HIBERNATE_DIALECT);
		properties.setProperty(HIBERNATE_SHOW_SQL_PROP, HIBERNATE_SHOW_SQL);

		return properties;
	}

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
		embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);

		return embeddedDatabaseBuilder.build();
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	

}
