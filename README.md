# FloristManagement
Proyecto Universitario de la Materia FrameworksMVC donde usaremos Spring para realizar una aplicacion de gestion de una floristeria
Metodos Http Usados RestFull:

MakerController EndPoints 
-----------------------
Crear un nuevo Maker
Método: POST
URL: /Home/Maker/save
-----------------------
Obtener todos los Makers
Método: GET
URL: /Home/Maker/findAll
-----------------------
Obtener un Maker por ID
Método: GET
URL: /Home/Maker/find/{id}
Ejemplo de URL: /Home/Maker/find/1 (donde 1 es el ID del Maker)
-----------------------
Actualizar un Maker
Método: PUT
URL: /Home/Maker/edit/{id}
Ejemplo de URL: /Home/Maker/edit/1 (donde 1 es el ID del Maker)
-----------------------
Borrar un Maker
Método: DELETE
URL: /Home/Maker/delete/{id}
Ejemplo de URL: /Home/Maker/delete/1
-----------------------
Obtener todas las flores de un Maker
Método: GET
URL: /Home/Maker/{id}/flowers
Ejemplo de URL: /Home/Maker/1/flowers
-----------------------

FlowerController EndPoints
-----------------------
Obtener todas las Flores
Método: GET
URL: /Home/Flower
-----------------------
Obtener una Flor por ID
Método: GET
URL: /Home/Flower/find/{id}
Ejemplo de URL: /Home/Flower/find/1
-----------------------
Método: POST
URL: /Home/Flower/save
Parámetro de URL: id del Maker al que se asignará la flor (ejemplo: /Home/Flower/save?id=1).
-----------------------
Actualizar una Flor
Método: PUT
URL: /Home/Flower/update/{id}
Ejemplo de URL: /Home/Flower/update/1
Parámetro de URL: makerId del Maker al que deseas reasignar la flor (ejemplo: /Home/Flower/update/1?makerId=2).
-----------------------
Eliminar una Flor por ID
Método: DELETE
URL: /Home/Flower/delete/{id}
Ejemplo de URL: /Home/Flower/delete/1