plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.96.1-dev1s-661be4b"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.mvc.LaunchApp")
}

tasks.javadoc {
    isFailOnError = false
}
