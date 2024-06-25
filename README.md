# Weather Forecast API 🌤️

## Project Overview

This project is a Spring Boot application that exposes a RESTful API for retrieving weather forecasts. It utilizes the WeatherAPI service to fetch weather data and presents the forecast for the next 3 days for the 5 biggest cities in Poland.

This project was developed as a business task for a recruitment process at Volvo Group.

## Features

- **Weather Forecast**: Provides weather forecast for specific location *for the next 3 days.
- **Major Cities in Poland**: Includes forecasts for the 5 biggest cities in Poland *for the next 3 days.

###### *Duration can be changed by query

## API Endpoints

More details can be found in the Swagger documentation.

### GET /api/v1/forecast
<img width="1073" alt="Image: GET /api/v1/forecast" src="https://github.com/Flop3r/WeatherForecastAPI/assets/43756755/6e1bab9e-58c5-4125-99b7-e869e8ea088f">


### GET /api/v1/forecast/largest-cities
<img width="1060" alt="Image:  GET /api/v1/forecast/largest-cities" src="https://github.com/Flop3r/WeatherForecastAPI/assets/43756755/ef196c8f-8acc-4583-bfcb-ef0d3cda3ef7">


## Swagger Documentation
Swagger documentation is available once the application is running. You can view the API documentation by navigating to:
```
http://localhost:8080/swagger-ui/index.html
```

# Getting Started 🚀

### Clone the Repository

```
git clone https://github.com/Flop3r/WeatherForecastAPI
cd WeatherForecastAPI
```

## Running the Application


### Using Docker (Recommended)

Run Docker Daemon or Docker Desktop

A Dockerfile is provided for containerized deployment. To build and run the Docker container:

```
docker build -t weather-forecast-api .
docker run -p 8080:8080 weather-forecast-api
```
Alternatively, you can use docker-compose for building and running the application:

```
docker-compose up --build
```

#### Makefile
You can use the Makefile to build and run the application in Docker container:

```
make docker
```


---

### Using Maven

To build the project, use the Maven wrapper included in the repository:

```
./mvnw clean install
```

Run the application:
```
./mvnw spring-boot:run
```
#### Makefile
You can also use the Makefile to build and run the application:

```
make maven
```

## Deployment
For deployment, a `deploy.sh` script is provided. This script will build and deploy the application using Docker:

``` 
./deploy.sh
```

## Configuration

### Weather API Key
The application requires an API key from WeatherAPI to fetch weather data. You can configure the API key in `application.properties`:

```
weatherapi.key=YOUR_API_KEY
```

## Prerequisites

- Java 17
- Maven
- Docker (optional, for containerized deployment)


## License

This project is licensed under the MIT License.
