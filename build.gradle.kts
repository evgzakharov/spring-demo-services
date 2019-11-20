import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val springBootVersion by extra("2.2.1.RELEASE")
val kotlinVersion by extra ("1.3.60")
val kotlinCoroutinesVersion by extra("1.3.2")

group = "demo-kotlin-application"
version = "0.0.1"

plugins {
    val kotlinVersion = "1.3.60"

    kotlin("jvm") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion

    id("org.springframework.boot") version "2.2.1.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.7.RELEASE" apply false
}

repositories {
    jcenter()
}

subprojects {
    if (project.name in listOf("service-auth", "service-card", "service-payment", "service-user")) {
        apply(plugin = "kotlin")
        apply(plugin = "kotlin-spring")
        apply(plugin = "kotlin-kapt")
        apply(plugin = "org.springframework.boot")
        apply(plugin = "io.spring.dependency-management")

        repositories {
            jcenter()
        }

        dependencies {
            implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
            implementation("org.jetbrains.kotlin:kotlin-reflect")

            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:$kotlinCoroutinesVersion")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:$kotlinCoroutinesVersion")

            implementation("org.springframework.boot:spring-boot-starter-webflux")

            implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

            kapt("org.springframework.boot:spring-boot-configuration-processor")
        }

        tasks.getByName("compileKotlin").dependsOn("processResources")
    }

    if (project.name == "utils") {
        apply(plugin = "kotlin")

        repositories {
            jcenter()
        }

        dependencies {
            implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
            implementation("org.jetbrains.kotlin:kotlin-reflect")
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict", "-progressive")
            jvmTarget = "12"
        }
    }
}
