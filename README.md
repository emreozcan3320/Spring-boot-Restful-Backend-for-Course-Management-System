 ![enter image description here](https://pbs.twimg.com/media/DU7GUGCV4AAf90X.jpg)

<p align="center">
	 <img src="https://maven.apache.org/images/maven-logo-black-on-white.png" alt="maven">
</p>



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

##### @PathVariable
Annotation which indicates that a method parameter should be bound to a URI template variable. Supported for `RequestMapping` annotated handler methods.
```java
@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {		
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getSingleTopic(@PathVariable String id) {		
		return topicService.getSingleTopic(id);
	}	
}
```


#### 3. @Service  
```java
@Service
public class VehicleService {
// ...
}
```

Indicates that an annotated class is a "Service", originally defined by [*Domain-Driven Design (Evans, 2003)*](https://www.javaworld.com/article/2078042/java-app-dev/domain-driven-design-with-java-ee-6.html) as "an operation offered as an interface that stands alone in the model, with no encapsulated state."

May also indicate that a class is a "[Business Service Facade](https://www.dineshonjava.com/session-facade/)" (in the Core J2EE patterns sense), or something similar. This annotation is a general-purpose stereotype and individual teams may narrow their semantics and use as appropriate.

> The **Session Facade** pattern’s core application is development of enterprise apps. You can also call it a logical extension of **[GoF designs](https://www.dineshonjava.com/design-patterns_25/)**. The pattern encases the interactions which are happening between the low-level components, which is Entity EJB. It is implemented as a higher level component, Session EJB. After which, it is responsible for providing a common and an only interface in order for the app to function or a part of the app.
> ## Session Facade Pattern
> 
> It also reduces or completely ends the [coupling](https://www.geeksforgeeks.org/coupling-in-java/) between the lower
> level components which in turn simplifies the design. The structure of
> session facade pattern is such that it has client object, session
> facade object, and business object. All of these have certain problems
> to cater and certain tasks to perform.

#### 4. @Autowired

> [*click for detail*](https://www.baeldung.com/spring-autowire)

`@Autowired` Annotations. This annotation allows Spring to resolve and inject collaborating beans into your bean. Autowiring can be used on properties, setters, and constructors.

The annotation can be used directly on properties, therefore eliminating the need for getters and setters:
```java 
@Component("fooFormatter") 
public class FooFormatter {
	public String format() { 
		return "foo"; 
	} 
}
```
```java
@Component 
public class FooService { 
	@Autowired 
	private FooFormatter fooFormatter; 
}
```
In the above example, Spring looks for and injects _fooFormatter_ when _FooService_ is created.



> Resource:
> - [JavaBrains](https://javabrains.io/courses/spring_bootquickstart/) 
> - [bealdung](https://www.baeldung.com/) 
> - [Spring Docs](https://spring.io/docs)
> - [springframework.guru](https://springframework.guru/)
> - [Dinesh on Java](https://www.dineshonjava.com/session-facade/)
> - [GeekForGeek](https://www.geeksforgeeks.org/coupling-in-java/)


