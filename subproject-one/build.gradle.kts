plugins {
    id("net.serenity-bdd.serenity-gradle-plugin") version "3.2.0"
    kotlin("jvm") version "1.6.20"
    kotlin("plugin.spring") version "1.6.20"

    idea
}

defaultTasks("clean", "test", "aggregate")

group = "org.zing"
version = "1.0-SNAPSHOT"

val serenityCoreVersion = "3.2.5"
val junitVersion = "5.8.2"
val assertJVersion = "3.22.0"
val logbackVersion = "1.2.10"
val slf4jVersion = "1.7.7"

val filesLocation = "./src/test/resources"

repositories {
    mavenCentral()
    mavenLocal()
}

serenity {
    this.reports = listOf("single-page-html")
}

dependencies {
    implementation("net.serenity-bdd:serenity-core:${serenityCoreVersion}")
    implementation("net.serenity-bdd:serenity-screenplay:${serenityCoreVersion}")
    implementation("net.serenity-bdd:serenity-ensure:${serenityCoreVersion}")
    implementation("net.serenity-bdd:serenity-screenplay-webdriver:${serenityCoreVersion}")
    implementation("net.serenity-bdd:serenity-junit5:${serenityCoreVersion}")

    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testImplementation("org.assertj:assertj-core:${assertJVersion}")
    testImplementation("ch.qos.logback:logback-classic:${logbackVersion}")
    testImplementation("net.serenity-bdd:serenity-ensure:${serenityCoreVersion}")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
}

println("This is executed druing the configuration phase.")

tasks.register("configured") {
    println("registered configured task")
    repeat(4) { print("$it ")}
}

tasks.withType<Test> {
    doLast{
        println("This is executed during the execution phase. ttt")
    }
}

tasks.register("testBoth") {
    dependsOn("loadfile")
    doFirst {

        println("This is executed first during the execution phase.")
    }
    doLast{
        println("This is executed last during the execution phase.")
    }
    println("This is executed during the configuration phase as well, because :testBoth is used in the build.")
}

tasks.register("checksum") {
    doLast {
        fileList(filesLocation)?.forEach { file ->
            ant.withGroovyBuilder {
                "checksum"("file" to file, "property" to "cs_${file.name}")
            }
            println("${file.name} Checksum: ${ant.properties["cs_${file.name}"]}")
        }
    }
}

tasks.register("loadfile") {
    doLast {
        fileList(filesLocation)?.forEach { file ->
            ant.withGroovyBuilder {
                "loadfile"("srcFile" to file, "property" to file.name)
            }
            println(" *** ${file.name} ***")
        }
    }
}

fun fileList(dir: String): List<File>? = file(dir).listFiles { file: File -> file.isFile
}?.sorted()

//tasks.test {
//    useJUnitPlatform()
//    testLogging.showStandardStreams = true
//}
//
//tasks.withType<KotlinCompile> {
//    kotlinOptions.jvmTarget = "1.8"
//}
//
//tasks.withType<Test> {
//    useJUnitPlatform()
//    this.testLogging {
//        showStandardStreams = true
//        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
//        events("skipped", "failed")
//    }
//}

//tasks.register("copyPropsFile") {
//    if (!this.project.hasProperty("environment")) {
//        ext.set("environment", "dev")
//    }
//    copy {
//        from(projectDir + "../conf/" + ext.get("environment") + "/properties/serenity.properties", projectDir )
//    }
//
//    doLast {
//        if (project.hasProperty("tags")) {
//            println("JUnit tags set to: ${this.project.property("tags")}");

//            ant.invokeMethod("PropertyFile", mapOf(
//                "file" to "${this.project.projectDir}/serenity.properties"
//            ))
//            {
//                ant.invokeMethod("entry", mapOf(
//                    "key" to "tags",
//                    "value" to "${this.project.property("tags")}"
//                ))
//            }

//            ant.propertyfile(file("${this.project.projectDir}/serenity.properties")) {
//                entry(key("tags"), value("${this.project.property("tags")}"))
//            }
//        }
//    }

//}

//tasks.withType<ProcessResources> {
//    dependsOn("copyPropsFile")
//    copyPropsFile.execute()
//}
