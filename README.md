# JavaGameAssignment
This repository is for the Natwest Group internship assignment. (Rock, Paper and Scissors).


## Requirements

JDK 17 <br>
Spring Boot 2.7.6 <br>
Swagger 2.7.0 <br>
Maven <br>
Tomcat server 9 <br>

---

## To run the application

Run `com.raj.natwest.NatwestApplication` java file inside src->main->java folder.

## To run test cases

Run `com.raj.natwest.NatwestApplicationTests` java file inside src->main->test folder.

---

## API working

- There is only one REST endpoint, which is '**/game/play**' and it accepts only one request parameter '**playerMove**'.
- The application runs on port 8080, which can be changed from `application.properties`.
- The URL is: http://localhost:8080/game/play?playerMove=Rock

<p align="center" width="100%">
    <img width="90%" src="https://user-images.githubusercontent.com/65818124/208313693-de4c4736-4799-4078-929a-0c982935bb82.png">
</p>

---

## Swagger UI

- To access swagger-ui go to: http://localhost:8080/swagger-ui.html

<p align="center" width="100%">
    <img width="90%" src="https://user-images.githubusercontent.com/65818124/208313719-7a1a1ac2-a216-43e8-a909-82c9d8f968c8.png">
</p>

---
