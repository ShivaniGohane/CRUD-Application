# CRUD_Application Assignment
CRUD_Application is an all-encompassing web-based platform designed to facilitate the seamless management of customer data. Offering robust capabilities, it enables user authentication, administration, and flexible customer search functionalities based on diverse criteria.

# Technologies Used
 - Backend: Java Spring Boot
 - Frontend: HTML, CSS, JavaScript
 - Database: MySQL
 - Security: Spring Security with JWT authentication

## Getting Started

To run the application locally, follow these steps:

   1. Clone this repository to your local machine.
   2. Navigate to the `frontend directory` and open the `index.html` file in your web browser to access the login page.
   3.  Log in with the following credentials:
       * Username: shivani
       * Password: Welcome@123
   4. Once logged in, you can access other functionalities provided by the application.

## Features
* User Authentication: Admin user can log in using their credentials.
* User Management: Admin users can add, update, and delete customer information.
* Search Functionality: Users can search for other customer based on different criteria such as city, phone, first name, or email.

## Setup
Make sure you have MySQL installed on your system. Update the `application.properties` file in the backend directory with your MySQL database credentials: `"properties spring.datasource.url=jdbc:mysql://localhost:3306/customerdb?createTableIfNotExists=true spring.datasource.username=root spring.datasource.password=Shivani@123 spring.jpa.hibernate.ddl-auto=update. "`

## Usage
After setting up the database configuration, run the application. You can access the frontend by opening the `index.html` file in your web browser and logging in with the provided credentials.

## Contributing
Contributions are welcome! If you'd like to contribute to this project, please fork the repository and create a pull request.

## License
This project is licensed under the MIT License. See the LICENSE file for details.
