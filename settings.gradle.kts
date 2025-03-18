plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}

rootProject.name = "kotlin-tradle-project-backend"
include("untitled")
include("auth-service")
include("api-gateway")
include("eureka-server")
include("spring-cloud-config")
