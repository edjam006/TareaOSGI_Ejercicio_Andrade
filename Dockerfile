# Usamos una imagen ligera de Java 17
FROM eclipse-temurin:17-jdk-alpine
# Creamos un volumen temporal
VOLUME /tmp
# Copiamos el archivo .jar que generó Maven (el asterisco busca cualquier nombre)
COPY target/*.jar app.jar
# Comando para iniciar la app
ENTRYPOINT ["java","-jar","/app.jar"]
