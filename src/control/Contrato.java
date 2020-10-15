
package control;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author kelvin.costa
 */
public class Contrato {
    private int id_contrato;
    private int id_setor;
    private BigDecimal sal_ant;
    private BigDecimal sal_novo;
    private Date dt_alteracao;
    private String obs;

    /*public Contrato(int id_contrato, int id_setor, BigDecimal sal_ant, BigDecimal sal_novo, Date dt_alteracao, String obs) {
        this.id_contrato = id_contrato;
        this.id_setor = id_setor;
        this.sal_ant = sal_ant;
        this.sal_novo = sal_novo;
        this.dt_alteracao = dt_alteracao;
        this.obs = obs;
    }*/

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public int getId_setor() {
        return id_setor;
    }

    public void setId_setor(int id_setor) {
        this.id_setor = id_setor;
    }

    public BigDecimal getSal_ant() {
        return sal_ant;
    }

    public void setSal_ant(BigDecimal sal_ant) {
        this.sal_ant = sal_ant;
    }

    public BigDecimal getSal_novo() {
        return sal_novo;
    }

    public void setSal_novo(BigDecimal sal_novo) {
        this.sal_novo = sal_novo;
    }

    public Date getDt_alteracao() {
        return dt_alteracao;
    }

    public void setDt_alteracao(Date dt_alteracao) {
        this.dt_alteracao = dt_alteracao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
       
}
