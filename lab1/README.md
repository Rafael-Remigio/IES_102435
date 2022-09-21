

Maven Version

	[1mApache Maven 3.6.3[m
	Maven home: /usr/share/maven
	Java version: 11.0.15, vendor: Private Build, runtime: /usr/lib/jvm/java-11-openjdk-amd64
	Default locale: en_US, platform encoding: UTF-8
	OS name: "linux", version: "5.4.0-117-generic", arch: "amd64", family: "unix"




Naming conventions for Maven

	https://maven.apache.org/guides/mini/guide-naming-conventions.html

	-> groupId uniquely identifies your project across all projects. A group ID should follow Java's package name rules. This means it starts with a reversed domain name you control. For example:

		org.apache.maven, org.apache.commons

	-> artifactId is the name of the jar without version. If you created it, then you can choose whatever name you want with lowercase letters and no strange symbols. If it's a third party jar, you have to take the name of the jar as it's distributed.

		maven, commons-math

	-> version if you distribute it, then you can choose any typical version with numbers and dots (1.0, 1.1, 1.0.1, ...).

		2.0, 2.0.1, 1.3.1


For dependencies see maven repository

	https://search.maven.org/

	

For executing with arguments in maven

	mvn exec:java -Dexec.mainClass="what to put here?" -Dexec.args="arg0 arg1 arg2"

