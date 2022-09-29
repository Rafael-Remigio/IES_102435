

Maven Version

	[1mApache Maven 3.6.3[m
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


Log4j
	used a loot in the industry

		Free
		reliable
		versatile
		easily configurable




------------------------------------------------------------------------------------------------------

Why use containers instead of VMs

	Allow running multiple apps in isolation
	are ligthweight
	use OS of the host
	Start quickly
	need less hardware resources

With docker we can package the application with every thing it needs and run it anywhere, on any machine with docker.
This makes deployment very easy, and for working with multiple people makes it much easier to make sure every one is testing and running the same version. Also this way we dont have to spend much time installing dependencies and software

Since docker is a container, we can have different versions of software running on the same machine, because of the virtualization achieved by the container

So docker is good for -> build; run and ship applications



Containers and VMs

	Container -> Isolated environment for running an application
		Give the same isolation as a VM
		dont need a full OS (use Host Kernell (uses the kernell api))
 		lightweight
		Start quickly
		Dont need that many hardware resources


	Virtual Machine -> Abstraction of a machine (abstraction of hardware)
		Problems of VMs -> 	needs a full copy of an OS
							slow start
							resource intensive


Architecture of Docker

	Client server architecture
		uses the OS kernel api 



DOCKERFILE

	Blue print and instructions to build a docker image

IMAGE

	Template for running the docker container

Container

	a running proccess


Docker starting



	create the volume that Portainer Server will use to store its database:
		
		docker volume create portainer_data

	download and install the Portainer Server container:
		docker run -d -p 8000:8000 -p 9443:9443 --name portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer-ce:latest


	Docker ps to list containers







How to make an application be able to be ran by docker

		we make a Dockerfile
			this file will have the instructions to turn this app into an Image
			any developer can then rebuild the image from the docker file and then turn it into a container
			In the docker files we also have commands on how to start and run the application


			We can push images to dockerhub wich is like github for docker, or a regestry of images.

			to create an image we user "docker build -t {name of image} {directory where is dockerfile}"

			To see all the images we have created we can use "docker image ls"

			To run and create the container we can run "docker run {image name}"


			***
				# This is a base image
				# we can see images on docker hub
				FROM node:alpine


				# copies everythin in this directory into the /app directory in the container
				COPY . /app

				# moves us to the app directory, works like the cd command
				WORKDIR /app

				CMD node app.js 
			***


			We can also run a full os and interact with it with the "docker run -it {ubunto for example}"


	
to have code updated we need to have the docker-compose.yml file, and set enviroment variables


--------------------------------------------------------------------------------------------------------
Ex 5)
Maven multiple projects 

	mvn install:install-file    -Dfile=/home/rafael/Desktop/LEI/IES_102435/lab1/lab1_5/demo/target/demo-1.0-SNAPSHOT.jar -DgroupId=com.ies102435 -DartifactId=demo    -Dversion=1   -Dpackaging=jar -DgeneratePom=true # to install on the local mvn repository


	mvn package -U #to force maven to check the local repository




	Cannot complete exercise 1.5

		[ERROR] Failed to execute goal org.codehaus.mojo:exec-maven-plugin:3.1.0:java (default-cli) on project WeatherUI: An exception occurred while executing the Java class. com.ies102435.FrontEnd -> [Help 1]

		I cannot get pass this error with the maven exec plugin, and also can't run the project with the jar. Compiling, testing packaging, installing, every maven pluggin works with no issues. I spent last nigth trying to fix this, and to no conclusion, I understood how to work with dependencies in Maven and imported them properly. 


--------------------------------------------------------------------------------------------------------------------------



    Review Questions 


        a) Default Lifecycle            
            validate: validate the project is correct and all necessary information is available
            compile: compile the source code of the project
            test: test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
            package: take the compiled code and package it in its distributable format, such as a JAR.
            integration-test: process and deploy the package if necessary into an environment where integration tests can be run
            verify: run any checks to verify the package is valid and meets quality criteria
            install: install the package into the local repository, for use as a dependency in other projects locally
            deploy: done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects.
            clean: cleans up artifacts created by prior builds
            site: generates site documentation for this project

        b) Although maven is a building tool it can also be used to execute code; You can run your project on with maven using "mnv exec:"


		c) Firs we need to make sure we are working on an updated version of the project so we fetch/pull (to see and or pull changes from the shared repository)
		After making the feature we can user "git add {files we changed}" to add then to the change files; Then we commit a change with "git commit", commit requires a message that should be descriptive. The commit is only local, to had it to a shared repository or hub we the use "git push"

		d) The advice I have found and usually follow is to first use Capitalization in the first word to see logs better on the terminal ("because i use linux and it makes it more destinct")
		The usage of imperatives is also important, and KeyWords like "Update, fix, Refactor, Rebuilt" are very descriptive and helpfull. Being direct and descriptive is the most important thing. Also should be specific, just saying "Updates to navbar" is very lacking when there could have been 100 changes to the navbar. Something like "Updated Navbar Color in dark mode" is way more descriptive and helpfull
                        

		e) Its important to take an extra step to ensure data persistence; If we want to have the data to be stored after the docker stops running we need to Bind a volume. We can do this using "-v path" in the run command
		Also it allows us to change code locally and having docker running from those local files. We used this in exercice 4 e) by adding a volume location to the docker-compose.yml file



