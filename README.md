# AwesomeLib
[![](https://jitpack.io/v/SuperNederen/AwesomeLib.svg)](https://jitpack.io/#SuperNederen/AwesomeLib)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

Simple utilities for your minecraft plugin development experience!

## For Developers

### :exclamation: Implementation:

#### Maven
``` apache maven
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>`
```
``` apache maven
<dependencies>
    <dependency>
        <groupId>com.github.SuperNederen</groupId>
        <artifactId>AwesomeLib</artifactId>
        <version>{VERSION}</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

#### Gradle

``` gradle
repositories {
	maven { url 'https://jitpack.io' }
}
```
``` gradle
dependencies {
	implementation 'com.github.SuperNederen:AwesomeLib:RELEASE'
}
```

* Remember to [soft]depend on AwesomeLib inside your plugin.yml file
