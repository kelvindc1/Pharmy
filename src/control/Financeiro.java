
package control;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author kelvin.costa
 */
public class Financeiro {
    
    private int id_financeiro;
    private String tp_conta;
    private BigDecimal valor;
    private Date dt_inicio;
    private Date dt_final = null;
    private Date dt_pag;
    private String obs;
    private BigDecimal multa;
    private int id_forma_pag;

    /*public Financeiro(int id_financeiro, String tp_conta, BigDecimal valor, Date dt_inicio, Date dt_pag, String obs, BigDecimal multa, int id_forma_pag) {
        this.id_financeiro = id_financeiro;
        this.tp_conta = tp_conta;
        this.valor = valor;
        this.dt_inicio = dt_inicio;
        this.dt_pag = dt_pag;
        this.obs = obs;
        this.multa = multa;
        this.id_forma_pag = id_forma_pag;
    }*/

    public int getId_financeiro() {
        return id_financeiro;
    }

    public void setId_financeiro(int id_financeiro) {
        this.id_financeiro = id_financeiro;
    }

    public String getTp_conta() {
        return tp_conta;
    }

    public void setTp_conta(String tp_conta) {
        this.tp_conta = tp_conta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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

    public Date getDt_pag() {
        return dt_pag;
    }

    public void setDt_pag(Date dt_pag) {
        this.dt_pag = dt_pag;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public int getId_forma_pag() {
        return id_forma_pag;
    }

    public void setId_forma_pag(int id_forma_pag) {
        this.id_forma_pag = id_forma_pag;
    }
   
}
