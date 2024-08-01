import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
    id("org.danilopianini.gradle-java-qa") version "1.60.2"
}

repositories {
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.3")

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.3")
}

spotbugs {
    omitVisitors.set(listOf("UnreadFields"))
}

tasks.withType<Test> {
    // Use junit platform for unit tests
    useJUnitPlatform()
    testLogging {
        events(*(TestLogEvent.values())) // events("passed", "skipped", "failed")
    }
    testLogging.showStandardStreams = true    
}
