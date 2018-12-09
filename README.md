![enter image description here](https://pbs.twimg.com/media/DU7GUGCV4AAf90X.jpg)
![enter image description here](https://maven.apache.org/images/maven-logo-black-on-white.png)

> ***This ReadMe file is about Spring-boot, development process, and the aplication. I keep that notes to assist  my futher project for my personal usage. I use many websites, videos, and tutorial when creating that ReadMe file. You can find that source at the and of file***
> 
# Course Management System

This is a Maven Spring-boot restfull backend project.


 ## Statring
 
 - I use as ide STS ( Spring Tool Suit)
 
 
 - I create a maven project and follow the steps at [Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/) to create a spring-boot project.
 
 # Develpment Notes
 
 ### Main method *@SpringBootApplication* 
 
 Many Spring Boot developers like their apps to use auto-configuration, component scan and be able to define extra configuration on their *"application class"*. ***A single @SpringBootApplication annotation can be used to enable those three features***, that is:
 - **@EnableAutoConfiguration:** enable Spring Boot’s auto-configuration mechanism
 - **@ComponentScan:** enable @Component scan on the package where the application is located (see the best practices)
 - **@Configuration:** allow to register extra beans in the context or import additional configuration classes

The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration, and @ComponentScan with their default attributes, as shown in the following example:

```java
@SpringBootApplication
public class CourseApiApp {
	public static void main(String[] args) {
		// fist argument is i main class which anotated with @SpringBootApplication
		// second argument is the argument that that could been past to the main method
		SpringApplication.run(CourseApiApp.class, args); 
	}
}
```
*That is all we need and this is a spring boot aplication. Run as a java application and you see.* ***` shift+alt+x j `***

### SpringApplication.run(CourseApiApp.class, args);

 - Set up default configuration
 - Starts Spring application context
 - Performs class path scann
 - Starts Tomcat server

### Creating a Controller
#### 1. Spring MVC  _@Controller_

Classic controllers can be annotated with the  _@Controller_  annotation. This is simply a specialization of the  _@Component_  class and allows implementation classes to be autodetected through the classpath scanning.

_@Controller_  is typically used in combination with a  _@RequestMapping_  annotation used on request handling methods.

Let’s see a quick example of the Spring MVC controller:

```java
@Controller 
@RequestMapping("books") 
public class SimpleBookController { 

	@GetMapping("/{id}", produces = "application/json") 
	public @ResponseBody Book getBook(@PathVariable int id) { 
		return findBookById(id); 
	} 
	
	private Book findBookById(int id) 
	{ 
	// ... 
	} 
}
 ```
 The request handling method is annotated with _@ResponseBody_. This annotation enables automatic serialization of the return object into the _HttpResponse_.
 
#### 2. Spring MVC  _@RestController_
_@RestController_ is a specialized version of the controller. It includes the _@Controller_ and _@ResponseBody_ annotations and as a result, simplifies the controller implementation:
```java
@RestController 
@RequestMapping("books-rest") 
public class SimpleBookRestController { 

	@GetMapping("/{id}", produces = "application/json") 
	public Book getBook(@PathVariable int id) { 
		return findBookById(id); 
	} 
	
	private Book findBookById(int id) { 
	// ... 
	} 
}
```

**The controller is annotated with the  _@RestController_  annotation, therefore the  _@ResponseBody_isn’t required.**

Every request handling method of the controller class automatically serializes return objects into  _HttpResponse_.

#### 3. @RequestMapping

> ***[Click For Detailed @RequestMapping Example](https://springframework.guru/spring-requestmapping-annotation/)***

*In Spring MVC applications, the `RequestDispatcher` (Front Controller Below) servlet is responsible for routing incoming HTTP requests to handler methods of controllers.*

When configuring Spring MVC, you need to specify the mappings between the requests and handler methods.To configure the mapping of web requests, you use the @RequestMapping annotation.

The `@RequestMapping` annotation can be applied to class-level and/or method-level in a controller.

The class-level annotation maps a specific request path or pattern onto a controller. You can then apply additional method-level annotations to make mappings more specific to handler methods.

Here is an example of the `@RequestMapping` annotation applied to both class and methods.

```java
@RequestMapping("/home") 
public class IndexController { 

	@RequestMapping("/") 
	String get(){ 
		//mapped to hostname:port/home/ 
		return "Hello from get"; 
	} 
	
	@RequestMapping("/index") 
	String index(){ 
		//mapped to hostname:port/home/index/ 
		return "Hello from index"; 
	} 
}
```
With the preceding code, requests to `/home` will be handled by `get()` while request to `/home/index` will be handled by `index().`

> Resource:
> - [JavaBrains](https://javabrains.io/courses/spring_bootquickstart/) 
> - [bealdung](https://www.baeldung.com/) 
> - [Spring Docs](https://spring.io/docs)
> - [springframework.guru](https://springframework.guru/)


