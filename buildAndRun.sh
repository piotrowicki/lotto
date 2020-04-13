#!/bin/sh
mvn clean package && docker build -t lotto-image . 
docker rm -f lotto || true && \
docker run -d \
    -p 8080:8080 -p 8000:8000 \
    -e JPDA_ADDRESS=*:8000 -e JPDA_TRANSPORT=dt_socket \
    --network="docker_app-tier" \
    --name lotto lotto-image \
    /usr/local/tomee/bin/catalina.sh jpda run