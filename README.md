# 💻 Portfolio para Argentina Programa 2da Etapa
Un portfolio realizado como proyecto final para la 2da Etapa de Argentina Programa: #YoProgramo 2da edición.
En este repositorio se encuentra todo lo relacionado al **Backend** del proyecto, para dirigirse al repositorio del **Frontend** **[hacer click aquí](https://github.com/CodeAgua/ArgProg-ProyectoFinal-FrontEnd "aquí").**

## 📝 Descripción
- ***Backend** del **Portfolio Web Fullstack*** realizado como Proyecto Final del curso **Argentina Programa - #YoProgramo**.
- Se trata de una **API REST** realizada utilizando las tecnologías **Java + Spring Boot** bajo el modelo **MVC** para la lógica y **MySQL** para persistencia de datos.

## 🛠️ Construido con 
* Angular
* HTML
* CSS
* Bootstrap
* JavaScript
* TypeScript
* MySQL
* Java
* Springboot

## ⌨🖱 Instalación
- Si queremos correr la aplicación en un entorno local debemos tener en cuenta lo siguiente: 

1. Clonar el repositorio utilizando GIT o descargando el archivo ZIP:

    `git clone https://github.com/CodeAgua/ArgProg-ProyectoFinal-BackEnd.git`

2. Instalar las dependencias de Maven utilizando nuestro IDE preferido o a través del comando:

    `mvn install`

3. Creamos una nueva database vacía con el nombre que queramos

4. Crear/Configurar el archivo _application.properties_ en src/main/resources/

```properties
spring.jpa.hibernate.ddl-auto = update
spring.datasource.url = jdbc:mysql://<host_DB>:<puerto_DB>/<nombre_DB>?serverTimezone=UTC&createDatabaseIfNotExist=true
spring.datasource.username = <usuario>
spring.datasource.password= <contraseña>
spring.jpa.database-platform = org.hibernate.dialect.MySQL8Dialect
portfolio.jwtSecret = <clave_alfanumérica_JWT>
portfolio.jwtExpirationMs = <tiempo_expiración_JWT> 
```
NOTA: Reemplazar los valores borrando los <>.

5. Ejecutar nuestra aplicación haciendo click izquierdo Run File en el archivo `LerApplication.Java`.

6. La base de datos iniciará sin datos por lo que debemos seguir algunos pasos. Agregaremos los roles manualmente a la Base de Datos con:
- Con phpmyadmin apretando Insert en la columna rol colocando el id 1 ROLE_USER y el id 2 ROLE_ADMIN
- Con MySQL INSERT INTO `rol`(`id`,`rol_nombre`)VALUES (null, 'ROLE_USER');
INSERT INTO `rol`(`id`,`rol_nombre`)VALUES (null,'ROLE_ADMIN');

7. Usando una plataforma API como **[Insomnia](https://insomnia.rest/ "Insomnia")** o **[Postman](https://www.postman.com/ "Postman").** crearemos un usuario nuevo con el método POST en http://localhost:8080/auth/nuevo

{
    "nombre": "",
    "nombreUsuario": "",
    "email": "",
    "password": "",
    "roles": ["admin"]
}

8. Hacemos Login en http://localhost:8080/auth/login 
{
    "nombreUsuario":"xxxx",
    "password":"xxxxxxxx"
}

9. El Login nos entregará un token que deberemos copiar y pegar en una solicitud HTTP de tipo POST con dirección a http://localhost:8080/personas/create
Vamos a Authorization > Bearer Token y lo pegamos ahí. En Body vamos a la opción Raw y cambiamos el formato a JSON (se debe respetar el orden Key/Value) y colocamos:
{
    "nombre": "",
    "apellido": "",
    "img": "",
    "titulo": "",
    "descripcion": ""
}

10. Crear un banner con
{
    "urlimg": "https://iili.io/Lk4Fwl.png"
}
