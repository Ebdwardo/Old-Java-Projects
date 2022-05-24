plugins {
    id("java")
    id("org.openjfx.javafxplugin") version "0.0.10"
    application
}

group = "com.github.ebdwardo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

javafx {
    version = "17.0.1"
    modules("javafx.controls", "javafx.fxml", "javafx.base")
}
application{
    mainClass.set("Assignment12")
}
dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}