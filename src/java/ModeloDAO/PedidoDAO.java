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

    private String id_pedido = "", id_usuarioFK = "", id_mesaFK = "", id_clienteFK = "", pedido_estado = "", producto_cantidad = "", productos_nombre = "", valor_pedido = "", metodo_pago = "";

    public PedidoDAO(PedidoVO pedVO) {

        super();
        try {
            conexion = this.deneterConexion();
            id_pedido = pedVO.getId_pedido();
            id_usuarioFK = pedVO.getId_usuarioFK();
            id_mesaFK = pedVO.getId_mesaFK();
            id_clienteFK = pedVO.getId_clienteFK();
            pedido_estado = pedVO.getPedido_estado();
            producto_cantidad = pedVO.getProducto_cantidad();
            productos_nombre = pedVO.getProductos_nombre();
            valor_pedido = pedVO.getValor_pedido();
            metodo_pago = pedVO.getMetodo_pago();

        } catch (SQLException e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
        
    }

    @Override
    public boolean agregarRegistro() {
        try {
            
            sql="insert";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_pedido);
            
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
