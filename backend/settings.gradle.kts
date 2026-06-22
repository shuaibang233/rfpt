pluginManagement {
    repositories {
        maven("https://maven.aliyun.com/repository/public")
        maven("https://maven.aliyun.com/repository/spring")
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        maven("https://maven.aliyun.com/repository/public")
        maven("https://maven.aliyun.com/repository/spring")
        mavenCentral()
        maven {
            url = uri("https://packages.aliyun.com/6a0e7b2c7b6e0a0129639206/maven/zy-common")
            credentials {
                username = providers.gradleProperty("mavenUsername")
                    .orElse(providers.environmentVariable("MAVEN_USERNAME"))
                    .orNull
                password = providers.gradleProperty("mavenPassword")
                    .orElse(providers.environmentVariable("MAVEN_PASSWORD"))
                    .orNull
            }
        }
    }
}

rootProject.name = "rf-backend"

include("services:rf-mng:rf-mng-api")
include("services:rf-mng:rf-mng-provider")
include("services:rf-performance:rf-performance-api")
include("services:rf-performance:rf-performance-provider")
