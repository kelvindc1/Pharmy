
package control;

import java.math.BigDecimal;

/**
 *
 * @author kelvin.costa
 */
public class Beneficio {
    
    private int id_beneficio;
    private String descricao;
    private BigDecimal valor;
    private int id_contrato;
    private int id_tpbeneficio;
    private String situacao;

    /*public Benefício(int id_beneficio, String descricao, BigDecimal valor, int id_contrato, int id_tpbeneficio, String situacao) {
        this.id_beneficio = id_beneficio;
        this.descricao = descricao;
        this.valor = valor;
        this.id_contrato = id_contrato;
        this.id_tpbeneficio = id_tpbeneficio;
        this.situacao = situacao;
    }*/

    public int getId_beneficio() {
        return id_beneficio;
    }

    public void setId_beneficio(int id_beneficio) {
        this.id_beneficio = id_beneficio;
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

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public int getId_tpbeneficio() {
        return id_tpbeneficio;
    }

    public void setId_tpbeneficio(int id_tpbeneficio) {
        this.id_tpbeneficio = id_tpbeneficio;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
     
}
