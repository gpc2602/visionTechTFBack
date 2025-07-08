# Etapa 1: Construcción del proyecto (Build Stage)
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

# 🔥 Este es el cambio clave: Fuerza UTF-8
RUN mvn clean package -DskipTests -Dproject.build.sourceEncoding=UTF-8

# Etapa 2: Imagen final con solo el .jar (Run Stage)
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/target/visiontech2-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
