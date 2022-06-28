package Controlador;

import Modelo.Clientes;
import Modelo.ClientesDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import config.GenerarSerie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Clientes c = new Clientes();
    ClientesDAO cdao = new ClientesDAO();
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    int ide, icl, ipr;

    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar, total;
    
    String numeroserie;
    VentaDAO vdao=new VentaDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }

        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtdni");
                    String nomb = request.getParameter("txtnombres");
                    String tel = request.getParameter("txttelefono");
                    String est = request.getParameter("txtestado");
                    String user = request.getParameter("txtusuario");
                    em.setDni(dni);
                    em.setNom(nomb);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dniA = request.getParameter("txtdni");
                    String nombA = request.getParameter("txtnombres");
                    String telA = request.getParameter("txttelefono");
                    String estA = request.getParameter("txtestado");
                    String userA = request.getParameter("txtusuario");
                    em.setDni(dniA);
                    em.setNom(nombA);
                    em.setTel(telA);
                    em.setEstado(estA);
                    em.setUser(userA);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.eliminar(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }

        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List listaProducto = pdao.listarProducto();
                    request.setAttribute("productos", listaProducto);
                break;
                case "Agregar":
                    String nom = request.getParameter("txtnombre");
                    String prec = request.getParameter("txtprecio");
                    String stock = request.getParameter("txtstock");
                    String estado = request.getParameter("txtestado");
                    p.setNombres(nom);
                    p.setPrecio(Double.parseDouble(prec));
                    p.setStock(Integer.parseInt(stock));
                    p.setEstado(estado);
                    pdao.AgregarProducto(p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                break;
                case "Editar":
                    ipr = Integer.parseInt(request.getParameter("id"));
                    Producto p = pdao.listarIdProducto(ipr);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nomP = request.getParameter("txtnombre");
                    String precP = request.getParameter("txtprecio");
                    String stockP = request.getParameter("txtstock");
                    String estadoP = request.getParameter("txtestado");
                    Producto prod = new Producto();
                    prod.setNombres(nomP);
                    prod.setPrecio(Double.parseDouble(precP));
                    prod.setStock(Integer.parseInt(stockP));
                    prod.setEstado(estadoP);
                    prod.setId(ipr);
                    pdao.ActualizarProducto(prod);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                break;
                case "Eliminar":
                    ipr = Integer.parseInt(request.getParameter("id"));
                    pdao.EliminarProducto(ipr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }

        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List listaCliente = cdao.listarCliente();
                    request.setAttribute("clientes", listaCliente);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtdni");
                    String nom = request.getParameter("txtnombres");
                    String direc = request.getParameter("txtdireccion");
                    String estC = request.getParameter("txtestado");
                    c.setDni(dni);
                    c.setNombres(nom);
                    c.setDireccion(direc);
                    c.setEstado(estC);
                    cdao.AgregarCliente(c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    icl = Integer.parseInt(request.getParameter("id"));
                    Clientes cl = cdao.listarIdCliente(icl);
                    request.setAttribute("cliente", cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dniA = request.getParameter("txtdni");
                    String nomA = request.getParameter("txtnombres");
                    String direcA = request.getParameter("txtdireccion");
                    String estCA = request.getParameter("txtestado");
                    c.setDni(dniA);
                    c.setNombres(nomA);
                    c.setDireccion(direcA);
                    c.setEstado(estCA);
                    c.setId(icl);
                    cdao.ActualizarCliente(c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    icl = Integer.parseInt(request.getParameter("id"));
                    cdao.EliminarCliente(icl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }

        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigocliente");
                    c.setDni(dni);
                    c = cdao.buscar(dni);
                    request.setAttribute("c", c);
                    request.setAttribute("nserie", numeroserie);
                break;
                case "BuscarProducto":
                    int id=Integer.parseInt(request.getParameter("codigoproducto"));
                    p=pdao.listarIdProducto(id);
                    request.setAttribute("c", c);
                    request.setAttribute("product", p);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("nserie", numeroserie);
                break;
                case "Agregar":
                    request.setAttribute("c", c);
                    request.setAttribute("nserie", numeroserie);
                    totalPagar = 0.0;
                    item = item+1;
                    cod=p.getId();
                    descripcion=request.getParameter("nombreproducto");
                    precio=Double.parseDouble(request.getParameter("precio"));
                    cant=Integer.parseInt(request.getParameter("cant"));
                    subtotal=precio*cant;
                    v=new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcionp(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);
                break;
                case "GenerarVenta":
                    //Actualizar stock
                    for(int i=0; i<lista.size(); i++){
                        Producto pr=new Producto();
                        int cantidad=lista.get(i).getCantidad();
                        int idproducto=lista.get(i).getIdproducto();
                        ProductoDAO aO=new ProductoDAO();
                        pr=aO.buscarProducto(idproducto);
                        int sac=pr.getStock()-cantidad;
                        aO.actualizarStock(idproducto, sac);
                    }
                    
                    //guardar venta
                    
                    request.setAttribute("totalPagar", totalPagar);
                    v.setIdcliente(c.getId());
                    v.setIdempleado(1);
                    v.setNumserie(numeroserie);
                    v.setFecha("2019-06-14");
                    System.out.println(totalPagar);
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardarVenta(v);
                    
                    
                    //guardar detalle-venta
                    int idv=Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        v=new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleventas(v);
                    }
                break;
                case "Eliminar":
                    int idproducto=Integer.parseInt(request.getParameter("ip"));
                    for(int i=0; i < lista.size(); i++){
                        if(lista.get(i).getIdproducto()==idproducto){
                            lista.remove(i);
                        }
                    }
                    request.getRequestDispatcher("Controlador?menu=NuevaVenta&accion=Vista").forward(request, response);
                    
                break;    
                case "Vista":
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                break;
                default:
                    numeroserie = vdao.GenerarSerie();
                    if(numeroserie==null){
                        numeroserie="00000001";
                        request.setAttribute("nserie", numeroserie);
                    }else{
                        int incrementar=Integer.parseInt(numeroserie);
                        GenerarSerie gs =new GenerarSerie();
                        numeroserie=gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    throw new AssertionError();
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
