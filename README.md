# bobcat-gradle-template

### Usage guide
1) Download or clone this project

2) Run:

gradlew generate -i -Ptarget=<directory_for project> -Ptemplate=<template_to_use>

Both parameters are optional:

target - directory where we want to have project (default is "generated" inside project)

template - which template you want to use (default is bobcat-junit)

Available templates:
- bobcat-junit
- bobcat-bdd
- bobcat-aem-junit

3) Enter required variables in interactive mode. Package will be created from concatenation of group and dproject name
