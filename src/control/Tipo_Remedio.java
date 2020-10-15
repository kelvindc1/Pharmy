
package control;

/**
 *
 * @author kelvin.costa
 */
public class Tipo_Remedio {
    
    private int id_tpremedio;
    private String descricao;
    private String situacao;

    /*public Tipo_Remedio(int id_tpremedio, String descricao, String situacao) {
        this.id_tpremedio = id_tpremedio;
        this.descricao = descricao;
        this.situacao = situacao;
    }*/

    public int getId_tpremedio() {
        return id_tpremedio;
    }

    public void setId_tpremedio(int id_tpremedio) {
        this.id_tpremedio = id_tpremedio;
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
