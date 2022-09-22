/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.PedidoVO;
import Util.ConexionBd;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class PedidoDAO extends ConexionBd implements Crud{

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;

    private String id_pedido = "", id_usuarioFK = "",clienteFK = "",mesaFK="",sub_total="",metodo_pago="",fecha="", pedido_estado = "";

    public PedidoDAO(PedidoVO pedVO) {

        super();
        try {
            conexion = this.obtenerConexion();
            id_pedido = pedVO.getId_pedido();
            id_usuarioFK = pedVO.getId_usuarioFK();
            clienteFK = pedVO.getClienteFK();
            mesaFK = pedVO.getMesaFK();
            sub_total = pedVO.getMesaFK();
            metodo_pago = pedVO.getMetodo_pago();
            fecha = pedVO.getFecha();
            pedido_estado = pedVO.getPedido_estado();

        } catch (Exception e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
        
    }

    public PedidoDAO() {
    }
    

    @Override
    public boolean agregarRegistro() {
        try {
            conexion = this.obtenerConexion();
            sql="call registrarPedido(?,?,?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_usuarioFK);
            puente.setString(2, clienteFK);
            puente.setString(3, mesaFK);
            puente.setString(4, sub_total);
            puente.setString(5, pedido_estado);
            puente.setString(6, metodo_pago);
            
            puente.executeUpdate();
            operacion = true;        
        } catch (SQLException e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try {
                this.deneterConexion();
            } catch (SQLException e) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
    }
        return operacion;
        
    }

    @Override
    public boolean actualizarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
