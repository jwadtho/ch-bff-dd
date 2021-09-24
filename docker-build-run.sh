# shell

imageBuild=ch-bff:0.1
docker build -t $imageBuild .

docker run -p 127.0.0.1:9300:9300/tcp \
        -e SPRING_PROFILES_ACTIVE=dd  \
        $imageBuild