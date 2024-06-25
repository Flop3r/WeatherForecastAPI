
.PHONY: maven docker 

# Cel, który korzysta ze zmiennej TARGET
docker:
	mvn clean package && mvn install && docker-compose up --build

maven:
	mvn clean spring-boot:run