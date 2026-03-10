plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("jakarta.xml.bind:jakarta.xml.bind-api:4.0.5")
    implementation("org.glassfish.jaxb:jaxb-runtime:4.0.6")
}

application {
    mainClass = "com.mygamelist.Main"
}
