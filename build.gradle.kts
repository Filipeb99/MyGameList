import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("jakarta.xml.bind:jakarta.xml.bind-api:4.0.5")
    implementation("org.glassfish.jaxb:jaxb-runtime:4.0.9")

    /**
     * JUnit dependency
     * @see https://junit.org/
     */
    testImplementation(platform("org.junit:junit-bom:6.1.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
    mainClass = "io.github.filipeb99.mygamelist.Main"
    applicationDefaultJvmArgs = listOf("-XX:+UseCompactObjectHeaders")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events(
            TestLogEvent.PASSED,
            TestLogEvent.SKIPPED,
            TestLogEvent.FAILED
        )
    }
}
