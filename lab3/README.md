# LAB 03

## Ex 3.1

### JPA Jakarta Pesistence API
* As a specification, the Jakarta Persistence API (formerly Java Persistence API) is concerned with persistence, which loosely means any mechanism by which Java objects outlive the application process that created them.
* In JPA, you define your persistence rules in the realm of Java code and objects, whereas JDBC requires you to manually translate from code to relational tables and back again.


Spring Boot makes it easy to create CRUD applications through a layer of standard JPA-based CRUD repositories.

The Data Access Object (DAO) pattern is a structural pattern that allows us to isolate the application/business layer from the persistence layer (usually a relational database but could be any other persistence mechanism) using an abstract API.

###  CRUD web application using Spring Boot

Layers
* The Domain Layer -> Classes modelling the domain layers are annotated with the class **@Entity** annotation. The **@NotBlank** constrain makes fields no be blank by using the **Hibernate Validator** for validating the constrained fields before persisting or updating an entity

* The Repository Layer -> To provide our application with basic CRUD functionality on User objects, we just need to **extend the CrudRepository** interface and use the **@Repository** annotation. To use **CrudRepository** we have to create our interface and extend CrudRepository. We don't need to implement our interface, its implementation will be created automatically at runtime. 

* The Controller Layer -> Controllers classes will suffice for handling GET and POST HTTP requests and then mapping them to calls to our Repository implementation. Use the **@Controller** anottation

* The View Layer -> The view layer is located in the *src/main/resources/templates* folder, and is the "frontend" of our aplication in this case. For simplicity's sake, the templates look rather skeletal and only provide the required functionality without adding unnecessary cosmetics in this project.


## 3.2 b)

* To use CrudRepository in our Spring data application we need to create an interface implementing CrudRepository. Spring boot can automatically detect our repository if the package of that interface is the same or sub-package of the class annotated with @SpringBootApplication. Then the repository is created at runtime. and there is only one entity.

* The UserController invoques the following methods from UserRepository:
    1. findAll()
    2. save(User entity)
    3. findById(long id)
    4. delete(User entity)
        
    All of these methods are defined in the CrudRepository interface, and they don't need to be changed or implemented.
    
*  Unless we specificaly specify a database where the data can be saved, all the data is going to be saved only in memory and will only persist during run time

* as noted befor the **@NotBlank** constrain makes fields no be blank by using the **Hibernate Validator** for validating the constrained fields before persisting or updating an entity

## 3.1 c)
* Spring boot is good but omg the documentation is so bad sometimes; for the different javax.validation.constraints we can see the [here](javax.validation.constraints)
* In this case i use phone number as an Int and validate it with min constaint, max constraint and notNull Contraint;
* btw self note the toString() really matters, i lost so much time debugging because i forgot ":" in the toString


## 3.2 a)

Docker run command 
``` 
docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=secret1 -e MYSQL_DATABASE=demo -e MYSQL_USER=demo -e MYSQL_PASSWORD=secret2 -p 33060:3306 -d mysql/mysql-server:5.7 
```

### REST API using curl
<sub>yes i am using curl, i refuse to install more software in this pc, also learnig how to use curl is praxis</sub>

* get

    ```
    curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://adreess/resource
    ```
    <image src="images/get.png"></image>
* post
    ```
    curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8080/api/v1/employees -d '{"firstName": "Boss", "lastName": "Baby", "emailId": "bossbaby@proton.me"} '   
    ```
    <image src="images/post.png"></image>

* put   
    ```
    curl -H 'Content-Type: application/json' -s -XPUT http://localhost:8080/api/v1/employees/1 -d '{"firstName": "Michael", "lastName": "The BossBaby", "emailId": "bossbaby@proton.me"} '
    ```
    <image src="images/put.png"></image>

* delete
    ```
    curl -H 'Content-Type: application/json' -s -XDELETE http://localhost:8080/api/v1/employees/1  
    ```
    <image src="images/delete.png"></image>



In this case the url is http://localhost:8080/api/v1/"resource"

## 3.2 g)

Spring Data JPA focuses on using JPA to store data in a relational database. Its most compelling feature is the ability to create repository implementations automatically, at runtime, from a repository interface.
In a typical Java application, you might expect to write a class that implements CustomerRepository. However, that is what makes Spring Data JPA so powerful: You need not write an implementation of the repository interface. Spring Data JPA creates an implementation when you run the application.

**Spring is actually just magic**



## 3.3 

docker container for database:

```
rafael@rafael-K55VJ:~/Desktop/LEI/IES_102435/lab3/lab3_3$ docker run --name movieDB-mysql -e MYSQL_ROOT_PASSWORD=secret1 -e MYSQL_DATABASE=demo -e MYSQL_USER=demo -e MYSQL_PASSWORD=secret2 -p 33060:3306 -d mysql/mysql-server:5.7 
```

To add a movie
```
url -H 'Content-Type: application/json' -s -XPOST http://localhost:8080/api/v1/movies -d '{"title": "Boss Baby", "year": 2017} '
```

To add quotes to a movie
```
 curl -H 'Content-Type: application/json' -s -XPUT http://localhost:8080/api/v1/movies/3/addQuote -d '{"value": "We may be small, but we re about to teach grown ups a big lesson."}'  
```


# Review Questions

## a)
A RESTController in Spring Boot is a special verison of Controller
|Controller | RESTController|
| :----:| :----:|
|@Controller is used to mark classes as Spring MVC Controller.|@RestController annotation is a special controller used in RESTful Web services|
|@Controller is used in MVC Java formats|The RestController allows to handle all REST APIs such as GET, POST, Delete, and PUT requests. |
|Allows returning Views|It's not possible to return Views|
|In @Controller, we need to use @ResponseBody on every handler method.|In @RestController, we don’t need to use @ResponseBody on every handler method.|


## c) 
The annotations Table Column and Id are all JPA Data annotations
* Table refers to the name of the SQL/JPA table
* Column allows us to change the name and other configurations the specific column
* Id indicates the primary key of a Table
* Entity means that a class will be mapped and managed by JPA
