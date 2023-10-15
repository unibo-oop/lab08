plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.21.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.mvc.SimpleGUI")
}

tasks.javadoc {
    isFailOnError = false
}
