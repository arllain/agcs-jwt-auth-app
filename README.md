# AGCS JWT Authentication API

## About
This is a sample JWT authentication RESTful API.



![](https://img.shields.io/badge/java_11-✓-green.svg)
![](https://img.shields.io/badge/spring_boot-✓-green.svg)
![](https://img.shields.io/badge/h2-✓-green.svg)
![](https://img.shields.io/badge/Hibernate/JPA-✓-green.svg)
![](https://img.shields.io/badge/PostgreSQL-✓-green.svg)
![](https://img.shields.io/badge/jwt-✓-green.svg)
![](https://img.shields.io/badge/swagger_2-✓-green.svg)

***

# Project structure

```
agcs-jwt-auth-app/
 │
 ├── src/main/java/
 │   └── com/arllain/agcsjwtauthapp
 │       ├── config
 │       │   ├── SwaggerConfig.java
 │       │   └── TestConfig.java
 │       │
 │       ├── domain
 │       │   ├── Telephone.java
 │       │   └── User.java
 │       │
 │       ├── dto
 │       │   ├── TelephoneDataDTO.java
 │       │   ├── UserDataDTO.java
 │       │   ├── UserResponseDTO.java
 │       │   └── UserSignInDTO.java
 │       │
 │       ├── exception
 │       │   └── CustomException.java
 │       │
 │       ├── repositories
 │       │   └── UserRepository.java
 │       │
 │       ├── resources
 │       │   └── exception
 │       │   │    ├── AuthorizationException.java
 │       │   │    ├── FieldMessage.java
 │       │   │    ├── ResourceExceptionHandler.java
 │       │   │    ├── StandardError.java
 │       │   │    └── ValidationError.java
 │       │   └── HomeResource.java
 │       │   └── UserResource.java
 │       │
 │       ├── security
 │       │   ├── JwtAuthenticationEntryPoint.java
 │       │   ├── JwtTokenFilter.java
 │       │   ├── JwtTokenFilterConfigurer.java
 │       │   ├── JwtTokenProvider.java
 │       │   └── WebSecurityConfig.java
 │       │
 │       ├── services
 │       │   └── exception
 │       │   │   ├── AuthenticationCustomException.java
 │       │   │   ├── ObjectFoundException.java
 │       │   │   └── ObjectNotFoundException.java
 │       │   └── UserDetailsServiceImpl.java
 │       │   └── UserService.java
 │       │
 │       └── AgcsJwtAuthAppApplication.java
 │
 ├── src/main/resources/
 │   ├── application.properties
 │   ├── application-test.properties
 │   └── banner.text
 │
 │
 ├── .gitignore
 ├── mvnw
 ├── mvnw.cmd
 ├── pom.xml
 └── README.md
```


***

You can access the api in Heroku at: [agcs-jwt-auth-app](https://agcs-jwt-auth-app.herokuapp.com/swagger-ui.html)

<p align="left">
  <img alt="Layout" src=".github/swagger.png" width="1000">
</p>

***

# How to use this code?

1. Make sure you have [Java 11](https://www.java.com/download/) and [Maven](https://maven.apache.org) installed

2. Clone this repository
  
```
$ git clone https://github.com/arllain/agcs-jwt-auth-app
```

3. Navigate into the folder  

```
$ cd agcs-jwt-auth-app
```

4. Install dependencies

```
$ mvn install
```

5. Run the project

```
$ mvn spring-boot:run
```

6. Navigate to `http://localhost:8080/swagger-ui.html` in your browser to check everything is working correctly. You can change the default port in the `application.porperties` file

```properties
server.port=8081
```


7. Make a GET request to `/me` to check you're not authenticated. You should receive a response with a `401` with an `Unauthorized` message since you haven't set your valid JWT token yet.

```
$ curl -X GET "http://localhost:8080/me" -H "accept: */*"
```

8. Make a POST request to `/signin`, with the new user you created or you can use the default user (user@email.com and password 123456), we programatically created to get a valid JWT token

```
$ curl -X POST "http://localhost:8080/signin" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"email\": \"user@email.com\", \"password\": \"123456\"}"
```

9. Add the JWT token as a Header parameter and make the initial GET request to `/me` again

```
$ curl -X GET http://localhost:8080/users/me -H 'Authorization: Bearer <JWT_TOKEN>'
```

10. You should get a similar response to this one, meaning that you're now authenticated

```javascript
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "user@email.com",
  "phones": [
    {
      "number": 34270008,
      "area_code": 81,
      "country_code": "+55"
    },
    {
      "number": 999912248,
      "area_code": 81,
      "country_code": "+55"
    }
  ],
  "created_at": "2020-10-12T14:50:15.692483Z",
  "last_login": "2020-10-12T15:10:54.206899Z"
}
```

11. To create a new user make a POST request to `/signup` to create a new user

```
$ curl -X POST "http://localhost:8080/signup" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"firstName\":\"Arllain\", \"lastName\":\"Silva\", \"email\":\"as@gmail.com\", \"password\":\"123456\", \"phones\":[ { \"number\":\"34568890\", \"area_code\":81, \"country_code\":\"+55\" }, { \"number\":988887888, \"area_code\":81, \"country_code\":\"+55\" } ]}"
```


12. You should get a response with a `400` with an `Bad Request` similar response to this one, meaning validation error

```javascript
{
  "status": 400,
  "msg": "Validation error",
  "timeStamp": 1602516639430,
  "errors": [
    {
      "fieldName": "email",
      "message": "You must enter a valid email"
    }
  ]
}
```

13. You should get a response with a `401` with an `Unauthorized` similar response to this one, meaning validation error

```javascript
{
  "status": 401,
  "msg": "Invalid e-mail or password",
  "timeStamp": 1602517073936
}
```