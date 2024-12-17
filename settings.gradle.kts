pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
//        maven { url = uri("https://chaquo.com/maven") }
//        maven { url = uri("https://chaquo.com/maven") }
        maven { url = uri("https://chaquo.com/maven-test") }
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
//        maven { url = uri("https://chaquo.com/maven") }
        mavenCentral()

    }
}

rootProject.name = "ML_app"
include(":app")
 