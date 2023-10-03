# MEF

Filtro para busquedas de una base de datos

## Instalación

Abre una terminal en la raíz de tu proyecto Spring Boot, donde se encuentra el archivo pom.xml.

Ejecuta el siguiente comando Maven para compilar y generar el archivo JAR, especificando el perfil mysql:

bash Copy code
 bash
mvn clean package -Dspring.profiles.active=mysql


Esto compilará tu aplicación con el perfil mysql activado y generará un archivo JAR ejecutable llamado *mef-0.0.1-SNAPSHOT.jar* en la carpeta target de tu proyecto.

### Instalación del JRE (Java 11)

Para ejecutar tu aplicación con Java 11, puedes descargar e instalar el JRE desde el siguiente enlace https://www.oracle.com/cl/java/technologies/javase/jdk11-archive-downloads.html:

Descarga el JRE (Java Runtime Environment) 11 desde Oracle JDK 11 Downloads según tu sistema operativo y arquitectura. Asegúrate de descargar el JRE, no el JDK (Development Kit).

Sigue las instrucciones de instalación proporcionadas para tu sistema operativo.

### Ejecución de la Aplicación

Una vez que hayas compilado tu aplicación y tengas el JRE 11 instalado en tu sistema, puedes ejecutarla simplemente haciendo doble clic en el archivo JAR mef-0.0.1-SNAPSHOT.jar.

Con estos pasos, tu aplicación Spring Boot se ejecutará al hacer doble clic en el archivo JAR, siempre que la configuración de tu sistema permita la ejecución de archivos JAR.
