# Backend for frontend - between-test TestJava2020 - Tech Lead

Esta basado en el principio de Clean Architecture.

![alt text](docs/clean.png)

## Estructura de paquetes

Se definió la siguiente taxonomía de paquetes:

   * **application:** Encapsula toda la lógica de negocio y el modelo del dominio.
        * **domain:** Contiene entidades del dominio. Representa el nucleo de toda la aplicación.
        * **usescases:** Abstracción de los casos de uso del sistema. Contiene además la definición de los puertos y excepciones.
   * **adapters:** Representa la capa de adaptadores (como su nombre indica) que se conectarán en los puertos expuestos por el sistema
   * **config:** Capa transversal a toda la aplicación que contendrá las distintas configuraciones y aspectos del bff.
        
![alt text](docs/packages.png)

## Java Version
La version que java que se va a utilizar es la 11.0.5 basada en el OpenJDK.

Esta la pueden descargar [aqui](https://github.com/AdoptOpenJDK/openjdk11-upstream-binaries/releases/tag/jdk-11.0.5%2B10).
También se puede instalar usando [SdkMan](https://sdkman.io/), version 11.0.5-open.

## Swagger
### Swagger json
http://localhost:8080/between-test/openapi

### Jacoco - Sonar

```
docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube
./gradlew jacocoTestReport sonarqube
```

#Import postman collection
https://www.getpostman.com/collections/f4110a7b62074051c2bb


