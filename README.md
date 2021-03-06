[![official JetBrains project](https://jb.gg/badges/official.svg)](https://confluence.jetbrains.com/display/ALL/JetBrains+on+GitHub)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)


# Hands-On Initiator Command Line Tool

A simple command line tool (currently only works on macOS) to create the necessary structure for new 
Hands-On tutorials. 

## Usage

Configure the parameters for your hands-on tutorial using a JSON configuration file with the following format

```json
{
  "title": "Introduction to Ktor",
  "projectName": "introduction-to-ktor",
  "pathHandsOn": "./hands-on",
  "pathProject": "./hands-on-project",
  "pre": [
    {
      "text": "How to set up a project",
      "link": "https://play.kotlinlang.org/hands-on/how-to"
    },
    {
      "text": "How to start a server",
      "link": "https://play.kotlinlang.org/hands-on/start-server"
    }
  ]
}
``` 

It will create all the necessary files for you and all you need to do is to fill in some TODOs and push to GitHub. Of course, you'll
also need to write the contents and projects! 

## Building the project

This is a Kotlin/Native project that targets macOS. To build it, simply run

`gradle macosBinaries`

## Binaries

You can binaries on the [Releases](https://github.com/kotlin-hands-on/hands-on-init/releases) page.

## License 

Apache 2.0 


