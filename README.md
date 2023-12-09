<!-- ABOUT THE PROJECT -->
## A Bank statement generation app using Java and Spring

This project allow users in a banking application request a PDF file generation of their transactions within a specified time period.

Technologies Used:
* Java 17
* Spring boot
* iTextPdf
* Apache Commons Csv
* Google SMTP mail
* Microsoft Excel/Csv
* Maven
* Postman


### API Documentation

Link:
[API Doc Link]()

### Installation

Below is an example of how you can install and set up the app.

NB: Ensure you have Java 17 installed.

1. Download the project using the link provided
2. Ensure "transactions.csv" file is in correct directory to set up the database. Windows OS allow root path.
    ```sh
    transactions.csv
    ```
3. Build the project
   ```sh
   ./mvnw clean install

4. Start the app
   ```sh
   ./mvnw spring-boot:run
   ```
5. Configuration of email service done with gmail app password and using java mail sender.
   ```sh
   ./mvnw spring-boot:run
   ```


## Architecture Overview
## API Trigger:
The Statement Controller serves as entry point to the application.

## Services
1. Database Service
The CSV file serves as the primary database for the application. The Database Service is responsible for reading and filtering of data based on request.

2. Email Service
The Email Service plays a vital role in communication between the application and users. It handles various email functionalities, including account notifications, transaction alerts, and other relevant communication.

3. PDF Generation Service

The PDF Generation Service is responsible for creating PDF documents, such as account statements, transaction summaries, and other financial reports.

## Solution Implementation
1. Database Service Implementation
The Database Service is implemented using Java and leverages CSV libraries(Apache Commons Csv) for efficient data handling. Used reading and filtering records in the CSV file.
2. Email Service Implementation
The Email Service is implemented using Java and integrates with a reliable email API(Java Mail Sender).
3. PDF Generation Service Implementation

The PDF Generation Service is implemented using Java and utilizes PDF generation libraries(iTextPdf).

# Choice of languages/frameworks
 Java and Spring boot used because of ease of rapid development within time given, less setup time and reduce boilerplate code.
Also it's Dependency Injection and  Inversion of control fits into the single responsibility criteria for the services.

## Bonus
The authentication and authorization can be done by setting up the Spring Security feature and configuring users' request to be filtered before entry into the application.
This can be managed by use of tokens such as JWT(Json Web Token) or 3rd party services.

## Conclusion
This architecture ensures a scalable, maintainable, and efficient system for managing user requests and documentation.





<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.
