#!/bin/bash
mvn clean package && mvn install && docker-compose up --build