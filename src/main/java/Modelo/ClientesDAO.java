package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    //Lista lista de Clientes
    public List listarCliente(){
        String sql = "SELECT * FROM cliente";
        List<Clientes> lista = new ArrayList<>();
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Clientes c = new Clientes();
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
                lista.add(c);                
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    
    //Agregar Nuevo Cliente
    public int AgregarCliente(Clientes c){
        String sql = "INSERT INTO cliente(Dni, Nombres,Direccion, Estado)VALUES(?,?,?,?)";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getDni());
            ps.setString(2, c.getNombres());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
    
    //Actualizar nuevo Cliente
    public int ActualizarCliente(Clientes c){
        String sql = "UPDATE cliente SET Dni=?, Nombres=?, Direccion=?, Estado=? WHERE idCliente=?";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getDni());
            ps.setString(2, c.getNombres());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getEstado());
            ps.setInt(5, c.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }
    
    //Borrar Nuevo cliente
    public void EliminarCliente(int id){
        String sql = "DELETE FROM cliente WHERE idCliente="+id;
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public Clientes listarIdCliente(int id){
        Clientes cl = new Clientes();
        String sql = "SELECT * FROM cliente WHERE idCliente="+id;
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                cl.setDni(rs.getString(2));
                cl.setNombres(rs.getString(3));
                cl.setDireccion(rs.getString(4));
                cl.setEstado(rs.getString(5));
            }
        } catch (SQLException e) {
        }
        return cl;
    }
    
    //Buscar cliente mediante dni
    public Clientes buscar(String dni){
        Clientes c = new Clientes();
        String sql = "SELECT *FROM cliente WHERE Dni="+dni;
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt(1));    
                c.setDni(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
            }
        } catch (SQLException e) {
            System.err.println(sql);
        }
        return c;
    }
    
    
    
    
    
}
