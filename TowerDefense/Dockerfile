# Ponemos la imagen base que proporcionara un entorno de ejecucion de Java
FROM openjdk:17
# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copy los archivos que se encuentran en el directorio (.) de la ubicacion del dockerfile
# a la carpeta /app del contenedor
COPY . /app

# Ejecuta el comando javac dentro del contenedor para compilar todos los archivos .java
# que se encuentran en el directorio src/main/java/org/example.
RUN javac src/main/java/org/example/*.java
# Especifica el comando por defecto que se ejecutara cuando inicie el contenedor
# Se ejecutara la clase TowerDefenseGame utilizando el comando "java"
CMD ["java","-cp","/app/src/main/java","org.example.Game"]
