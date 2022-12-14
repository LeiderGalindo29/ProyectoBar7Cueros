/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.ClienteVO;
import ModeloVO.ProductoVO;
import Util.ConexionBd;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    private String id_producto = "", producto_nombre = "", producto_precio = "", producto_estado = "", producto_cantidad="";

    public ProductoDAO(ProductoVO prodVO) {

        super();
        try {
            
            conexion = this.obtenerConexion();
            id_producto = prodVO.getId_producto();
            producto_nombre = prodVO.getProducto_nombre();
            producto_precio = prodVO.getProducto_precio();
            producto_estado = prodVO.getProducto_estado();
            producto_cantidad = prodVO.getProducto_cantidad();
            
        } catch (Exception e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ProductoDAO() {
    }

    @Override
    public boolean agregarRegistro() {
       try {
            
            sql="CALL Registrar_Producto(?, ?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, producto_nombre);
            puente.setString(2,producto_precio);
            puente.setString(3,producto_estado);
            puente.setString(4,producto_cantidad);
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

    public ArrayList<ProductoVO> listar(){
        ArrayList<ProductoVO> listaProducto = new ArrayList<>();
        
        try {
            conexion = this.obtenerConexion();
            sql="call listarProducto";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {                    
                    ProductoVO prodVO = new ProductoVO(mensajero.getString(1), mensajero.getString(2),
                            mensajero.getString(3),mensajero.getString(4),mensajero.getString(5));
                    listaProducto.add(prodVO);
                }
        } catch (SQLException e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try {
                this.deneterConexion();
            } catch (SQLException e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaProducto;
    }
        public ProductoVO buscar(String producto_nombre){
        
        ProductoVO prodVO = new ProductoVO();
        try {
            conexion = this.obtenerConexion();
            sql ="select * from producto where producto_nombre=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, producto_nombre);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {

            prodVO = new ProductoVO(mensajero.getString(1), mensajero.getString(2),mensajero.getString(3),mensajero.getString(4),mensajero.getString(5));
             
 
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
                try {
                    this.deneterConexion();
                } catch (SQLException e) {
                    Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        
        return prodVO;
    }
}
