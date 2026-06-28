<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>formulario</title>
  </head>
  <body>
    <h1>Ingresa tu libro y autor</h1>
    <form method="POST" action="/libros/procesar/libro">
      <label for="nuevoLibro">Titulo del libro</label>
      <input type="text" id="nuevoLibro" name="nuevoLibro" />
      <label for="autorNuevo">Autor</label>
      <input type="text" id="autorNuevo" name="autorNuevo" />
      <button>Agregar</button>
    </form>
    <form action="/libros" method="get">
      <button type="submit">Volver a la lista</button>
    </form>
  </body>
</html>
