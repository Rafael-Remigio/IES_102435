

Maven Version

	[1mApache Maven 3.6.3[m
	Maven home: /usr/share/maven
	Java version: 11.0.15, vendor: Private Build, runtime: /usr/lib/jvm/java-11-openjdk-amd64
	Default locale: en_US, platform encoding: UTF-8
	OS name: "linux", version: "5.4.0-117-generic", arch: "amd64", family: "unix"

Start maven Project:

	mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false



Standard project structure

	my-app
	|-- pom.xml
	`-- src
	    |-- main
	    |   `-- java
	    |       `-- com
	    |           `-- mycompany
	    |               `-- app
	    |                   `-- App.java
	    `-- test
	        `-- java
	            `-- com
	                `-- mycompany
	                    `-- app
	                        `-- AppTest.java

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


A Build Lifecycle is Made Up of Phases
Each of these build lifecycles is defined by a different list of build phases, wherein a build phase represents a stage in the lifecycle.

For example, the default lifecycle comprises of the following phases (for a complete list of the lifecycle phases, refer to the Lifecycle Reference):

	validate - validate the project is correct and all necessary information is available
	compile - compile the source code of the project
	test - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
	package - take the compiled code and package it in its distributable format, such as a JAR.
	verify - run any checks on results of integration tests to ensure quality criteria are met
	install - install the package into the local repository, for use as a dependency in other projects locally
	deploy - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.

	
	Clean Lifecycle Bindings
		
		mvn clean


Executing in maven
	
	mvn exec:java -Dexec.mainClass="com.example.Main"



For executing with arguments in maven

	mvn exec:java -Dexec.mainClass="what to put here?" -Dexec.args="arg0 arg1 arg2"





-------------------------------------------------------------------------------------------------------------------------





Already know how to use basic git commands but need to learn more about branching:

	https://www.atlassian.com/git/tutorials/learn-git-with-bitbucket-cloud

	https://git-scm.com/book/en/v2/Git-Branching-Basic-Branching-and-Merging
