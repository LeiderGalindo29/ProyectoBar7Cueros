

<%@page import="ModeloVO.ProductoVO"%>
<%@page import="ModeloVO.ClienteVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
         
        <div class="d-flex">
            <div class="col-sm-5">
                <div class="card">
                    <form action="Cliente" method="POST">
                        <div class="card-body">
                        
                        <!--Cliente-->
                        <div class="form-group">
                            <label>Datos del Cliente</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                
                                <input type="text" name="cliente_documento" class="form-control" placeholder="Documento Cliente">
                                <input type="submit" name="Buscar Cliente" value="Buscar Cliente" class="btn btn-outline-info">
                                <input type="hidden" name="valor" value="4" >
                            </div>
                            <div class="col-sm-6">
                                   <%
            
        ClienteVO cliVO = (ClienteVO)request.getAttribute("consultaDocumento");
        
        if (cliVO!=null){

        %>
        <input type="text" name="cliente_nombre" value="<%=cliVO.getCliente_nombre()%> <%=cliVO.getCliente_apellido()%>" class="form-control" disabled="disabled">
                                <%}%>
                            </div>
                        </div>
                    </form>
                     <form action="Producto" method="POST">
                                <!--producto-->
                        <div class="form-group">
                            <label>Datos Producto</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="prod_nombre" class="form-control" placeholder="Codigo Producto">
                                <input type="submit" name="Buscar Producto" value="Buscar Producto" class="btn btn-outline-info">
                                <input type="hidden" name="valor" value="2" >
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombre" class="form-control">
                            </div>
                        </div>
                        
                       
                        <!--Cantidad-->
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="precio" class="form-control" placeholder="Codigo Producto">
                            </div>
                            <div class="col-sm-3">
                                <input type="number" name="cantidad" class="form-control">
                            </div>
                            <div class="col-sm-3">
                                <input type="text" name="stock" class="form-control">
                            </div>
                        </div>
                        
                        
                        <div class="form-group">
                            <input type="submit" name="accion" value="Agregar" class="btn btn-outline-info"> 
                        </div>
                    </div>
                    
                </div>
            </div>
            
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-5 ml-auto">
                            <label>NumeroSerie</label>
                            <input type="text" name="NroSerie" class="form-control">
                        </div>
                            <table class="table table-hover">
                                <%
            
        ProductoVO prodVO = (ProductoVO)request.getAttribute("consultaNombre");
        
        if (prodVO!=null){

        %>
                                <thead>
                                    <tr>
                                        <th>Nro</th>
                                        <th>Codigo</th>
                                        <th>Descripcion</th>
                                        <th>Precio</th>
                                        <th>Cantidad</th>
                                        <th>Subtotal</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><%=prodVO.getId_producto()%></td>
                                        <td><%=prodVO.getId_producto()%></td>
                                        <td><%=prodVO.getProducto_nombre()%></td>
                                        <td><%=prodVO.getProducto_precio()%></td>
                                        <td><%=prodVO.getProducto_cantidad()%></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </tbody>
                                <%}%>
                            </table>

                    </div>
                            </form>
                    <div class="card-footer">
                        <input type="submit" name="accion" value="Generar Venta" class="btn btn-success">
                        <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                    </div>
                </div>
                
            </div>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
