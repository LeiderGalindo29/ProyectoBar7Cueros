/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author David
 */
public class PedidoVO {
    private String id_pedido, id_usuarioFK, id_mesaFK, id_clienteFK, pedido_estado, producto_cantidad, productos_nombre, valor_pedido, metodo_pago;

    public PedidoVO(String id_pedido, String id_usuarioFK, String id_mesaFK, String id_clienteFK, String pedido_estado, String producto_cantidad, String productos_nombre, String valor_pedido, String metodo_pago) {
        this.id_pedido = id_pedido;
        this.id_usuarioFK = id_usuarioFK;
        this.id_mesaFK = id_mesaFK;
        this.id_clienteFK = id_clienteFK;
        this.pedido_estado = pedido_estado;
        this.producto_cantidad = producto_cantidad;
        this.productos_nombre = productos_nombre;
        this.valor_pedido = valor_pedido;
        this.metodo_pago = metodo_pago;
    }

    public PedidoVO() {
    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getId_usuarioFK() {
        return id_usuarioFK;
    }

    public void setId_usuarioFK(String id_usuarioFK) {
        this.id_usuarioFK = id_usuarioFK;
    }

    public String getId_mesaFK() {
        return id_mesaFK;
    }

    public void setId_mesaFK(String id_mesaFK) {
        this.id_mesaFK = id_mesaFK;
    }

    public String getId_clienteFK() {
        return id_clienteFK;
    }

    public void setId_clienteFK(String id_clienteFK) {
        this.id_clienteFK = id_clienteFK;
    }

    public String getPedido_estado() {
        return pedido_estado;
    }

    public void setPedido_estado(String pedido_estado) {
        this.pedido_estado = pedido_estado;
    }

    public String getProducto_cantidad() {
        return producto_cantidad;
    }

    public void setProducto_cantidad(String producto_cantidad) {
        this.producto_cantidad = producto_cantidad;
    }

    public String getProductos_nombre() {
        return productos_nombre;
    }

    public void setProductos_nombre(String productos_nombre) {
        this.productos_nombre = productos_nombre;
    }

    public String getValor_pedido() {
        return valor_pedido;
    }

    public void setValor_pedido(String valor_pedido) {
        this.valor_pedido = valor_pedido;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
    
}
