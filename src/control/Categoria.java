
package control;

/**
 *
 * @author kelvin.costa
 */
public class Categoria {
    
    private int id_cat;
    private String descricao;
    private String situacao;

    /*public Categoria(int id_cat, String descricao, String situacao) {
        this.id_cat = id_cat;
        this.descricao = descricao;
        this.situacao = situacao;
    }*/

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
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
