FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
# CAMBIO IMPORTANTE: Le decimos que entre a la carpeta 'saludo-provider'
COPY saludo-provider/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
