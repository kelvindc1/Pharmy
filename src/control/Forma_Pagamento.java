
package control;

/**
 *
 * @author kelvin.costa
 */
public class Forma_Pagamento {
    
    private int id_forma_pag;
    private String nome;
    private String descricao;

    /*public Forma_Pagamento(int id_forma_pag, String nome, String descricao) {
        this.id_forma_pag = id_forma_pag;
        this.nome = nome;
        this.descricao = descricao;
    }*/

    public int getId_forma_pag() {
        return id_forma_pag;
    }

    public void setId_forma_pag(int id_forma_pag) {
        this.id_forma_pag = id_forma_pag;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
       
}
