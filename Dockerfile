FROM openjdk:8-jdk-alpine

RUN wget -O dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'

COPY build/libs/*SNAPSHOT.jar app.jar

ENV DD_ENV=dockerloclhost
ENV DD_SERVICE=ch-bff
ENV DD_VERSION=0.1
ENV DD_LOGS_INJECTION=true
ENV DD_TRACE_DEBUG=false
ENV DD_JMXFETCH_ENABLED=true
ENV DD_TAGS=xom_org:FLCIT,xom_env:tootest,xom_app_support_group:tocomplete,xom:app_name:china_oneconnect,xom_app_id:APP-12070,xom_hosting_env:alibaba,xom_hosting_type:paas

LABEL "com.datadoghq.ad.logs"='[{"source":"java","service":"ch-bff", "log_processing_rules": [{"type": "multi_line", "name": "log_start_with_date", "pattern" : "\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])"}]}]'

CMD ["java","-javaagent:/dd-java-agent.jar","-jar","/app.jar"]


