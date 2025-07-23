FROM eclipse-temurin:17-jdk-alpine

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR gerado pelo Maven
ARG JAR_FILE=target/book-catalog-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
