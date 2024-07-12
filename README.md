SpringApi

SpringApi is a backend application for an e-commerce website. It provides APIs for CRUD operations on products and includes functionality for fetching images from the database. The application follows the MVC (Model-View-Controller) design pattern.
Table of Contents

    Getting Started
    Prerequisites
    Installation
    Usage
    APIs
    Project Structure
    Built With
    Authors
    License

Getting Started

These instructions will help you set up and run the SpringApi application on your local machine for development and testing purposes.
Prerequisites

Before you begin, ensure you have the following installed on your machine:

    Java Development Kit (JDK) 8 or higher
    Maven 3.6.3 or higher
    MongoDB Atlas (or a local MongoDB instance)
    Git

Installation

    Clone the repository:

    sh

git clone https://github.com/MIBGHOST/SpringApi.git
cd SpringApi

Configure MongoDB:
Update the application.properties file in src/main/resources with your MongoDB Atlas credentials or local MongoDB instance details.

properties

spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.mongodb.net/<dbname>?retryWrites=true&w=majority

Build the project:

sh

mvn clean install

Run the application:

sh

    mvn spring-boot:run

Usage

Once the application is running, you can access the various APIs using tools like Postman or curl.
APIs

The application provides the following APIs:
Product Management

    Create a Product

    http

POST /api/products

Request Body:

json

{
    "name": "string",
    "description": "string",
    "price": "number",
    "image": "base64String"
}

Get All Products

http

GET /api/products

Get a Product by ID

http

GET /api/products/{id}

Update a Product

http

PUT /api/products/{id}

Request Body:

json

{
    "name": "string",
    "description": "string",
    "price": "number",
    "image": "base64String"
}

Delete a Product

http

DELETE /api/products/{id}

Fetch Product Image

http

    GET /api/products/{id}/image

Project Structure

The project follows the MVC design pattern and is structured as follows:

    Model: Contains the entity classes.
    Repository: Contains the interfaces for database operations.
    Service: Contains the business logic.
    Controller: Contains the REST controllers.

Directory Layout

css

src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── springapi/
│   │           ├── controller/
│   │           ├── model/
│   │           ├── repository/
│   │           └── service/
│   └── resources/
│       └── application.properties
└── test/
    └── java/

Built With

    Spring Boot - The framework used for application setup and configuration.
    Spring Data MongoDB - Used for MongoDB integration.
    MongoDB Atlas - Cloud-based MongoDB service.

Authors

    MIBGHOST

License

This project is licensed under the MIT License - see the LICENSE file for details.
