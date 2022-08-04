/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
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
 * David
 */
public class UsuarioDAO extends ConexionBd implements Crud{

   //1. Declarar variables
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    private String id_usuario = "", usuario_nombre = "", usuario_apellido="", usuario_password = "", usuario_estado="", id_rol="";

    //2. Metodo principal para recibir datos del VO
    public UsuarioDAO(UsuarioVO usuVO) {
        super();
        //2.1 Conectarte
        try {
            conexion = this.obtenerConexion();

            //2.2  Traigo los datos del VO
            id_usuario = usuVO.getId_usuario();
            usuario_nombre = usuVO.getUsuario_nombre();
            usuario_password = usuVO.getUsuario_password();

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregarRegistro() {

        try {
            sql = "insert into usuario(usuario_nombre,usuario_password) values (?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario_nombre);
            puente.setString(2, usuario_password);
            puente.setString(3, id_rol);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.deneterConexion();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return operacion;

    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update usuario set usuario_nombre=?, usuario_password=? where id_usuario=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario_nombre);
            puente.setString(2, usuario_password);
            puente.setString(3, id_rol);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.deneterConexion();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return operacion;

    }

    @Override
    public boolean eliminarRegistro() {
        try {
            sql = "delete usuario set usuario_nombre=?,usuario_password=? where id_usuario=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario_nombre);
            puente.setString(2, usuario_password);
            puente.setString(3, id_rol);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.deneterConexion();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return operacion;

    }
    

    public boolean inicioSesion(String usuario_nombre, String usuario_password, String id_rol) {
        try {
            conexion = this.obtenerConexion();
            sql = "call login(?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario_nombre);
            puente.setString(2, usuario_password);
            puente.setString(3, id_rol);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                operacion = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.deneterConexion();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return operacion;
    }
    
}
