package com.practise.multiple.datasource.user.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "userEntityManagerFactory", 
		transactionManagerRef = "userTransactionManager", basePackages = {"com.practise.multiple.datasource.user.repo" })

public class UserConfig {

	@Bean(name = "userDataSource")
	@ConfigurationProperties(prefix = "db3.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "userEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("userDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.practise.multiple.datasource.user.data").persistenceUnit("db3").build();
	}

	@Bean(name = "userTransactionManager")
	public PlatformTransactionManager userTransactionManager(
			@Qualifier("userEntityManagerFactory") EntityManagerFactory userEntityManagerFactory) {
		return new JpaTransactionManager(userEntityManagerFactory);
	}
}