<%-- 
    Document   : muestraGastos
    Created on : 06/09/2020, 10:55:15 AM
    Author     : DarvisTrillosAriza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado De Gastos</title>
    </head>
    <body>
        <%@page import="Model.Gasto,java.util.ArrayList" %>
        <% ArrayList<Gasto> gastos = null;
            gastos = (ArrayList<Gasto>) request.getAttribute("Gastos");
        %>
        <h1>Lista de gastos</h1>
        <table border="1" cellspacing="0">
            <thead>
            <th>Id</th>
            <th>Fecha</th>
            <th>Identificación</th>
            <th>Nombre</th>
            <th>Observacion</th>
            <th>Valor</th>
             <th>Modificar</th>
             <th>Eliminar</th>
        </thead>
        <tbody>
            <% for (Gasto gasto : gastos) {%>
            <tr>
                <td><%= gasto.getId()%></td>
                <td><%= gasto.getFecha()%></td>
                <td><%= gasto.getIdenti()%></td>
                <td><%= gasto.getNombre()%></td>
                <td><%= gasto.getObs()%></td>
                <td><%= gasto.getValor()%></td>
                <td><form action="modificaGastos" method="post"><button  type="submit"  value="<%= gasto.getId() %>" name="Editar" >Modificar</button><input name="Borrar" value=0 hidden></form></td>
                <td><form action="modificaGastos" method="post"><button type="submit"  value="<%= gasto.getId() %>" name="Borrar" >Eliminar</button><input name="Editar" value=0 hidden></form></td>
            </tr>
            <% }%>
        </tbody>
    </table>
    <form action="index.htm" method="post">
        <input type="submit" value="Regresar al inicio">
    </form>
</body>
</html>
