# Proyecto de Programación I

Proyecto final de la asignatura de Programación I realizado por Pablo Molina García.

## Índice

- [Descripción](#descripción)
- [Opciones de uso](#opciones-de-uso)
- [Instalación](#instalación)
- [Ejecución](#ejecución)
- [Importante a tener en cuenta](#importante-a-tener-en-cuenta)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Licencia](#licencia)

### Descripción

Este proyecto consiste en un programa cuya función es la de un catálogo de productos. Concretamente, este catálogo se centra en procesadores de ordenadores, de tal forma que podamos añadirlos, eliminarlos y verlos en el catálogo mediante un listado. Además, tendremos información acerca de la generación de cada procesador y el precio del mismo; también, según se añadan procesadores a cada marca, podremos ver el precio total de todos los procesadores que encontremos en esta, y de igual manera podremos saber el precio total de todos los artículos del catálogo.

Este es un catálogo que está diseñado de cara a una tienda de procesadores, ya que es a la tienda a la que le interesa conocer el precio de todos los artículos que tiene a la venta, mientras que al usuario podrían interesarle, como mucho, los precios individuales; además, es la empresa la que debe poder editar los productos disponibles y no el usuario.

### Opciones de uso

Las instrucciones principales que puede ejecutar este programa son las siguientes:

- Añadir marcas de procesadores

- Eliminar marcas de procesadores

- Añadir procesadores 

- Eliminar procesadores

- Listar todo lo que contiene el catálogo

- Guardado del catálogo en un fichero

- Salida del programa con guardado automático

Además, se ofrecen las siguientes herramientas:

- Ayuda para conocer los comandos disponibles para ejecutar las instrucciones

- Lectura inicial del catálogo

### Instalación

Para instalar el programa, es necesario descargarse los ficheros de este repositorio y tener instalado Java, que puede obtenerse de su página oficial: https://www.oracle.com/es/java/technologies/downloads/. Además, será preciso tener instalada la librería Chocolatey.

### Ejecución

En cuanto a su ejecución, se realizará mediante una terminal. Para ejecutar el programa, será necesario situarse en la carpeta origen (proyecto_programacion) y escribir el comando "make ejecutar". Una vez hecho esto, se ejecutará el programa y aparecerán las opciones de ayuda, que permitirán al usuario saber cómo continuar.

### Importante a tener en cuenta

A la hora de escribir tanto el nombre/modelo del procesador como su generación de fabricación/salida al mercado, se pueden escribir tanto caracteres como números, pero deben escribirse siempre juntos en una sola línea de texto sin espacios; por otra parte, el precio solo acepta valores numéricos y es importante destacar que está diseñado para mostrar EUROS.

### Estructura del proyecto:

El proyecto se encuentra dividido en los siguientes directorios:

- `dominio`: contiene las clases con los datos principales y la mayor parte de los métodos.
- `aplicacion`: contiene la clase principal, que es la que ejecuta las funciones del resto de clases e inicia la aplicación.
- `presentacion`: contiene la interfaz del programa, que es la que permite a este interactuar con el usuario y que este pueda llamar a las funciones.

### Diagrama UML

En este diagrama se puede observar la representación gráfica de las conexiones entre las clases de los directorios pertenecientes al programa.

Para acceder al archivo en XMI y descargarlo: https://github.com/PMolinaGarcia/proyecto_programacion/blob/main/Diagrama_UML.xmi

Para visualizarlo en PNG:
https://github.com/PMolinaGarcia/proyecto_programacion/blob/main/Diagrama_UML.png

### Licencia

Este software ha sido publicado bajo la licencia Apache-2.0 license.

