# Lab2 IES
## Lab2.1

### Servlet Containers
If a client needs a dynamic page then the server forwards this request to a container, where the dynamic page is generated. The servlet container is the part of web server which can be run in a separate process.

### Servlet Container States
A servlet Container has 3 states:

* Standalone -> It is typical Java-based servers in which the servlet container and the web servers are the integral part of a single program. 
* In-process -> It is separated from the web server, because a different program runs within the address space of the main server as a plug-in.
* Out-of-process -> The web server and servlet container are different programs which are run in a different process. 

When an application running in a web server receives a request, the Server hands the request to the Servlet Container which in turn passes it to the target Servlet.Servlet Container is a part of the usual set of services that we can find in Java Application Server.


<sub> Although both are called containers, Docker Containers and servlet containers are very different. Docker and other types of containers, usually refer to virtualized envirments to running aplications. Servlet Containers are used in to execute java code at runtime in a server </sub>

### WebServers and Application Servers

Simply put, the core difference is that application servers have full support for the Java EE spec, whereas web servers support a small subset of that functionality. Aplication Severs do what WebServers do and more.

<sub>Maven -> for creating a web app we can user the -DarchetypeArtifactId=maven-archetype-webapp  </sub>

### Apache Tomcat

One of the most popular Web Servers for java development is [Apache Tomcat](https://tomcat.apache.org/)

<sub>For a production environment, you would install Tomcat as a system service/daemon or, even better, as a “dockerized” service. In this case, we will just start and stop from the command line, in the installation folder </sub>

1. Run Appache Tomcat with the shell Script startup.sh in the apache bin folder; 
2. Then we can access the http://localhost:8080/ to see the if the server is installed properly and running.
3. To manage the aplications we can access the Tomcat Web Application Manager with http://localhost:8080/manager/html  (We need to set the password and username to admin admin in the conf/tomcat-users.xml file)
4. We can generate war files with maven
5. We can deploy the war in the server in the Application Manager
6. Every time we change we need to redeploy the new War file

### Building our first servlet

MyFirstServlet extends HttpServlet. This is mandatory because all servlets must be either a generic servlet that extends javax.servlet.GenericServlet or an HTTP servlet that extends javax.servlet.http.HttpServlet.
Overriding doGet() and doPost() methods. These methods are defined in HttpServlet class. Whenever a GET or POST request come, it is mapped to it’s respective method e.g. if you send a HTTP GET request to this servlet, then doGet() method is called.
There are some other useful methods as well which you can override to control the application in runtime e.g. getServletInfo().


## 2.2 Embedded Jetty Server

Jetty Server. The tutorial is veru old, most of it is very outdated and it was very dificult to solve some issues i had but i got it working

<img src="https://github.com/Rafael-Remigio/IES_102435/blob/main/lab2/lab2_2/Screenshot_2022-10-18_00-13-03.png"></img>

## 2.3 Spring Boot

Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".

### Features
* Create stand-alone Spring applications
* Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files)
* Provide opinionated 'starter' dependencies to simplify your build configuration
* Automatically configure Spring and 3rd party libraries whenever possible
* Provide production-ready features such as metrics, health checks, and externalized configuration
* Absolutely no code generation and no requirement for XML configuration

We can build new web app project by using the [Spring Boot Initializer](https://start.spring.io/). This will provide a zip with all the folders and the POM with all the dependencies needed.

We can then run the project using maven commands or the maven web wrapper
```
1. ./mvnw clean install
2. ./mvnw spring-boot:run 
```

After the tutorial from the [Spring example](https://spring.io/guides/gs/serving-web-content/) i got this error
```
javax.servlet.ServletException: Circular view path [greeting]: would dispatch back to the current handler URL [/greeting] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
```
Apparently replacing it with @RestController solved the issue. <sub> Thank your kind stack overflow stranger </sub> [The explanation why](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-controller).

### Building a RESTful Web Service

The @GetMapping annotation ensures that HTTP GET requests to /greeting are mapped to the greeting() method.

@RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method. If the name parameter is absent in the request, the defaultValue of World is used.

**A key difference between a traditional MVC controller and the RESTful web service controller shown earlier is the way that the HTTP response body is created. Rather than relying on a view technology to perform server-side rendering of the greeting data to HTML, this RESTful web service controller populates and returns a Greeting object. The object data will be written directly to the HTTP response as JSON**

The main() method uses Spring Boot’s SpringApplication.run() method to launch an application. There is no web.xml file, either. This web application is 100% pure Java and you did not have to deal with configuring any plumbing or infrastructure.

## 2.4 Movies REST API

I know actually understand how REST api's work. Who knew that actually reading the articles helped?
<img src="https://github.com/Rafael-Remigio/IES_102435/blob/main/lab2/lab2_4/Screenshot_2022-10-18_21-11-04.png"></img>
Now i actually need to do the exercise.

I decided to store movies and the movies themselfs store the quotes in this exercise. It just seems to make more sense in a way to reduce the amount of enteties and in terms of Software design principles.

Each Movie stores a Name, an Array list of quotes and have an identifying id.


<img src="https://github.com/Rafael-Remigio/IES_102435/blob/main/lab2/lab2_4/Screenshot_2022-10-18_22-24-17.png"></img>



Exercise 4 is completed now to the review Questions. 

<sub>note: Spring boot does make things easier but i would stil rather be using python.</sub>


# Review Questions

## A What are the responsibilities/services of a “servlet container”?

    The servlet container is a way to host a servlet, allowing the generation of dynamic pages. The servlet container is a part of the web server that can run in a second proccess and generate theese html pages using java;

### B.Explain, in brief, the “dynamics” of Model-View-Controller approach used in Spring Boot to serve web content. (You may exemplify with the context of the previous exercises.)

* A model contains the data of the application. A data can be a single object or a collection of objects.
* A controller contains the business logic of an application. Here, the @Controller annotation is used to mark the class as the controller.
* A view represents the provided information in a particular format. Generally, JSP+JSTL is used to create a view page. Although spring also supports other view technologies such as Apache Velocity, Thymeleaf and FreeMarker.

* The Front Controller in Spring Web MVC, the DispatcherServlet class works as the front controller. It is responsible to manage the flow of the Spring MVC application.

Stole this anwser from https://www.javatpoint.com/spring-mvc-tutorial


* The Controller is for exemple the MoviesController from exercise 4 wich is resposible with dealing with all the requests, in this case there is only one controller, but there can be more;
* The view is the greeting.html page from exercise 3;
* Model can be the Movie class from exercise 4 for example;
* The front controller in Spring boot is the DispatcherServlet

### C Starter Dependencies
Starter depencies are just dependencies that aggregate commonly used dependencies, this way we don't have to manually add all the dependencies we need. This makes spring boot much easier to use;

### D Which annotations are transitively included in the @SpringBootApplication
* @Configuration, 
* @EnableAutoConfiguration
* @ComponentScan


### E My top 5 Best practices for REST APIdesign

1. Use JSON as the Format for Sending and Receiving Data (I did not do this in my api)
2. Use Nouns Instead of Verbs in Endpoints
3. Name Collections with Plural Nouns (this should be used not only in RestApis but in everything)
4. Provide Accurate API Documentation (not that i will do this but i allways like when other people have good api documentation)
5. Use Status Codes in Error Handling