
package control;

import java.util.Date;

public class Filtros {
    
    private Date dt_inicial;
    private Date dt_final;
    private String funcionario;
    private String forma_pagamento;
    private int qtd_itens;
    private boolean situacao;

    /*public Filtros(Date dt_inicial, Date dt_final, String funcionario, String forma_pagamento, int qtd_itens, String situacao) {
        this.dt_inicial = dt_inicial;
        this.dt_final = dt_final;
        this.funcionario = funcionario;
        this.forma_pagamento = forma_pagamento;
        this.qtd_itens = qtd_itens;
        this.situacao = situacao;
    }*/
    
    
    public Date getDt_inicial() {
        return dt_inicial;
    }

    public void setDt_inicial(Date dt_inicial) {
        this.dt_inicial = dt_inicial;
    }

    public Date getDt_final() {
        return dt_final;
    }

    public void setDt_final(Date dt_final) {
        this.dt_final = dt_final;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public int getQtd_itens() {
        return qtd_itens;
    }

    public void setQtd_itens(int qtd_itens) {
        this.qtd_itens = qtd_itens;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
     
    
}
