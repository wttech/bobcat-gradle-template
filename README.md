# Bobcat Gradle Template

This repository contains a Gradle template that can be used to generate Bobcat projects.

This template replaces previous Maven archetypes.

### Usage guide

1. Download or clone this project

2. Run:
```
gradlew generate -i -Ptarget=<directory_for_project> -Ptemplate=<template_to_use>
```

Both parameters are optional:

- `target` - directory where the Bobcat project will be generated (by default it will be created inside this cloned/downloaded repository)

- `template` - determines which template from the ones available will be used to generate the project (the default template is `bobcat-junit`)

Available templates:

- `bobcat-junit`
- `bobcat-bdd`
- `bobcat-aem-junit`
- `bobcat-aem-bdd`
- `bobcat-appium`

3. Enter required variables in interactive mode. Package name will be created from concatenation of group and project name.
4. Start writing your tests in Bobcat!
