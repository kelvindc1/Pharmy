
package control;

import java.math.BigDecimal;

/**
 *
 * @author kelvin.costa
 */
public class Servicos {
    
    private int id_servicos;
    private int id_tpservicos;
    private String descricao;
    private BigDecimal valor;
    private String situacao;

    /*public Servicos(int id_servicos, int id_tpservicos, String descricao, BigDecimal valor, String situacao) {
        this.id_servicos = id_servicos;
        this.id_tpservicos = id_tpservicos;
        this.descricao = descricao;
        this.valor = valor;
        this.situacao = situacao;
    }*/

    public int getId_servicos() {
        return id_servicos;
    }

    public void setId_servicos(int id_servicos) {
        this.id_servicos = id_servicos;
    }

    public int getId_tpservicos() {
        return id_tpservicos;
    }

    public void setId_tpservicos(int id_tpservicos) {
        this.id_tpservicos = id_tpservicos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
  
}
