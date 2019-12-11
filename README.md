# Name
pods

# Description
Basic Spring Boot application based on Hystrix for pods (apod and wpod) that display fun images from NASA and Wikipedia.  
The term `apod` means astronomy picture of the day and the term `wpod` means wikipedia picture of the day.  

## Package structure
Application consists of four main packages:
+ `api` used for the API exposed by the application
+ `domain` used for domain model classes
+ `service` used for the service layer (business classes)
+ `client` used for REST integrations

## Running from command line
Follow these steps to start the application:
+ run `mvn clean install`
+ run `mvn spring-boot:run` or `java -jar target/spring-boot-hystrix-0.0.1-SNAPSHOT.jar` to start the application

## URLs
http://localhost:8080  
http://localhost:8080/hystrix  
http://localhost:9999/actuator/hystrix.stream  

https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY  
https://commons.wikimedia.org/w/api.php?action=featuredfeed&feed=potd&feedformat=rss&language=en  
