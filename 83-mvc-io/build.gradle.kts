plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.22.1"
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("com.github.spotbugs:spotbugs-annotations:4.8.0")
}

application {
    mainClass.set("it.unibo.mvc.SimpleGUI")
}

tasks.javadoc {
    isFailOnError = false
}
