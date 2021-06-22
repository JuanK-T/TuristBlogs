package com.example.Login;

import Modelo.Usuario;
import Modelo.UsuarioDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;// libreria para multipartConfig
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.Part; //libreria procesar imagenes como objetos part

@MultipartConfig // ->clave para recibir los datos de imagen de un formulario
/**
 * Servlet implementation class UsuarioController
 */
@WebServlet(name = "UsuarioController", value = "/UsuarioController")
public class UsuarioController extends HttpServlet {
    private static final long serialVersionUID = 1l;

    private static String LOGIN = "index.jsp";
    private static String PRINCIPAL = "Vista/MenuPrincipal.jsp";
    private static String PERFIL = "Vista/Perfil.jsp";
    private static String ACTUALIZAR = "Vista/Actualizar.jsp";


    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Servet at: ").append(request.getContextPath());

        String forward = "";
        String accion = request.getParameter("accion");
        HttpSession sesiones = request.getSession();

        if(accion == null) {
            request.getRequestDispatcher("UsuarioController?accion=Login&mensaje=Usted no ingreso").forward(request, response);
        } else if(accion.equalsIgnoreCase("Perfil"))
        {
            System.out.println(accion);
            sesiones.setAttribute("nombreUsuario", usuario);
            forward = PERFIL;
            request.getRequestDispatcher(forward).forward(request, response);

        }else if(accion.equalsIgnoreCase("Cargar"))
        {
                int id = Integer.parseInt(request.getParameter("idUsuario"));
                usuario = usuarioDAO.ConsultarId(id);
                request.setAttribute("datos", usuario);//devolver datos a la vista
                forward = ACTUALIZAR;
                request.getRequestDispatcher(forward).forward(request, response);
        }else if(accion.equalsIgnoreCase("Buscar")){
            String criterio = request.getParameter("criterio");
            List filtrar = usuarioDAO.Buscar(criterio);
            forward = PRINCIPAL;
            request.setAttribute("usuarios", filtrar);
            request.getRequestDispatcher(forward).forward(request, response);
        }else if(accion.equalsIgnoreCase("Salir"))
        {
            sesiones.invalidate();
            forward = LOGIN;
            request.getRequestDispatcher(forward).forward(request, response);
        }else if(accion.equalsIgnoreCase("Eliminar"))
        {
            int id = Integer.parseInt(request.getParameter("idUsuario"));
            usuarioDAO.Eliminar(id);
            forward = LOGIN;
            request.getRequestDispatcher(forward).forward(request, response);
        }else if(accion.equalsIgnoreCase("Principal")){
            forward = PRINCIPAL;
            request.getRequestDispatcher(forward).forward(request, response);
        }else if(accion.equalsIgnoreCase("Login")){
            forward = LOGIN;
            request.getRequestDispatcher(forward).forward(request, response);
        }
        //RequestDispatcher vista = request.getRequestDispatcher(forward);
        //vista.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        HttpSession sesiones = request.getSession();
        String accion = request.getParameter("accion");

        try {
            if (accion.equalsIgnoreCase("registrar")) {

                //REGISTRAR
                //traemos los valores de la vista
                String nombre = request.getParameter("nombre");
                long telefono = Long.parseLong(request.getParameter("telefono"));
                String correo = request.getParameter("correo");
                String user = request.getParameter("usuario");
                String contrasena = request.getParameter("contrasena");
                Part part = request.getPart("fotoUsuario");
                InputStream inputStream = part.getInputStream();//Se realiza una convercion

                usuario.setNombre(nombre);
                usuario.setTelefono(telefono);
                usuario.setCorreo(correo);
                usuario.setUser(user);
                usuario.setContrasena(contrasena);
                usuario.setFotoUsuario(inputStream);

                String idUsuario = request.getParameter("idUsuario");
                if (idUsuario == null || idUsuario.isEmpty()) {
                    usuarioDAO.Registrar(usuario);
                    List lista = usuarioDAO.Listar();
                    forward = LOGIN;

                    //Enviar a la vista atravez de SetAttribute
                    request.setAttribute("usuarios", lista);
                    //Redirigir a los usuarios a la vista
                    request.getRequestDispatcher(forward).forward(request, response);
                } else {
                    System.out.println("Actualizar");
                    int id = Integer.parseInt(request.getParameter("idUsuario"));
                    usuario.setIdUsuario(id);
                    usuarioDAO.Actualizar(usuario);
                    List lista = usuarioDAO.Listar();
                    request.setAttribute("usuarios", lista);
                    forward = PRINCIPAL;
                    request.getRequestDispatcher(forward).forward(request, response);
                }
            } else if (accion.equalsIgnoreCase("Ingresar")) {

                //VALIDAR
                System.out.println(accion);
                String nombreUsuario = request.getParameter("nombreUsuario");//traer de la vistas via get o via post
                String contrasenaUsuario = request.getParameter("contrasenaUsuario");

                usuario.setCorreo(nombreUsuario);
                usuario.setContrasena(contrasenaUsuario);

                usuario = usuarioDAO.validarUsuario(nombreUsuario, contrasenaUsuario);

                if (usuario.getCorreo() != null && usuario.getContrasena() != null) {
                    System.out.println("Login Encontrado");
                    sesiones.setAttribute("nombreUsuario", usuario);

                    //Mostrar Tabla
                    List lista = usuarioDAO.Listar();
                    request.setAttribute("usuarios", lista);
                    forward = PRINCIPAL;
                    request.getRequestDispatcher(forward).forward(request, response);
                } else {
                    System.out.println("Login no encontrado");
                    forward = LOGIN;
                    request.getRequestDispatcher(forward).forward(request, response);
                }
            }
        }catch(Exception e){
            System.out.println("Error lindo " + e.getMessage());
        }
    }
}
