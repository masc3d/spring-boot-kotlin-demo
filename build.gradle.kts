import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.3.21"
	//id("org.springframework.boot") version "2.1.2.RELEASE"
	id("org.springframework.boot") version "2.2.0.M4"
	id("org.jetbrains.kotlin.jvm") version kotlinVersion
	id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
	id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion
	id("io.spring.dependency-management") version "1.0.6.RELEASE"
}

version = "1.0.0-SNAPSHOT"

tasks.withType<KotlinCompile> {
	kotlinOptions {
		jvmTarget = "1.8"
		freeCompilerArgs = listOf("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

repositories {
	mavenCentral()
	maven(url = "https://repo.spring.io/milestone")
}

dependencies {
	compile("org.springframework.boot:spring-boot-starter-web")
	compile("org.springframework.boot:spring-boot-starter-data-jpa")
	compile("com.h2database:h2")
	compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	compile("org.jetbrains.kotlin:kotlin-reflect")
	compile("com.fasterxml.jackson.module:jackson-module-kotlin")
	testCompile("org.springframework.boot:spring-boot-starter-test") {
		exclude(module = "junit")
	}
	testImplementation("org.junit.jupiter:junit-jupiter-api")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

