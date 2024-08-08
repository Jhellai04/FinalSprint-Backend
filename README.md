REST API

This program is the backend database / REST API for the React app in our repository: https://github.com/Jhellai04/FinalSprint-Frontend.git.

How To Work the Program:
1. Set Up MySQL:
    Ensure MySQL Workbench is running a local instance.
    Create a database named finals_jelljohn_db or any name you prefer. If you choose a different name, update the name in the application.properties and docker-compose.yml files.

2. Run the Application:
    Once your database is created, run the RestServiceApplication file.
    When the program runs, all tables and relationships will be created automatically in your MySQL database.

3. Authentication:
    This program is set up with basic authentication.
    Username: admin
    Password: admin

4. Testing the API:
    Open Postman and perform a GET request on http://localhost:8080/ to see the available links.
    Ensure you select "Authorization" and choose "Basic Auth", then enter the username and password.

5. Adding Data:
    Once your local instance is working with the database, you can start adding data.
    Data can be added manually using Postman or MySQL Workbench, or you can use the files in database/queryStatements to insert 100 pieces of mock data.
    In MySQL Workbench, copy and paste all the insert statements to add data.
    In Postman, copy and paste the JSON data and use the link http://localhost:8080/vehicle with a POST request.

6. Retrieving Data:
    Use http://localhost:8080/vehicle to get all the data.
    Use http://localhost:8080/vehicle/profile to see all available links.
    Use http://localhost:8080/vehicle/profile/search to explore the different ways to query/search for data.

How to Use with React App:
Simply have this program running with data inserted, and the React app will make calls to the API.