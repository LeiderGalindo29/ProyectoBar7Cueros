/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

import java.util.logging.Logger;

/**
 *
 * @author Aprendiz
 */
public class desPedidoVO {
    private String id_productoFK, pedidoFK, cantidad_producto, total;

    public desPedidoVO(String id_productoFK, String pedidoFK, String cantidad_producto, String total) {
        this.id_productoFK = id_productoFK;
        this.pedidoFK = pedidoFK;
        this.cantidad_producto = cantidad_producto;
        this.total = total;
    }

    public desPedidoVO() {
    }

    public String getId_productoFK() {
        return id_productoFK;
    }

    public void setId_productoFK(String id_productoFK) {
        this.id_productoFK = id_productoFK;
    }

    public String getPedidoFK() {
        return pedidoFK;
    }

    public void setPedidoFK(String pedidoFK) {
        this.pedidoFK = pedidoFK;
    }

    public String getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(String cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    
    
    
    
    

    

    
}
