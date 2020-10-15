
package control;

/**
 *
 * @author kelvin.costa
 */
public class Cargo {
    
    private int id_cargo;
    private String nome;
    private String descricao;
    private int id_funcao;
    private String situacao;

    /*public Cargo(int id_cargo, String nome, String descricao, int id_funcao, String situacao) {
        this.id_cargo = id_cargo;
        this.nome = nome;
        this.descricao = descricao;
        this.id_funcao = id_funcao;
        this.situacao = situacao;
    }*/

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
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

    public int getId_funcao() {
        return id_funcao;
    }

    public void setId_funcao(int id_funcao) {
        this.id_funcao = id_funcao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
        
}
