group = "dev.portero.xenon.core"
version = "1.0.0-SNAPSHOT"

paper {
    main = "${project.group}.CorePlugin"
    apiVersion = "1.20"
    prefix = "Core"
    author = "Portero"
    name = "Core"
    description = "Core plugin for a Roleplay Gamemode"
    version = "${project.version}"
}

dependencies {
    implementation("dev.rollczi:litecommands-bukkit:3.4.0")
}