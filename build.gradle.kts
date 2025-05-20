plugins {
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // validation
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // configuration
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    // web
    implementation("org.springframework.boot:spring-boot-starter-web")

    // lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // db connector
    implementation("mysql:mysql-connector-java:8.0.28")
    runtimeOnly("com.mysql:mysql-connector-j")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.3")

}

tasks.test {
    useJUnitPlatform()
}