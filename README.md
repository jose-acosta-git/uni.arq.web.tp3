Repositorio del ejercicio integrador del trabajo práctico 3 de Arquitecturas Web

# App
Para hacer uso de la API, descargar la app (rama master) y ejecutarlo (corre localmente en el puerto 8080 `localhost:8080`).

# Base de datos
## Host
La app utiliza una base de datos de [ElephantSQL](https://api.elephantsql.com) para facilitar el uso de la misma.
De esta manera no hay que realizar una carga de datos al comienzo, ya que ya tiene algunos datos cargados.

## Administrar
Para administrar la base de datos se puede acceder desde [DBeaver](https://dbeaver.io/):

1. Crear conexión
2. PostgreSQL
3. Datos:

| Host                   | Database  | Username  | Password                           |
|------------------------|-----------|-----------|------------------------------------|
| silly.db.elephantsql.com | styfqtex | styfqtex | 08G5y7EiwBsUl3odlD5HBvwXVgTJSGpS |


La base de datos solo soporta una conexión a la vez, por lo que antes de conectarse para administrarla, hay que apagar la app.

# Consultas (consignas del tp)

### a) Dar de alta un estudiante

Ejemplo:

```http
POST localhost:8080/students/ordered
{
    "name": "Felipe",
    "lastName": "Messi",
    "dni": 12123123,
    "age": 18,
    "gender": "male",
    "city": "Tres Arroyos",
    "notebookNumber": 12345
}
```

Valores únicos (no se pueden repetir): `Dni` y `notebookNumber`.

### b) Matricular un estudiante en una carrera

Ejemplo:

```http
POST localhost:8080/enrollments
{
   "studentId": 1,
   "courseId": 1,
   "entryDate": "2020-01-15",
   "exitDate": "2025-02-20"
}
```

- `exitDate` puede ser `null` (indicando que el estudiante no se graduó aún)
- los `IDs` deben coincidir con registros de estudiantes y carreras.

### c) Recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple

Criterio de ordenamiento: Alfabéticamente por apellido.
Request:
```http
GET localhost:8080/students/ordered
```

### d) Recuperar un estudiante, en base a su número de libreta universitaria

Ejemplo:

```http
GET localhost:8080/students/byNotebookNumber/23456
```

### e) Recuperar todos los estudiantes, en base a su género

Ejemplo:

```http
GET localhost:8080/students/byGender/male
```

### f) Recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos

```http
GET localhost:8080/courses/coursesWithStudents
```

### g) Recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia

```http
GET localhost:8080/enrollments/studentsByCourseAndCity/matematica/Tres Arroyos
```

### h) Generar un reporte de las carreras, que para cada carrera incluya información de los inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar los años de manera cronológica

```http
GET localhost:8080/courses/generateReport
```