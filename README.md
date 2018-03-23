# Simulation Engine [![Build Status](https://travis-ci.org/juanmbellini/simulation-engine.svg?branch=master)](https://travis-ci.org/juanmbellini/simulation-engine) [![](https://jitpack.io/v/juanmbellini/simulation-engine.svg)](https://jitpack.io/#juanmbellini/simulation-engine)

Library than includes several common classes to be used in System Simulations projects.

## Instructions

The following instructions will make the library available in your project.

1. Add the [Jitpack](https://jitpack.io/) repository in your ```pom.xml``` file:

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

2. Declare the following dependency:

```
<dependency>
    <groupId>com.github.juanmbellini</groupId>
    <artifactId>simulation-engine</artifactId>
    <version>:version:</version>
</dependency>
```
**Note:** You must replace the ```:version:``` placeholder with an actual version of the software. 
You can check versions in [https://github.com/juanmbellini/simulation-engine](https://github.com/juanmbellini/simulation-engine).

Also, you can get the actual snapshot (i.e last commit in master branch) using the ```-SNAPSHOT``` version.
In this case, your ```pom.xml``` will have the following dependency:

```
<dependency>
    <groupId>com.github.juanmbellini</groupId>
    <artifactId>simulation-engine</artifactId>
    <version>-SNAPSHOT</version>
</dependency>
```


## Authors

- [Juan Marcos Bellini](https://github.com/juanmbellini)
- [Matías Fraga](https://github.com/matifraga)