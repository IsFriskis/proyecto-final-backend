# Introducción
Esta parte es el Back-End del proyecto que contiene todas las consultas en base de datos y la propia base de datos empleada en el proyecto de Gameo. En todo momento se ha buscado la modularidad de la misma para porder proporcionar la mayor adaptabilización de la aplicación a cualquier videojuego a la API. 

## Tecnologías

Las tecnologías usadas en este apartado de la aplicacion fueron las siguientes listadas:

 - Spring Framework for Java

 - Apache Maven (Libraries and extensions manager)

 - MySQL (Database language)

Con estas tecnologías listadas se ha hecho la aplicación. Spring fue el el framework elegdo para el trabajo. Principalmente por comodidad, el conocimiento sobre el mismo me hizo programar con mayor seguridad y  de manera mas sencilla. Apache Maven suele ir de las manos con Spring, entonces fue simplemente una opción de compatbilidad entre ambas. Por último, MySQL fue el lenguaje empleado para la base de datos. Otra vez, por comodidad ante las otras opciones (PostresSQL y MariaDB).

# Pasos para la ejecución del proyecto

## Sin docker

1. Instala MySQL en el dispositivo. Dejo un enlace para la instalación [Link](https://www.adslzone.net/esenciales/windows-10/instalar-mysql/)

2. Tendrás en tu dispositivo una aplicación llamada **MySQL Workbench**. Ábrela y haz click el servidor local. Habiendo entrado ahí, abre los dos ficheros que hay en **./Database/Scripts/** y ejecútalos (Haces click en el icono del rayo). Primero el fichero que se llama el DDL y después el archivo que se llama DML.

3. Instala Java en el dispositivo, especificamente el jdk 19.0.2. Dejo un enlace para poder instalarlo [Link](https://lamadriguerabit.com/articulos/instalar-jdk-en-cualquier-sistema-operativo/#:~:text=en%20cualquier%20entorno.-,Instalación,descargar%20y%20aceptaremos%20la%20licencia.&text=Una%20vez%20descargado%20ejecutaremos%20el%20instalador.)

4. Instala Apache Maven en el dispositivo, con la última version vale. Dejo un enlace que lo explica en detalle [Link](https://nefele.dev/blog/instalar-apache-en-windows-bien-explicado/)

5. Instala el IDE IntelliJ Idea para poder ejecutar el proyecto. Dejo el link para descargar e instalar [Link] (https://www.jetbrains.com/es-es/idea/download/#section=windows)

6. Abre el IntelliJ Idea y abre el proyecto. 

7. Abre la consola de comandos, busca la ubicación del proyecto y copiala. Escribe en la consola de comandos lo siguiente:

```
cd (La ruta que has copiado)
Ejemplo:
cd C:\Users\User\Desktop\tfcfrontend
```

8. Escribe el siguiente comando:

```
mvn clean install
```

9. Ve al IntelliJ Idea y ejecuta el proyecto. (Arriba a la izquierda en la flecha verde)
