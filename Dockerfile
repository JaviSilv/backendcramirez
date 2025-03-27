# Etapa 1: Construcción de la aplicación
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar solo los archivos de configuración para optimizar la caché
COPY pom.xml mvnw ./
COPY .mvn .mvn/

# Descargar dependencias sin compilar el código
RUN mvn dependency:go-offline

# Copiar el código fuente
COPY src ./src

# Construir el proyecto sin ejecutar pruebas
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución del JAR
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copiar el JAR generado en la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto donde corre Spring Boot
EXPOSE 8080

# Ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
