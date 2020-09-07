<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="Js/ValidateForms.js"></script>
        <title>Gastos Administrativos</title>
    </head>
    <body>
        <h2>Gastos Administrativos</h2>
        <%@page import="controller.ingresogastos" %>
        <form action="ingresogastos" method="post"  name="frmgasto"  >       
            <table cellspacing="3" cellpadding="3" border="1" > 
                <tr>            
                    <td align="right"> Fecha: </td>     
                    <td><input type="date" name="fecha" required></td>        
                </tr>
                <tr>             
                    <td align="right"> Identificacion: </td>                
                    <td> <input type="text" name="identi" required> </td>    
                </tr>     
                <tr>             
                    <td align="right"> Nombre: </td>                
                    <td> <input type="text" name="nombre" required> </td>    
                </tr> 
                <tr>             
                    <td align="right"> Observacion: </td>                
                    <td> <input type="text" name="obs" required> </td>    
                </tr> 
                <tr>             
                    <td align="right"> Valor: </td>                
                    <td> <input type="text" name="valor" required> </td>    
                </tr> 
                <tr>             
                    <td align="right"> Adjunto: </td>                
                    <td> <input type="file" name="file"> </td>    
                </tr> 
            </table>             
            <input type="reset" value="Borrar">     
             <input type="submit" value="Guardar" >       
        </form> 
        <form action="muestraGastos" method="post">
            <input type="submit" value="Listado de gastos">
        </form>
    </body>
</html>
