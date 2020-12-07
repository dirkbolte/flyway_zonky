package com.example.flyway_zonky.configuration

import com.example.flyway_zonky.entities.Sample
import org.flywaydb.core.Flyway
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import java.util.Properties
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
class FlywayConfiguration() : ApplicationContextAware {
    private lateinit var applicationContext: ApplicationContext

    override fun setApplicationContext(value: ApplicationContext) {
        applicationContext = value
    }

    @Bean(initMethod = "migrate")
    @DependsOn("dataSource")
    fun flyway(dataSource: DataSource): Flyway {
        return Flyway
                .configure()
                .sqlMigrationPrefix("V")
                .sqlMigrationSeparator("_")
                .baselineOnMigrate(false)
                .connectRetries(3)
                .dataSource(dataSource)
                .load()
    }

    @Bean
    @DependsOn("flyway")
    fun entityManagerFactory(): LocalContainerEntityManagerFactoryBean {
        val properties = Properties().apply {
            put("hibernate.dialect", org.hibernate.dialect.PointbaseDialect::class.java.canonicalName)
            put("hibernate.ddl-auto", "validate")
        }
        val entityManagerFactoryBean = LocalContainerEntityManagerFactoryBean().apply {
            dataSource = applicationContext.getBean(DataSource::class.java)
            jpaVendorAdapter = HibernateJpaVendorAdapter()
            setPackagesToScan(Sample::class.java.packageName)
            setJpaProperties(properties)
        }
        return entityManagerFactoryBean
    }

    @Bean
    @DependsOn("entityManagerFactory")
    fun transactionManager(): PlatformTransactionManager {
        return JpaTransactionManager().apply {
            entityManagerFactory = applicationContext.getBean(EntityManagerFactory::class.java)
        }
    }

}
