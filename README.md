# CRUD operation using Spring MVC & JPA 

# Technologies
Java, 
Spring-core, Spring-MVC ,Spring-Security, 
MySql (for rest authentication & insert data),
JPA(ORM),
Html, CSS, Jstl, Maven, Flywaydb Librery

# Use below REST services for CRUD Operation
# 1. CREATE Method:POST 
http://localhost:8080/spring-mvc-jpa-mysql/person </br>
{
	"lastName": "ooasssssss",
	"firstName": "aaaaaaaa",
	"age":"30"
} 
# 2. UPDATE Method:PUT 
http://localhost:8080/spring-mvc-jpa-mysql/person </br>
{
	"lastName": "ooasssssss", 
	"firstName": "aaaaaaaa",
	"email":"sssaa@gmail.com",
	"age":"30",
	"id":"1"
} 
# 3. DELETE Method:DELETE 
http://localhost:8080/spring-mvc-jpa-mysql/person/1
# 4. GET By Id Method:GET
http://localhost:8080/spring-mvc-jpa-mysql/person/1
# 4. GET All Record Method:GET/POST 
http://localhost:8080/spring-mvc-jpa-mysql/person

# Flyway?
Flyway library use to execute db scripts at the time of application running. It helps to migrate database.
