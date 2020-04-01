@echo off
call mvn clean package
call docker build -t lotto-image .
call docker rm -f lotto
call run -d -p 8080:8080 --network="docker_app-tier" --name lotto lotto-image
