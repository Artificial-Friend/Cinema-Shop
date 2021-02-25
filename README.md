# Space 

1. [Description](#description)
2. [Application Structure](#application-structure)
3. [Technologies](#technologies)
4. [Running the Application](#running-the-application)

---
# Description
This application is an example of an online store, where users can buy tickets to a flights.
***
# Technologies
- Frameworks:
    - Spring (Web, MVC, Security);
    - Hibernate;
- PostgreSQL;
- Java Core;
- Jackson;
- Apache Tomcat;
- Apache Maven;

***
# Application Structure
Application is based on the N-tier architecture. Application has been developed according to SOLID principles.
If you look at the project, you will find there:
- Models;
- DAO layers;
- Service layers;
- Controllers layers;

Project contains 2 authority roles - USER and ADMIN:

-   USER can:
    - Register on the Application;
    - Log in to the Application;
    - Add tickets for flight to a shopping cart;
    - Complete his order;
    - View the history of his order;
-  ADMIN has any rights for POST, PUT, DELETE and GET methods for any endpoints.

***
# Running the Application
1. Download and Install [JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
2. Download and Install servlet container([Tomcat](https://tomcat.apache.org/download-80.cgi), [Jetty](https://www.eclipse.org/jetty/download.php), etc.);
3. Database:
    -   Use as is with default remote database connection settings.
        -   OR
    -   Download and Install [PostgreSQL](https://www.postgresql.org/download/) and set up a connection in the db.properties file;
4. There are two users hardcoded, to log in as admin use 'admin' as login and password;
5. Run application;
6. To make tests more comfortable, you can download a [Postman application](https://www.postman.com/downloads/);
***
#### Author: Monchakivskyi Oleksii