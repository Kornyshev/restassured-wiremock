# RestAssured + WireMock Learning Project
## Overview
This project is a simple example demonstrating how to use RestAssured for API testing and WireMock for mocking HTTP services. It is designed to help you understand the integration of these two tools for creating effective and isolated tests for your RESTful APIs.

## Project Structure
- SomeApiTests: This class contains a test that uses WireMock to mock an HTTP service and RestAssured to send a request to the mocked service.
- ApiClient: A utility class that uses RestAssured to build and send HTTP requests.
- MockedServiceController: A service controller that uses ApiClient to interact with the mocked service.
- MockResponse: A simple POJO representing the response from the mocked service.

## Getting Started
### Prerequisites
- Java 17
- Maven 3.x

## Setup
- Clone the repository:
`git clone https://github.com/yourusername/restassured-wiremock-learning.git`
- Navigate to the project directory:
`cd restassured-wiremock-learning`

## Running Tests
- Run the tests:
`mvn test`
- You can run command to get Allure report after test execution:
`mvn clean test site`

## Project Components

### SomeApiTests
This class demonstrates how to set up a WireMock server, create a stub for a specific endpoint, and use RestAssured to send a request to the mocked endpoint.
- setUp(): Starts the WireMock server before each test.
- exampleTest(): Defines a stub for the endpoint /test and asserts the response using RestAssured.
- tearDown(): Stops the WireMock server after each test.

### ApiClient
A helper class for building and sending HTTP requests using RestAssured.
- Builder: A nested static class used for building ApiClient instances with custom configurations such as headers and query parameters.
- sendRequest(): Sends an HTTP request to the specified endpoint and validates the response status code.

### MockedServiceController
A service layer class that uses ApiClient to send a GET request to the mocked /test endpoint and returns the response as a MockResponse object.

### MockResponse
A simple data class representing the structure of the JSON response from the mocked service. It uses Lombok annotations for boilerplate code reduction and Jackson annotations for JSON parsing.

## Usage
- Modify the Config class: Ensure the base URL is set correctly for your testing environment.
- Add new tests: Create additional test methods in SomeApiTests to cover more scenarios.
- Customize stubs: Modify or add new WireMock stubs to simulate different responses and behaviors from the mocked service.

## Technologies Used
- Java 17: The programming language used for this project.
- Maven: A build automation tool used for managing project dependencies.
- JUnit 5: The testing framework used to run the tests.
- WireMock: A tool for mocking HTTP services.
- RestAssured: A library for testing and validating REST APIs.
- Lombok: A library that helps reduce boilerplate code.
- Jackson: A library for processing JSON data.
- Allure: A framework for creating test reports.