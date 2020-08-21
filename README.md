# Product Reader

Tool to read the product details from CSV file.

## Prerequisites

* Java 11
* Maven 3.2.*
* Docker(Optional)

## Usage
1) Import the project as Java maven project into IDE.
3) Compile and build the the code using ```./mvnw clean install```
4) Run application locally using ```./mvnw spring-boot:run```
5) Or build it and run it as Java application from ProductReaderApplication.java class.
6) Application should be running now at http://localhost:8081.

## Docker (Optional)
* Run the following command to create and run the image
```
docker build -t product-reader:1.0 .
docker run -p 8081:8081 product-reader:1.0
```

## API Usage
* To use the API, hit the API URL http://localhost:8081/product (GET)
* It will show the product details in response as JSON format.

## Swagger
* Swagger can be accessed at http://localhost:8081/swagger-ui.html to see the API usage.

## Health Check EndPoint
* The production ready features like health check is implemented for the tool.
* The health check can be performed with the help of URL:
```http://localhost:8081/actuator/health```

* This will show if the tool is up or down. Example response:
```{"status":"UP"}```
