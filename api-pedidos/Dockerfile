# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-slim as builder

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos de Gradle y el código fuente
COPY . .

# Construye el proyecto con Gradle
RUN ./gradlew build --no-daemon

# Crea una nueva imagen para ejecutar el servicio
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo .jar desde la imagen de build
COPY --from=builder /app/build/libs/*.jar app.jar

# Exponer el puerto de la aplicación (por defecto en Spring Boot)
EXPOSE 8080

# Ejecutar el archivo .jar
ENTRYPOINT ["java", "-jar", "app.jar"]