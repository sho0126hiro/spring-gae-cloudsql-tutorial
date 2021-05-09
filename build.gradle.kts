import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.5"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.4.32"
	kotlin("plugin.spring") version "1.4.32"
	kotlin("plugin.jpa") version "1.4.32"
	id("com.google.cloud.tools.appengine") version "2.2.0" // 追加
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencyManagement {
	dependencies {
		dependency("org.springframework.cloud:spring-cloud-gcp-dependencies:1.2.3.RELEASE")
		dependency("com.google.cloud:libraries-bom:11.0.0")
	}
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR9")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	// validation
	implementation("javax.validation:validation-api:2.0.1.Final")
	// cloud sql(mysql)
	implementation("org.springframework.cloud:spring-cloud-gcp-starter-sql-mysql")
	// hibernate
	implementation("com.google.cloud:google-cloud-spanner-hibernate-dialect:1.5.0")
	implementation("com.google.cloud:google-cloud-spanner-jdbc:2.0.2")
	implementation("org.hibernate:hibernate-core:5.4.30.Final")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

appengine {
	deploy {
		projectId = "GCLOUD_CONFIG"
		version = "GCLOUD_CONFIG"
	}
}