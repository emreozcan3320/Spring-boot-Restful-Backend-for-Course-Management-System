
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
		// TODO Auto-generated method stub
	}
}
```
*That is all we need and this is a spring boot aplication. Run as a java application and you see.* ***` shift+alt+x j `***
