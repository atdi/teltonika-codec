plugins {
    kotlin("jvm") version "2.0.21"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.2"
}

group = "eu.aagsolutions.telematics"
version = "0.1.0-SNAPSHOT"

val slf4jVersion = "2.0.16"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
