FROM tomee:8-jre-7.1.0-plume

MAINTAINER piotrowicki@gmail.com

ENV tomee /usr/local/tomee

ADD tomee-cfg.tar.gz .

RUN cp $tomee/tomee-cfg/tomcat-users.xml $tomee/tomee-cfg/tomee.xml $tomee/tomee-cfg/server.xml $tomee/conf && \
    cp $tomee/tomee-cfg/context.xml $tomee/webapps/manager/META-INF && \
    cp $tomee/tomee-cfg/catalina.sh $tomee/bin && \
    cp $tomee/tomee-cfg/mysql-connector-java-8.0.18.jar $tomee/lib

EXPOSE 8080