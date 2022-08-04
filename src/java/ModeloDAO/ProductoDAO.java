/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.ProductoVO;
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
public class ProductoDAO extends ConexionBd implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;

    private String id_producto = "", producto_nombre = "", producto_precio = "", producto_estado = "";

    public ProductoDAO(ProductoVO prodVO) {

        super();
        try {
            
            conexion = this.obtenerConexion();
            id_producto = prodVO.getId_producto();
            producto_nombre = prodVO.getProducto_nombre();
            producto_precio = prodVO.getProducto_precio();
            producto_estado = prodVO.getProducto_estado();
            
        } catch (Exception e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {
       try {
            
            sql="CALL Registrar_Producto(?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, producto_nombre);
            puente.setString(2,producto_precio);
            puente.setString(3,producto_estado);
            
            puente.executeUpdate();
            operacion = true;        
        } catch (SQLException e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try {
                this.deneterConexion();
            } catch (SQLException e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
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
