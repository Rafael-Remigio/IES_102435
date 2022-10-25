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

3.1 c)
* Spring boot is good but omg the documentation is so bad sometimes; for the different javax.validation.constraints we can see the [here](javax.validation.constraints)
* In this case i use phone number as an Int and validate it with min constaint, max constraint and notNull Contraint;
* btw self note the toString() really matters, i lost so much time debugging because i forgot ":" in the toString