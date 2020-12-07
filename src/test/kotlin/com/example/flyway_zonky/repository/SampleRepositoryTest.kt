package com.example.flyway_zonky.repository

import com.example.flyway_zonky.configuration.DataSourceConfiguration
import com.example.flyway_zonky.configuration.FlywayConfiguration
import com.example.flyway_zonky.entities.Sample
import io.zonky.test.db.AutoConfigureEmbeddedDatabase
import io.zonky.test.db.postgres.embedded.EmbeddedPostgres
import org.flywaydb.test.annotation.FlywayTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.Duration
import java.util.function.Consumer


@ExtendWith(SpringExtension::class)
@AutoConfigureEmbeddedDatabase(beanName = "dataSource", provider = AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY)
@EntityScan(basePackageClasses = [Sample::class])
@EnableJpaRepositories(basePackageClasses = [SampleRepository::class])
@ContextConfiguration(classes = [FlywayConfiguration::class, DataSourceConfiguration::class])
class SampleRepositoryTest {

    @Autowired
    private lateinit var repository: SampleRepository

    @BeforeEach
    @FlywayTest
    fun setup() {}

    @Test
    fun `test 1`() {
        repository.save(Sample(data = "foobar"))
    }

    @Test
    fun `test 2`() {
        repository.save(Sample(data = "foobar"))
    }

    @Test
    fun `test 3`() {
        repository.save(Sample(data = "foobar"))
    }

    @Test
    fun `test 4`() {
        repository.save(Sample(data = "foobar"))
    }

    @Test
    fun `test 5`() {
        repository.save(Sample(data = "foobar"))
    }

    @Test
    fun `test 6`() {
        repository.save(Sample(data = "foobar"))
    }

    @Test
    fun `test 7`() {
        repository.save(Sample(data = "foobar"))
    }
}
