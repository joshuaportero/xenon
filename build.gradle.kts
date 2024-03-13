import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import java.util.*

plugins {
    id("java-library")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("net.minecrell.plugin-yml.paper") version "0.6.0"
    id("xyz.jpenilla.run-paper") version "2.2.3"
}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "com.github.johnrengelman.shadow")
    apply(plugin = "net.minecrell.plugin-yml.paper")
    apply(plugin = "xyz.jpenilla.run-paper")

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    }

    repositories {
        mavenCentral()
        maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
        maven { url = uri("https://repo.panda-lang.org/releases/") }
        maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
        maven { url = uri("https://repository.minecodes.pl/releases/") }
        maven { url = uri("https://repository.minecodes.pl/snapshots/") }
        maven { url = uri("https://repo.eternalcode.pl/snapshots/") }
        maven { url = uri("https://repo.eternalcode.pl/releases/") }
        maven { url = uri("https://repo.extendedclip.com/content/repositories/placeholderapi/") }
    }

    dependencies {
        compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    }

    tasks.withType<JavaCompile> {
        options.compilerArgs = listOf("-Xlint:deprecation", "-parameters")
        options.encoding = "UTF-8"
    }

    tasks.withType<ShadowJar> {
        archiveFileName.set("${project.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }}.jar")

        exclude(
            "META-INF/**",
        )
    }

    tasks {
        runServer {
            minecraftVersion("1.20.4")
        }
    }
}