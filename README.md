# SpringBootTest

After opening project in and IDE (in my case I used IntelliJ) it should be runnable.

While running we can check h2-console at "http://localhost:8080/h2-console/".
If we set the JDBC URL to "jdbc:h2:mem:todoDB",
  User Name to "sa" and leave out Password then we should be able to connect.
Here we can see the database

I was using Postman for testing the API routes.
First we should paste the generated security password from the project
Example requests
Requesting GET or POST on "http://localhost:8080/api/users/" we can see all the users or createing new ones
  (for posting users we should select body -> raw -> JSON and add the information for the user, like this:
    {
      "password": "examplepassword",
      "emailAddress": "example@test.com",
      "username": "exampleuser"
    }
  )
And also we can edit or delete the user with the given id with POST and DELETE at "http://localhost:8080/api/users/{id}"
To upload or get the profile picture of a user we can send a PUT or GET request at "http://localhost:8080/api/users/{id}/profilePicture".
  For posting:
  select body -> form-data and for key we should add "multipartImage",
  select file and for value we can choose the picture we want to upload.

We can do the same basic GET, POST, PUT and DELETE requests for todos too at "http://localhost:8080/api/todos"
and "http://localhost:8080/api/todos/{id}".
Additionally we can also see the todos of a chosen user by
sending a GET request at "http://localhost:8080/api/todos/owner/{id}".

