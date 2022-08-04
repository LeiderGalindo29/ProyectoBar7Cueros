/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @David
 */
public class RolVO {
    private String id_rol, rol_tipo;

    public RolVO(String id_rol, String rol_tipo) {
        this.id_rol = id_rol;
        this.rol_tipo = rol_tipo;
    }

    public RolVO() {
    }

    public String getId_rol() {
        return id_rol;
    }

    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }

    public String getRol_tipo() {
        return rol_tipo;
    }

    public void setRol_tipo(String rol_tipo) {
        this.rol_tipo = rol_tipo;
    }
    
    
}
