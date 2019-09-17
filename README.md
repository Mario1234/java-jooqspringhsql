# java-jooqspringhsql
Aplicacion de escritorio de prueba para libreria jOOQ con Spring y HSQL escrita en Java

Este aplicacion de escritorio utiliza el framework Spring para administrar la persistencia en la ejecucion de consultas a una base de datos que se realizan mediante la libreria JOOQ, 
se conecta a una base de datos HSQL y usa el gestor Maven para la administracion de librerias de dependencias.


Descargar HyperSQL, descomprimir carpeta hsqldb en C: Tener variables de entorno de jdk y jre 8 o superior en path Abrir consola powershell modo administrador
cd "C:\hsqldb\lib"


java -cp hsqldb.jar org.hsqldb.util.DatabaseManagerSwing


en URL poner jdbc:hsqldb:file:C:\hsqldb\ y crear una tabla USUARIO: 
CREATE TABLE USUARIO (ID INT, NOMBRE VARCHAR(10), APELLIDO VARCHAR(10), PRIMARY KEY(ID)); 


aniadir un usuario de ejemplo: 
INSERT INTO USUARIO (ID,NOMBRE,APELLIDO) VALUES (0,'James','Bond'); 

Salir


abrir proyecto con eclipse Java EE IDE for Web Developers con el plugin de maven(deberia tenerlo en la propia distribucion), version Oxygen 4.7.3a o superior
eliminar carpeta comun.jooq
Proyecto click der->Properties->Java Build Path->Source
elimina todas las entradas
Add Folder...
src/main/java
src/main/resources
Apply
Apply and Close


añadir jar externo en el buildpath de este proyecto = C:\hsqldb\lib\hsqldb.jar :
es importante que sea el hsqldb.jar de la version de HyperSQL que te has descargado y no el que esta subido en este repositorio
copiar el jar C:\hsqldb\lib\hsqldb.jar a la carpeta del proyecto
Proyecto click der->Properties->Java Build Path->Libraries->Add External JARs...
selecciona el jar recien copiado
Apply
Apply and Close


ahora se sigue procedimiento para descargar las librerias necesarias del proyecto:
Proyecto click der->configure->convert to Maven
Proyecto click der->Maven->Update Project...
force update snapshots releases


y en este punto empieza el proceso para generar con JOOQ las clases java tipo Entity que representan las tablas SQL de la BD
Proyecto click der-> Run As -> Run configurations...
Maven Build->new
Name = generar
Base Directory = tu directorio del proyecto
Goals: generate-sources
Profile=generate
Skip test
Aply
Run


Aqui se han generado las clases pero UsuarioRecord tiene demasiados @Override, quitalos
ahora el proyecto deberia compilar

 
Para ejecutarlo hacer click derecho sobre src/main/java/comun/Principal.java ->Run As...->Java Application
