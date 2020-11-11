/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Win10
 */
public class ItensPedido {
    
    private int id_itens_ped;
    private int id_pedido;
    private int id_produto;
    private int item_guant;
    private double valor_unit;
    private int id_servicos;

    public int getId_itens_ped() {
        return id_itens_ped;
    }

    public void setId_itens_ped(int id_itens_ped) {
        this.id_itens_ped = id_itens_ped;
    }

    public int getId_pedido() {
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
    }

    public int getItem_guat() {
        return item_guant;
    }

    public void setItem_guat(int item_guat) {
        this.item_guant = item_guat;
    }

    public double getValor_unit() {
        return valor_unit;
    }

    public void setValor_unit(double valor_unit) {
        this.valor_unit = valor_unit;
    }

    public int getId_servicos() {
        return id_servicos;
    }

    public void setId_servicos(int id_servicos) {
        this.id_servicos = id_servicos;
    }
    
}
