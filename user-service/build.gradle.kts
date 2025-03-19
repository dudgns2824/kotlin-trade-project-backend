import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.3.2"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    kotlin("plugin.jpa") version "1.9.25"
    kotlin("plugin.allopen") version "1.9.25"
    kotlin("kapt") version "1.9.25"
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

group = "com.trade.backend"

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

val querydslVersion = "5.1.0"

repositories {
    mavenCentral()
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.3.2")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security:3.3.2")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.11")
    implementation("org.springdoc:springdoc-openapi-security:1.6.11")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.mariadb.jdbc:mariadb-java-client:3.3.0")
    implementation("jakarta.mail:jakarta.mail-api:2.1.2")
    implementation("com.auth0:java-jwt:4.4.0")
    implementation("org.eclipse.angus:angus-mail:2.0.2")
    implementation("org.springframework.security:spring-security-web:6.3.1")
    implementation("com.google.code.gson:gson")
    implementation("org.json:json:20220320")
    implementation("org.apache.commons:commons-lang3")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")
    implementation("io.jsonwebtoken:jjwt-api:0.12.6")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.6")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.6")
    implementation("org.springframework:spring-context-support:6.1.12")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    // jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("mysql:mysql-connector-java:8.0.33")
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:1.9.25")
    // querydsl
    implementation("com.querydsl:querydsl-jpa:$querydslVersion:jakarta")
    kapt("com.querydsl:querydsl-apt:$querydslVersion:jakarta")
}

kapt {
    javacOptions {
        option("querydsl.entityAccessors", true)
    }
    arguments {
        arg("plugin", "com.querydsl.apt.jpa.JPAAnnotationProcessor")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.jar {
    enabled = false
}
