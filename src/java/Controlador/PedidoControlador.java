/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.PedidoDAO;
import ModeloDAO.desPedidoDAO;
import ModeloVO.PedidoVO;
import ModeloVO.desPedidoVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alrod
 */
@WebServlet(name = "PedidoControlador", urlPatterns = {"/Pedido"})
public class PedidoControlador extends HttpServlet {

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
        
        String id_pedido = request.getParameter("id");
        String id_UsuarioFK = request.getParameter("usuario");
        String clienteFK = request.getParameter("cliente");
        String mesaFK = request.getParameter("mesa");
        String sub_total = request.getParameter("subtotal");
        String pedido_estado = request.getParameter("estado");
        String metodo_pago = request.getParameter("metodopago");
        String fecha = request.getParameter("fecha");
        
        int valor = Integer.parseInt(request.getParameter("valor"));
        
        PedidoVO pedVO = new PedidoVO(id_pedido, id_UsuarioFK, clienteFK, mesaFK, sub_total, pedido_estado, metodo_pago, fecha);
        
        PedidoDAO pedDAO = new PedidoDAO(pedVO);
        
        
        switch(valor){
            case 1:
                    if(pedDAO.agregarRegistro()){
                        request.getRequestDispatcher("desPedido.jsp").forward(request, response);
                                desPedidoVO desVO = new desPedidoVO();
                                desPedidoDAO desDAO = new desPedidoDAO();
                                desDAO.listar();
                                
                    }else{
                        request.setAttribute("mensajeError", "El pedido no se registro correctamente");
                    }
                    request.getRequestDispatcher("finalProduct.jsp").forward(request, response);
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
