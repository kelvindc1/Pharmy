
package control;

/**
 *
 * @author kelvin.costa
 */
public class Funcao {
    
    private int id_funcao;
    private String nome;
    private String descricao;
    private String situacao;

    /*public Funcao(int id_funcao, String nome, String descricao, String situacao) {
        this.id_funcao = id_funcao;
        this.nome = nome;
        this.descricao = descricao;
        this.situacao = situacao;
    }*/

    public int getId_funcao() {
        return id_funcao;
    }

    public void setId_funcao(int id_funcao) {
        this.id_funcao = id_funcao;
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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
         
}
