
package control;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author kelvin.costa
 */
public class Desconto {
    
    private int id_desconto;
    private String descricao;
    private int id_produto;
    private int id_cat;
    private Date dt_inicio;
    private Date dt_final;
    private BigDecimal valor_desconto;
    private String tp_valor;
    private String situacao;

    /*public Desconto(int id_desconto, String descricao, int id_produto, int id_cat, Date dt_inicio, Date dt_final, BigDecimal valor_desconto, String tp_valor, String situacao) {
        this.id_desconto = id_desconto;
        this.descricao = descricao;
        this.id_produto = id_produto;
        this.id_cat = id_cat;
        this.dt_inicio = dt_inicio;
        this.dt_final = dt_final;
        this.valor_desconto = valor_desconto;
        this.tp_valor = tp_valor;
        this.situacao = situacao;
    }*/

    public int getId_desconto() {
        return id_desconto;
    }

    public void setId_desconto(int id_desconto) {
        this.id_desconto = id_desconto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public Date getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(Date dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public Date getDt_final() {
        return dt_final;
    }

    public void setDt_final(Date dt_final) {
        this.dt_final = dt_final;
    }

    public BigDecimal getValor_desconto() {
        return valor_desconto;
    }

    public void setValor_desconto(BigDecimal valor_desconto) {
        this.valor_desconto = valor_desconto;
    }

    public String getTp_valor() {
        return tp_valor;
    }

    public void setTp_valor(String tp_valor) {
        this.tp_valor = tp_valor;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
       
}
