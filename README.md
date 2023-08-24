# ExamenWeb3P
##API de Tareas
La API de Tareas es una API RESTful que permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre tareas.

##Acceso a la API
La API se puede acceder a través de la siguiente URL base:

http://localhost:8080/api/tasks

##Operaciones CRUD
Obtener todas las tareas
Solicitud HTTP: GET Ruta: /api/tasks

Ejemplo de solicitud:

GET /api/tasks
Obtener una tarea por ID
Solicitud HTTP: GET Ruta: /api/tasks/{taskId}

Ejemplo de solicitud:

GET /api/tasks/1
Crear una nueva tarea
Solicitud HTTP: POST Ruta: /api/tasks

Ejemplo de solicitud:

POST /api/tasks
Content-Type: application/json

{
  "name": "Tarea 1",
  "descripcion": "Realizar una tarea",
  "fecha": "2022-10-31",
  "estado": "Pendiente"
}
Actualizar una tarea existente
Solicitud HTTP: PUT Ruta: /api/tasks/{taskId}

Ejemplo de solicitud:

PUT /api/tasks/1
Content-Type: application/json

{
  "name": "Tarea 1 actualizada",
  "descripcion": "Realizar una tarea importante",
  "fecha": "2022-10-31",
  "estado": "Completada"
}
Eliminar una tarea
Solicitud HTTP: DELETE Ruta: /api/tasks/{taskId}

Ejemplo de solicitud:

DELETE /api/tasks/1
Respuestas de la API
La API devuelve respuestas en formato JSON con los siguientes campos:

id: El ID de la tarea.
name: El nombre de la tarea.
descripcion: La descripción de la tarea.
fecha: La fecha de la tarea.
estado: El estado de la tarea.
Aquí tienes un ejemplo de una respuesta exitosa para la solicitud de obtener todas las tareas:

[
  {
    "id": 1,
    "name": "Tarea 1",
    "descripcion": "Realizar una tarea",
    "fecha": "2022-10-31",
    "estado": "Pendiente"
  },
  {
    "id": 2,
    "name": "Tarea 2",
    "descripcion": "Realizar otra tarea",
    "fecha": "2022-11-01",
    "estado": "Completada"
  }
]
