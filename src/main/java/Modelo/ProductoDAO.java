package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Producto buscarProducto(int id){
        Producto p = new Producto();
        String sql = "SELECT * FROM producto WHERE idProducto="+id;
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        } catch (SQLException e) {
        }
        return p;
    }
    
    public int actualizarStock(int id, int stock){
        String sql = "UPDATE producto SET Stock=? WHERE idProducto=?";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
    
    public List listarProducto(){
        String sql = "SELECT * FROM producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
                lista.add(p);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    
    public int AgregarProducto(Producto p){
        String sql = "INSERT INTO producto(Nombres, Precio, Stock, Estado) VALUES(?,?,?,?)";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNombres());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
    
    public int ActualizarProducto(Producto p){
        String sql = "UPDATE producto SET Nombres=?, Precio=?, Stock=?, Estado=? WHERE idProducto=?";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNombres());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
    
    public void EliminarProducto(int id){
        String sql = "DELETE FROM producto WHERE idProducto="+id;
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        
    }
    
    public Producto listarIdProducto(int id){
        Producto pr = new Producto();
        String sql = "SELECT * FROM producto WHERE idProducto="+id;
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                pr.setId(rs.getInt(1));
                pr.setNombres(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setEstado(rs.getString(5));
            }
        } catch (SQLException e) {
        }
        return pr;
    }
}
