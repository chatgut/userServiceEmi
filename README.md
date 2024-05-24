# User Service

Runs on port 8083 with a MySQL database on port 3306.

The service is used for:
- Creating a new user profile.
- Updating an existing user profile.
- Getting a user profile by user ID.
- Getting all users profiles.

## Getting Started
How to run:

Clone the repository and run the following command: 
```
docker compose up
```

## Endpoints
The following endpoints are available:

### Endpoint: GET /users/{userID}

Returns user profile information:
    - username
    - first name
    - last name
    - user ID
    - profile picture
    - number of messages

Response:
- 200 OK if user is found.
- 404 Not found if no user with the given ID is found.

### Endpoint: GET /users/all

Returns an array of user profile information for all users, or an empty array if no users are found.

### Endpoint: POST /users

Creates a new user profile or updates a user profile if a user with that user id already exists.

Example:
````

{
    "name": "Emi",
    "imageLink": "https://http.cat/201"
}
````
User name has to be unique. Image url is optional.

Response:
- 200 OK if user is created or updated.
- 409 Conflict if username already exists for a different user.


