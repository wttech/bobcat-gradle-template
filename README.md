# Bobcat Gradle Template

This repository contains a Gradle template that can be used to generate Bobcat projects.

This template replaces previous Maven archetypes.

### Usage guide

1. Download or clone this project

2. In just created local version of Bobcat Gradle Template run:
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

>If you are working on Windows please note Git Bash console is not supporting gradle by default. On Windows you can use CMD.
  
3. Enter required variables (group name, project name, version name) in interactive mode. Package name will be created from concatenation of group and project name.
4. Start writing your tests in Bobcat!

### How to verify if everything works?
1. Choose your way [how to run](https://cognifide.github.io/bobcat/docs/configuring-bobcat/) Bobcat test
2. Run sample test (i.e. WikipediaTest from default template)

Now you are ready to [write](https://cognifide.github.io/bobcat/docs/first-test/) your Bobcat tests!