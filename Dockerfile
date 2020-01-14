FROM tomee:11-jre-8.0.0-M3-plume

MAINTAINER piotrowicki@gmail.com

ENV CATALINA_HOME /usr/local/tomee

ADD tomee-cfg.tar.gz .

RUN cp $CATALINA_HOME/tomee-cfg/tomcat-users.xml $CATALINA_HOME/tomee-cfg/tomee.xml $CATALINA_HOME/tomee-cfg/server.xml $CATALINA_HOME/conf && \
    cp $CATALINA_HOME/tomee-cfg/context.xml $CATALINA_HOME/webapps/manager/META-INF && \
    cp $CATALINA_HOME/tomee-cfg/catalina.sh $CATALINA_HOME/bin && \
    cp $CATALINA_HOME/tomee-cfg/mysql-connector-java-8.0.18.jar $CATALINA_HOME/lib

COPY target/lotto*.war $CATALINA_HOME/webapps/lotto.war

EXPOSE 8080
