
package control;

/**
 *
 * @author kelvin.costa
 */
public class Tipo_Servicos {
    
    private int id_tpservicos;
    private String descricao;
    private String situacao;

    /*public Tipo_Servicos(int id_tpservicos, String descricao, String situacao) {
        this.id_tpservicos = id_tpservicos;
        this.descricao = descricao;
        this.situacao = situacao;
    }*/

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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
       
}
