<%-- 
    Document   : producto
    Created on : 3/08/2022, 08:19:42 PM
    Author     : alrod
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de Productos</h1>
        
        <form method="POST" action="Producto">
                
            <h1>Nombre Producto</h1>
            <input type="text" name="prod_nombre">
            
            <h1>Precio Producto</h1>
            <input type="text" name="prod_precio">
            
            <select name="prod_estado">
                <option value="1">Activo</option>
                <option value="2">Inactivo</option>
                
            </select>
            
            <button>Registar</button>
            <input type="hidden" value="1" name="valor">
        </form>
        
        <%
            if (request.getAttribute("mensajeError") != null) { %>
        ${mensajeError}

        <%} else {%>
        ${mensajeExito}        
        <%}%>
    </body>
</html>
