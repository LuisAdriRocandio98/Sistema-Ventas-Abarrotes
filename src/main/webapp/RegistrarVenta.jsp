<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Principal Registrar-venta</title>
        <link rel="icon" href="img/comestibles.png">
    </head>
    <body>
        <h2>Registrar Nueva Compra</h2>
        <div class="d-block row">
            <div class="col-12 col-sm-6 py-4">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group py-2">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigocliente" value="${c.getDni()}" class="form-control" placeholder="Código">
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombrescliente" value="${c.getNombres()}" class="form-control" placeholder="Datos Cliente">
                                </div>
                            </div>
                            <div class="form-group py-2">
                                <label>Datos Productos</label>
                            </div>
                            <div class="form-group d-flex py-2">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigoproducto" value="${product.getId()}" class="form-control" placeholder="Código Producto">
                                    <input type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">
                                </div>
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="nombreproducto" value="${product.getNombres()}" class="form-control" placeholder="Datos Producto">
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${product.getPrecio()}" class="form-control" placeholder="S/.000">
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" value="1" name="cant" class="form-control" placeholder="cantidad">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="stock" value="${product.getStock()}" class="form-control" placeholder="Stock">
                                </div>
                            </div>
                            <div class="form-group m-2">
                                <input type="submit" name="accion" value="Agregar" class=" btn btn-outline-info">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-12 col-sm-12">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto py-2">
                            <label>Numero Serie</label>
                            <input type="text" name="NroSerie" value="${nserie}" class="form-control" readonly>
                        </div>

                        <table class="table table-responsive-md">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Código</th>
                                    <th>Descripción</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdproducto()}</td>
                                        <td>${list.getDescripcionp()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubtotal()}</td>
                                        <td>
                                            <input type="text" id="ip" value="${list.getIdproducto()}">
                                            <a href="#" id="btnEliminar" class="btn btn-danger">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" class="btn btn-success">Generar Venta</a>
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                        <div class="col-sm-3 ml-auto">
                            <label>Total a Pagar</label>
                            <input type="text" value="$ ${totalPagar}" name="txtTotal" class="form-control">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.19/dist/sweetalert2.all.min.js"></script>
    <script src="js/funciones.js"></script>
</html>
