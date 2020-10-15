
package control;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author kelvin.costa
 */
public class Compras_Produtos {
    
    private int id_compra_prod;
    private int id_produto;
    private int id_forne;
    private int quant;
    private BigDecimal item_valor;
    private Date prazo_pag;
    private Date dt_pag;
    private int id_financeiro;
    private BigDecimal valor_total;

    /*public Compras_Produtos(int id_compra_prod, int id_produto, int id_forne, int quant, BigDecimal item_valor, Date prazo_pag, Date dt_pag, int id_financeiro, BigDecimal valor_total) {
        this.id_compra_prod = id_compra_prod;
        this.id_produto = id_produto;
        this.id_forne = id_forne;
        this.quant = quant;
        this.item_valor = item_valor;
        this.prazo_pag = prazo_pag;
        this.dt_pag = dt_pag;
        this.id_financeiro = id_financeiro;
        this.valor_total = valor_total;
    }*/

    public int getId_compra_prod() {
        return id_compra_prod;
    }

    public void setId_compra_prod(int id_compra_prod) {
        this.id_compra_prod = id_compra_prod;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_forne() {
        return id_forne;
    }

    public void setId_forne(int id_forne) {
        this.id_forne = id_forne;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public BigDecimal getItem_valor() {
        return item_valor;
    }

    public void setItem_valor(BigDecimal item_valor) {
        this.item_valor = item_valor;
    }

    public Date getPrazo_pag() {
        return prazo_pag;
    }

    public void setPrazo_pag(Date prazo_pag) {
        this.prazo_pag = prazo_pag;
    }

    public Date getDt_pag() {
        return dt_pag;
    }

    public void setDt_pag(Date dt_pag) {
        this.dt_pag = dt_pag;
    }

    public int getId_financeiro() {
        return id_financeiro;
    }

    public void setId_financeiro(int id_financeiro) {
        this.id_financeiro = id_financeiro;
    }

    public BigDecimal getValor_total() {
        return valor_total;
    }

    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }
   
}
