plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.22.1"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.mvc.BadIOGUI")
}
