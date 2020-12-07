package com.example.flyway_zonky.configuration

import org.postgresql.Driver
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class DataSourceConfiguration {

    companion object {
        private const val DB_IP = "10.1.1.1"
        private const val DB_USER = "postgres"
        private const val DB_PASSWORD = "postgres"
    }

    @Bean
    fun dataSource(): DataSource {
        return DataSourceBuilder
                .create()
                .driverClassName(Driver::class.java.canonicalName)
                .url("jdbc:postgresql://${DB_IP}:5432/postgres")
                .username(DB_USER)
                .password(DB_PASSWORD)
                .build()
    }

}
