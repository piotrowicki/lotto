FROM tomee:8-jre-7.1.0-plume

MAINTAINER piotrowicki@gmail.com

ENV tomee /usr/local/tomee

RUN cp cfg/conf/tomcat-users.xml $tomee/config/conf/tomee.xml $tomee/config/conf/server.xml $tomee/conf && \
    cp cfg/conf/context.xml $tomee/webapps/manager/META-INF && \
    cp cfg/bin/catalina.sh $tomee/bin && \
    cp cfg/lib/mysql-connector-java-5.1.45-bin.jar $tomee/lib

EXPOSE 8080