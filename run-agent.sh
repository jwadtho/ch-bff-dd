java -javaagent:dd-java-agent.jar \
-Ddd.logs.injection=true  \
-Ddd.service=ch-bff  \
-Ddd.env=toolocalhost \
-Ddd.version=0.1 \
-Ddd.logs.injection=true \
-jar build/libs/bff-0.0.1-SNAPSHOT.jar

