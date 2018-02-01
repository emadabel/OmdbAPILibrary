[![](https://jitpack.io/v/emadabel/omdbapilibrary.svg)](https://jitpack.io/#emadabel/omdbapilibrary)

# OmdbAPILibrary
Simple library based on OMDB Api, to get movies information. (https://www.omdbapi.com/) for android applications.

# How to use

* To install the library add:

        repositories {
                jcenter()
                maven { url "https://jitpack.io" }
        }
        dependencies {
                compile 'com.github.emadabel:OmdbAPILibrary:v1.0.1'
        }

* Get Api key from (https://www.omdbapi.com/).
* Add Internet permission in Manifest.xml
* Do not use the library from the main thread. (look at the example app to see how to use and all the methods).
