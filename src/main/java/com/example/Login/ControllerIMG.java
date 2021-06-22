package com.example.Login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import Modelo.Usuario;
import Modelo.UsuarioDAO;

@WebServlet(name = "ControllerIMG", value = "/ControllerIMG")
public class ControllerIMG extends HttpServlet {
    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            int id = Integer.parseInt(request.getParameter("id"));
            usuarioDAO.listarImg(id, response);
        }catch (Exception e){
            System.out.println("Error en el Controlador Imagen " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
    }
}
