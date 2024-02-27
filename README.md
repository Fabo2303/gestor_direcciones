# GESTOR DE DIRECCIONES - MYSQL

Este proyecto fue asignado en el curso de Base de Datos del ciclo IV de la carrera de Ingeniería de Sistemas de la Universidad Nacional Mayor de San Marcos

La finalidad de este proyecto era aplicar los conocimientos de bases de datos mediante un lenguaje de programación, a elección del alumno.

Se aplicó:

- Creación de tablas
- Creación de paquetes para los insert, update y delete
- Creación de secuencia
- Creación de triggers
- Creación de vistas

## Requisitos

- Instalar maven
- Instalar java jdk
- Instalar una base de datos, de preferencia mysql
- Un IDE o editor de código

## Instrucciones para su uso

- Clonar el repositorio
  ```bash
  git clone git@github.com:Fabo2303/gestor_direcciones_oracle.git
  ```
- Ir al archivo DatabaseConnection.java
  ```bash
  src/main/java/com/fabo/aplication/utils/DatabaseConnection.java
  ```
  En ese archivo debe cambiar el usuario, contraseña y el nombre de la base de datos. En caso de querer usar un nuevo gestor de base de datos deberá cambiar el drive jdbc. (Agregar la dependencia en el pom.xml)
  ```java
  Class.forName("com.mysql.cj.jdbc.Driver");
  String myDB = "jdbc:mysql://localhost:3306/nombre_de_tu_base_de_datos";
  String usuario = "tu_usuario";
  String password = "tu_contraseña";
  ```
- Ejecutar los scripts sql disponibles en:
  ```bash
  src/main/resources/sql
  ```
- Ejecutar el proyecto

## CAPTURA DE EJECUCIÓN

![gestor-direcciones](https://github.com/Fabo2303/gestor_direcciones_oracle/assets/115574987/f9636993-ba21-472d-8540-82e947383ab4)

## TODO
- Mejorar la conexión con la base de datos en el archivo DatabaseConnection.java
- Migrar los archivo sql oracle a mysql

## NOTA
- Este proyecto es de hace 1 año, lo actualice a maven debido a la presencia del archivo .jar para la conexión con la base de datos.
- Se realizaron algunos cambios al diseño original.
- Se optimizaron las imágenes usadas y se reemplazo la lógica de cambio de pantalla por parámetros a una basada en Singleton.
