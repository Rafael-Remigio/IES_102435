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
