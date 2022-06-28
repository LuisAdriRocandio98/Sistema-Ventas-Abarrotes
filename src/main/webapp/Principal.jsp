<%-- 
    Document   : Principal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Principal</title>
        <link rel="icon" href="img/comestibles.png">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info" style="background-color: #e3f2fd;">
            <div class="container-fluid">
                <img src="img/comestibles.png" width="40" style="margin-left: 30px">
                <a class="navbar-brand" href="Controlador?menu=Principal" style="margin-left: 50px">Inicio</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="btn btn-outline-light navbar-brand" style="border: none;" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-outline-light navbar-brand" style="border: none;" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-outline-light navbar-brand" style="border: none;" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-outline-light navbar-brand" style="border: none;" href="Controlador?menu=NuevaVenta&accion=Vista" target="myFrame">Nueva Venta</a>
                        </li>
                    </ul>
                </div>
                <div class="dropdown dropstart">
                    <button style="border: none;" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                        ${usuario.getNom()}
                    </button>
                    <ul class="dropdown-menu text-center dropdown-menu-right" aria-labelledby="dropdownMenuButton1">
                        <a class="dropdown-item">
                            <img src="img/usuario.png" alt="60" width="60">
                        </a>
                        <li><a class="dropdown-item" href="#">${usuario.getUser()}</a></li>
                        <li><a class="dropdown-item" href="#">${usuario.getNom()}@gmail.com</a></li>
                        <div class="dropdown-divider"></div>
                        <form action="Validar" method="POST">
                            <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                        </form>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="m-4" style="height: 650px;">
            <iframe name="myFrame" style="height: 100%; width: 100%;">
               
            </iframe>
        </div>             
    </body>


    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>



</html>
