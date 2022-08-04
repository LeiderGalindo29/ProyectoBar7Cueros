/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.ClienteVO;
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
 * @author 57314
 */
public class ClienteDAO extends ConexionBd implements Crud{
    
     private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    
    private String id_cliente="", numero_documento="", cliente_nombre="", cliente_apellido="", cliente_estado="", cliente_correo="", fecha_nacimiento="", tipo_documento="";
     
    
    
    
    public ClienteDAO(ClienteVO clientVO){
        super();
        try {
  
        conexion = this.obtenerConexion();
        id_cliente = clientVO.getId_cliente();
        numero_documento= clientVO.getNumero_documento();
        cliente_nombre = clientVO.getCliente_nombre();
        cliente_apellido = clientVO.getCliente_apellido();
        cliente_estado = clientVO.getCliente_estado();
        cliente_correo = clientVO.getCliente_correo();
        fecha_nacimiento = clientVO.getFecha_nacimiento();
        tipo_documento = clientVO.getTipo_documento();
        
        } catch (Exception e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
                
     
    }

    @Override
    public boolean agregarRegistro() {
         try {
            
            sql="CALL Registrar_Cliente(?, ?, ?, ?, ?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, numero_documento);
            puente.setString(2, cliente_nombre);
            puente.setString(3, cliente_apellido);
            puente.setString(4, cliente_estado);
            puente.setString(5, cliente_correo);
            puente.setString(6, fecha_nacimiento);
            puente.setString(7, tipo_documento);
            
            
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
