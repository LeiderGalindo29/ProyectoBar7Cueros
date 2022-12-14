<%-- 
    Document   : actualizarMesa
    Created on : 14/09/2022, 12:46:49 AM
    Author     : alrod
--%>

<%@page import="ModeloVO.MesaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Actualizar mesa</h1>
        
        <%
            MesaVO mesaVO = (MesaVO)request.getAttribute("datosConsultados");
            
            if(mesaVO!=null){
        %>
        <form method="post" action="Mesa">
            <table>
                <tr>
                    <th>
                        Numero Mesa<br>
                        <input type="text" name="numero" value="<%=mesaVO.getMesa_numero()%>"><br><br>
                        Estado<br>
                        <input type="text" name="estado" value="<%=mesaVO.getMesa_estado()%>"><br><br>
                    </th>
                </tr>
            </table>
            <button>Actualizar</button><br>
            <input type="hidden" value="2" name="valor">
        </form>
            
        <%}%>
    </body>
</html>
