import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	idea
	id("org.springframework.boot") version "2.4.0"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.4.20"
	kotlin("plugin.spring") version "1.4.20"
	kotlin("plugin.jpa") version "1.4.20"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.flywaydb:flyway-core:7.3.1")
	implementation("org.postgresql:postgresql:42.2.14")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.20")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.20")
	implementation("org.testng:testng:7.1.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
	testImplementation("org.flywaydb.flyway-test-extensions:flyway-spring-test:7.0.0")
	testImplementation("io.zonky.test:embedded-database-spring-test:1.6.1")
	testImplementation("io.zonky.test.postgres:embedded-postgres-binaries-darwin-amd64:13.1.0")
	testImplementation("org.testcontainers:postgresql:1.15.0")
}

tasks.withType<KotlinCompile> {
	sourceCompatibility = JavaVersion.VERSION_11.toString()
	targetCompatibility = JavaVersion.VERSION_11.toString()
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
		apiVersion = "1.4"
		languageVersion = "1.4"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
