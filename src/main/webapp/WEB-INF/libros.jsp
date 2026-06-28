<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Lista libros</title>
  </head>
  <body>
<h1>Libros disponibles</h1>
<ul>
  <c:forEach var="libro" items="${listaLibros}">
    <li>
      <a href="/libros/${libro.key}"> ${libro.key}</a>    
    </li>
  </c:forEach>
</ul>
  </body>
</html>
