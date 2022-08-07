/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.UsuarioDAO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * Daniel
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"})
public class UsuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String usuario_nombre = request.getParameter("usuario_nombre");
        String usuario_password = request.getParameter("usuario_password");
        String usuario_apellido = request.getParameter("usuario_apellido");
        String usuario_estado = request.getParameter("usuario_estado");
        String id_usuario = request.getParameter("id_usuario");
        String id_rol = request.getParameter("rol");

        int valor = Integer.parseInt(request.getParameter("valor"));

        UsuarioVO usuVO = new UsuarioVO(id_usuario, usuario_nombre, usuario_apellido, usuario_password, usuario_estado, id_rol);

        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);

        switch (valor) {
            case 1://Iniciar sesión
                if (usuDAO.inicioSesion(usuario_nombre, usuario_password)) {
                    HttpSession sesion = request.getSession(true);
                    usuVO = new UsuarioVO(id_usuario, usuario_nombre, usuario_apellido, usuario_password, usuario_estado, id_rol);
                    sesion.setAttribute("datos", usuVO);
                    
                    
                    usuDAO = new UsuarioDAO();
                    usuVO = new UsuarioVO();

                    ArrayList<UsuarioVO> listaRol = usuDAO.listar(usuario_nombre);
                    for (int i = 0; i < listaRol.size(); i++) {
                        usuVO = listaRol.get(i);
                    }
                    String rolTipo = usuVO.getId_rol();

                    if (rolTipo.equals("1")) {
                        request.getRequestDispatcher("view/Administrador.jsp").forward(request, response);
                    } else if (rolTipo.equals("2")) {
                        request.getRequestDispatcher("view/Mesero.jsp").forward(request, response);
                    } else if (rolTipo.equals("3")) {
                        request.getRequestDispatcher("view/Cajero.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("Error", "Datos Incorrectos");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
