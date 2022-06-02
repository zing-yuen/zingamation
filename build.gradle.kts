import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("net.serenity-bdd.serenity-gradle-plugin") version "3.2.0"
    kotlin("jvm") version "1.6.20"
    kotlin("plugin.spring") version "1.6.20"

    idea
}

defaultTasks("clean", "test", "aggregate")

group = "org.example"
version = "1.0-SNAPSHOT"

val serenityCoreVersion = "3.2.5"
val junitVersion = "5.8.2"
val assertJVersion = "3.22.0"
val logbackVersion = "1.2.10"
val slf4jVersion = "1.7.7"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("net.serenity-bdd:serenity-core:${serenityCoreVersion}")
    implementation("net.serenity-bdd:serenity-screenplay:${serenityCoreVersion}")
    implementation("net.serenity-bdd:serenity-ensure:${serenityCoreVersion}")
    implementation("net.serenity-bdd:serenity-screenplay-webdriver:${serenityCoreVersion}")
    implementation("net.serenity-bdd:serenity-screenplay-junit5:${serenityCoreVersion}")

    testImplementation("net.serenity-bdd:junit-jupiter-api:${junitVersion}")
    testImplementation("org.assertj:assertj-core:${assertJVersion}")
    testImplementation("ch.qos.logback:logback-classic:${logbackVersion}")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
}

tasks.test {
    useJUnitPlatform()
    testLogging.showStandardStreams = true
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform()
    this.testLogging {
        showStandardStreams = true
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        events("skipped", "failed")
    }
}
