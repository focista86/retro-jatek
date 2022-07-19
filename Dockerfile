FROM docker-base-repo.idomsoft.hu/java/openjdk/11/alpine:3.14.2-jdk11.0.11_p9-r0
ADD target/*.jar /app.jar
ENTRYPOINT [ "sh", "-c", "java --enable-preview -Xms128M -Xmx512M -jar /app.jar" ]