#!/bin/sh
mvn clean package && docker build -t lotto-image . 
docker rm -f lotto || true && docker run -d -p 8080:8080 --network="docker_app-tier" --name lotto lotto-image
