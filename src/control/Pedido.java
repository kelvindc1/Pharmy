
package control;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kelvin.costa
 */
public class Pedido {
    
    private int id_pedido;
    private int id_cliente;
    private int id_func;
    private Date dt_pedido;
    private Date dt_pag;
    private BigDecimal valor_total;
    private int id_financeiro;
    private String situacao;
    private int qtd_total_itens;
    private List<ItensPedido> itensPedido = new ArrayList<>();

    /*public Pedido(int id_pedido, int id_cliente, int id_func, Date dt_pedido, Date dt_pag, BigDecimal valor_total, int id_financeiro, String situacao) {
        this.id_pedido = id_pedido;
        this.id_cliente = id_cliente;
        this.id_func = id_func;
        this.dt_pedido = dt_pedido;
        this.dt_pag = dt_pag;
        this.valor_total = valor_total;
        this.id_financeiro = id_financeiro;
        this.situacao = situacao;
    }*/

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public Date getDt_pedido() {
        return dt_pedido;
    }

    public void setDt_pedido(Date dt_pedido) {
        this.dt_pedido = dt_pedido;
    }

    public Date getDt_pag() {
        return dt_pag;
    }

    public void setDt_pag(Date dt_pag) {
        this.dt_pag = dt_pag;
    }

    public BigDecimal getValor_total() {
        return valor_total;
    }

    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }

    public int getId_financeiro() {
        return id_financeiro;
    }

    public void setId_financeiro(int id_financeiro) {
        this.id_financeiro = id_financeiro;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    public int getQtd_total_itens() {
        return qtd_total_itens;
    }

    public void setQtd_total_itens(int qtd_total_itens) {
        this.qtd_total_itens = qtd_total_itens;
    }
    
    public List<ItensPedido> getItensPedido() {
        return itensPedido;
    }

    private void setItensPedido(List<ItensPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public void adicionarItemPedido(ItensPedido item) {
        if (this.itensPedido == null) {
            this.itensPedido = new ArrayList<>();
        }
        item.setPedido(this);
        this.itensPedido.add(item);
    }

    public void removerItemPedido(ItensPedido item) {
        if (this.itensPedido.contains(item)) {
            this.itensPedido.remove(item);
        }
    }

    public int tamanhoListItens() {
        return this.itensPedido.size();
    }
        
    public void calcularValorTotal() {
        this.valor_total = BigDecimal.valueOf((double) 0);
        
        //this.itensPedido.forEach(p -> this.valor_total = this.valor_total.add(p.getValor_unit()) * p.getItem_quant());
        
        //this.itensPedido.forEach(p -> this.valor_total = this.valor_total + p.getValor_unit() * p.getItem_quant());
        
    }

    public void calcularTotalItens() {
        this.qtd_total_itens = 0;
        this.itensPedido.forEach(p -> this.qtd_total_itens = p.getItem_quant() + this.qtd_total_itens);
    }
    

    /*public String toString() {
        return "Pedido{" + "id_pedido=" + id_pedido + ", situacao=" 
                + situacao + ", id_func=" + id_func + ", valor_total=" + valor_total 
                + ", qtd_total_itens=" + qtd_total_itens + ", dt_pedido=" + dt_pedido + '}'; 
                + ", id_pag=" + id_pag + ", itensPedido=" + itensPedido.toString() + '}';
    }*/
    
    @Override
    public String toString() {
        return "Pedido{" + "id_pedido=" + id_pedido + ", id_cliente=" 
                + id_cliente + ", id_func=" + id_func + ", dt_pedido=" + dt_pedido
                + ", dt_pag=" + dt_pag + ", valor_total=" + valor_total   
                + ", id_financeiro=" + id_financeiro + ", situacao=" + situacao
                + ", qtd_total_itens=" + qtd_total_itens 
                + ", itensPedido=" + itensPedido.toString() + '}';              
    } 
}
