plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.19.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.mvc.BadIOGUI")
}
