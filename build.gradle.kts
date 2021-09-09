val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val exposedVersion: String by project
val h2Version: String by project

plugins {
    application
    kotlin("jvm") version "1.5.30"
    id ("org.gretty") version "3.0.6"
    id ("war")
}

group = "com.ravishrajput"
version = "0.0.1"

application {
    mainClass.set("com.ravishrajput.restapi.ApplicationKt")
}

gretty {
    servletContainer = "tomcat9"
    contextPath = '/'
    logbackConfigFile = "src/main/resources/logback.xml"
}


repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-tomcat:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-gson:$ktor_version")
    implementation("io.ktor:ktor-auth:$ktor_version")
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("com.h2database:h2:$h2Version")
    implementation("mysql:mysql-connector-java:8.0.25")
    implementation("io.ktor:ktor-server-servlet:$ktor_version")
    implementation("org.mariadb.jdbc:mariadb-java-client:2.7.4")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
}