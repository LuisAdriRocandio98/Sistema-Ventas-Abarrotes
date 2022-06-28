/* 
 * Javascript
 */

$(document).ready(function (){
   $("#btnEliminar").click(function (){
       var ip=$(this).parent().find("#ip").val();
       eliminar(ip);
   }); 
   
    function eliminar(ip){
        var url ="Controlador?menu=NuevaVenta&accion=Eliminar";
        $.ajax({
            type: 'POST',
            url: url,
            data: "ip="+ip,
            success: function (data, textStatus, jqXHR) {
                alert("Producto Eliminado");
            }
        });
    }
});


