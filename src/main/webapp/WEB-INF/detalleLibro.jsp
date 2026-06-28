<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Detalle Libro</title>
</head>
<body>
  <h1>Detalle del libro</h1>

    <c:choose>
        <c:when test="${not empty nombreLibro}">
            <h2>${nombreLibro}</h2>
            <p><strong>Autor:</strong> ${autores}</p>
        </c:when>
        <c:otherwise>
            <p style="color:red;">${mensaje}</p>
        </c:otherwise>
    </c:choose>
    <form action="/libros" method="get">
    <button type="submit">Volver a la lista</button>
  </form>
</body>
</html>