FROM docker-base-repo.idomsoft.hu/java/openjdk/11/alpine:3.14.2-jdk11.0.11_p9-r0
ADD target/retro-jatek-1.0.0.jar /app.jar
ENTRYPOINT [ "sh", "-c", "java --enable-preview -Xms$JAVA_XMS -Xmx$JAVA_XMX -XX:MaxMetaspaceSize=$JAVA_MAX_META $JAVA_OPTS -jar /app.jar" ]