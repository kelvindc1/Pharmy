
package control;

/**
 *
 * @author kelvin.costa
 */
public class Setor {
    
    private int id_setor;
    private String nome;
    private String descricao;
    private int id_cargo;
    private String situacao;

    /*public Setor(int id_setor, String nome, String descricao, int id_cargo, String situacao) {
        this.id_setor = id_setor;
        this.nome = nome;
        this.descricao = descricao;
        this.id_cargo = id_cargo;
        this.situacao = situacao;
    }*/

    public int getId_setor() {
        return id_setor;
    }

    public void setId_setor(int id_setor) {
        this.id_setor = id_setor;
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

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
     
}
