# User Service

Runs on port 8083 with a MySQL database on port 3306.

## Getting Started
How to run:

Clone the repository and run the following command: docker compose up

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

