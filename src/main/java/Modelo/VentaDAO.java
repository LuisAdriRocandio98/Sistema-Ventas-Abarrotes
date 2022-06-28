package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentaDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public String GenerarSerie(){
        String numeroserie="";
        String sql = "SELECT max(NumeroSerie) from ventas";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                numeroserie=rs.getString(1);
            }
        } catch (SQLException e) {
        }
        return numeroserie;
    }
    
    public String IdVentas(){
        String idventas="";
        String sql = "SELECT max(IdVentas) FROM ventas";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                idventas=rs.getString(1);
            }
        } catch (SQLException e) {
        }
        return idventas;
    }
    
    public int guardarVenta(Venta ve){
        String sql = "INSERT INTO ventas(idCliente, idEmpleado, NumeroSerie, FechaVenta, Monto, Estado)VALUES(?,?,?,?,?,?)";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, ve.getIdcliente());
            ps.setInt(2, ve.getIdempleado());
            ps.setString(3, ve.getNumserie());
            ps.setString(4, ve.getFecha());
            ps.setDouble(5, ve.getMonto());
            ps.setString(6, ve.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
    
    public int guardarDetalleventas(Venta venta){
        String sql = "INSERT INTO detalle_ventas(idVentas, idProducto, Cantidad, PrecioVenta) VALUES(?,?,?,?)";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, venta.getId());
            ps.setInt(2, venta.getIdproducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
}
