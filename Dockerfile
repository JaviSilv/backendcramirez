# Etapa 1: Construcción de la aplicación
FROM maven:3.8.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar solo el pom.xml para descargar dependencias primero
COPY pom.xml ./
RUN mvn dependency:go-offline  # Descarga dependencias sin compilar

# Copiar el resto del código fuente
COPY src ./src

# Construir el proyecto
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución del JAR
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
