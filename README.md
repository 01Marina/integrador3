# integrador3

## Conexión a base de datos

**Se trabajó sobre la base de datos MySQL.**
**Para conectarte con ésta se debe modificar el archivo:**

      estudiantesMySQL>src>main>resources>application.properties

**Una vez en este archivo se deben modificar las siguientes líneas con los datos correspondientes:**

Esquema: (students)

      spring.datasource.url=jdbc:mysql://localhost:3306/students

Usuario: (root)

      spring.datasource.username=root

Contraseña: (***)

      spring.datasource.password=***
  
## Ejecución desde Postman

**Los testeos fueron realizados sobre la herramienta de testeo de apis llamada Postman, así es como para ejecutar el servicio se debe importar los casos de testeos que se adjunta en el proyecto.**

**Dicho archivo se llama:**

      Testeo en postman Api para registro de estudiantes.postman_collection.json
