#FROM openjdk:8-jdk-alpine
#
##RUN wget -O dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'
##
#COPY build/libs/*SNAPSHOT.jar app.jar
##
##ENV MYSQL_HOST=host.docker.internal
##ENV DD_AGENT_HOST=host.docker.internal
###ENV DD_SOURCE=java
###ENV DD_ENV=occ-tootest
###ENV DD_SERVICE=ch-bff-dd
###ENV DD_VERSION=0.1
##ENV DD_LOGS_INJECTION=true
##ENV DD_TRACE_DEBUG=false
##ENV DD_JMXFETCH_ENABLED=true
##ENV DD_PROFILING_ENABLED=true
#
##ENV DD_TAGS=xom_org:FLCIT,xom_env:tootest,xom_app_support_group:tocomplete,xom:app_name:china_oneconnect,xom_app_id:APP-12070,xom_hosting_env:alibaba,xom_hosting_type:paas
#
##LABEL "com.datadoghq.ad.logs"='[{"source":"java","service":"ch-bff-dd", "log_processing_rules": [{"type": "multi_line", "name": "log_start_with_date", "pattern" : "\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])"}]}]'
##LABEL "com.datadoghq.ad.logs"='[{"source":"java","service":"ch-bff-dd"}]'
#
##CMD ["java","-javaagent:/dd-java-agent.jar","-jar","/app.jar"]
#
#CMD ["java","-jar","/app.jar"]


#/////////////////////////

FROM openjdk:8-jdk-slim AS build-env
WORKDIR /app
COPY build/libs/*SNAPSHOT.jar app.jar

FROM gcr.io/distroless/java:8
COPY --from=build-env /app /app
WORKDIR /app
CMD ["app.jar"]
