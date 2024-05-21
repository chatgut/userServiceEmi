# User Service

Runs on port 8083 with a MySQL database on port 3306.

## Getting Started
How to run:

Clone the repository and run the following command: docker compose up

## Endpoints
The following endpoints are available:

### Endpoint: GET /users

Returns an array of users, or an empty array if no users are found.

### Endpoint: GET /users/{userID}

Returns user profile information:
- User name
- First name
- Last  name
- Profile picture
- Number of posts

### Endpoint: POST /users

Creates a new user.

Example:
````

{
    "userName": "Emi",
    "firstName": "Emmelie",
    "lastName": "Johansson",
    "imageUrl": "https://http.cat/201"
}
````
User name has to be unique. Image url is optional.

Response:
- 201 Created if user is created.
- 409 Conflict if username already exists




