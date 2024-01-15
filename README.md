# Project description

Your client, who is involved in managing secret contacts, has a problem. They urgently need a minimalist information system for this purpose. After discussing possible solutions with the client and architect, you both agree that this solution cannot be long-term but rather temporary, meeting minimal requirements.

### Client Requirements

- Can view contact records.
- Can add new contact records.
- Contact records should store the contact's real name, secret code-name, and phone number.
- The solution should be accessible through a web browser.

### Technical Requirements

- The information system must have a REST API that supports JSON data format for integration with other systems.
- Backend technology is preferably Java.
- JavaScript user interface that communicates with the information system's REST API for adding and displaying records (no need to think about design or styling). You can also use your chosen JavaScript framework.
- The solution must support contact names with all possible symbols.
- User and contact data are stored in a PostgreSQL database.
- Bonus: Users can search for contacts.

### Setting Up and Running the Application

## Table of Contents
- [Prerequisites](#prerequisites)
- [Setup](#setup)
    - [Java Backend](#java-backend)
    - [Vue.js Frontend](#vuejs-frontend)
- [Running the Application](#running-the-application)
- [Accessing the Application](#accessing-the-application)
- [Database Setup](#database-setup)

## Prerequisites

* Java 17
* Node.js and npm
* PostgreSQL
* An IDE like IntelliJ IDEA or Visual Studio Code

## Setup

### Java Backend
1. Copy repository to your local machine.
    ```
    cd project-directory
    ```
2. Open the project in IntelliJ IDEA.
3. Make sure you have Maven installed, and IntelliJ recognizes the project as a Maven project.
4. Update the application.properties file with your PostgreSQL database configuration.
5. Build the project to download dependencies and compile the code.
   ````
   mvn clean install
   ````

###  Vue.js Frontend

1. Navigate to the frontend directory within the project.

    ````
    cd frontend
    ````
2. Install project dependencies using npm.
    ````
    npm install
    ````
   
## Running the Application
### Java Backend

1. Start the Spring Boot application from IntelliJ IDEA or use the following Maven command from the project root directory:
    ````
    mvn spring-boot:run
    ````
2. Vue.js Frontend

    In the frontend directory, start the Vue.js development server:
    ````
    npm run serve
    ````

## Accessing the Application

   * The Java backend should be running on http://localhost:8080.
   * The Vue.js frontend should be running on http://localhost:8081.

## Database Setup

* Your PostgreSQL database should be configured as per the application.properties file.
