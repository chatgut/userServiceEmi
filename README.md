# User Service - Microservice with Spring Boot and MySQL database

Runs on port 8083.

## Getting Started
Start a mySQL docker container:

docker run --name userServiceDB -e MYSQL_ROOT_PASSWORD=verysecret -e 'MYSQL_ROOT_HOST=%' -e MYSQL_DATABASE=user -e MYSQL_USER=myuser -e MYSQL_PASSWORD=secret -v $HOME/var/lib/mysql:/var/lib/mysql -p 3306:3306 mysql:latest

download the image and run the image: docker pull ghcr.io/chatgut/user-service-emi:1

## Endpoints
The following endpoints are available:

### Endpoint: POST /users
- userName
- firstName
- lastName
- imageUrl (optional)

Example:


output: http://localhost:8083/users/1

### Endpoint: GET /users/{id}

Example:

## Responses
POST localhost:8083/users
200 OK if user is created
GET localhost:8083/users/{userToken}
200 OK if there is a user with that token
404 NOT FOUND if there is no user with that token
GET localhost:8083/users/users
200 OK if there is an existing image already uploaded
404 NOT FOUNDif there is no matching image

