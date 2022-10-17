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

