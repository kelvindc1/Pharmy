/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.math.BigDecimal;

/**
 *
 * @author Win10/Kelvin
 */
public class ItensPedido {
    
    private int id_itens_ped;
    //private int id_pedido;
    //private int id_produto;
    private Pedido pedido;
    private Produto produto;
    private int item_quant;
    private BigDecimal valor_unit;
    private int id_servicos;

    
    public int getId_itens_ped() {
        return id_itens_ped;
    }

    public void setId_itens_ped(int id_itens_ped) {
        this.id_itens_ped = id_itens_ped;
    }
    
     public int getItem_quant() {
        return item_quant;
    }

    public void setItem_quant(int item_quant) {
        this.item_quant = item_quant;
    }

    /*public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }*/
    public BigDecimal getValor_unit() {
        return valor_unit;
    }

    public void setValor_unit(BigDecimal valor_unit) {
        this.valor_unit = valor_unit;
    }

    public int getId_servicos() {
        return id_servicos;
    }

    public void setId_servicos(int id_servicos) {
        this.id_servicos = id_servicos;
    }
    
    @Override
    public String toString() {
        return "ItensPedido{" + "id_itens_ped=" + id_itens_ped + ", pedido=" + pedido + ", produto=" + produto + ", item_quant =" + item_quant + ", valor_unit=" + valor_unit + ", id_servicos =" + id_servicos + '}';
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

   
    
}
