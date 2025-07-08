# Imagen base con Java 17 (compatible con Spring Boot)
FROM eclipse-temurin:17-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado al contenedor
COPY target/visiontech2-0.0.1-SNAPSHOT.jar app.jar

# Puerto expuesto (Render lo ignora, pero es buena práctica)
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java","-jar","/app/app.jar"]
