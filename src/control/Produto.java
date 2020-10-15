
package control;

import java.math.BigDecimal;

/**
 *
 * @author kelvin.costa
 */
public class Produto {
    
    private int id_produto;
    private int id_cat;
    private int id_marca;
    private String nome;
    private String gramatura;
    private String descricao;
    private int id_forne;
    private int id_tpremedio;
    private BigDecimal preco;
    private String tipo;
    private String situacao;

    /*public Produto(int id_produto, int id_cat, int id_marca, String nome, String gramatura, String descricao, int id_forne, int id_tpremedio, BigDecimal preco, String tipo, String situacao) {
        this.id_produto = id_produto;
        this.id_cat = id_cat;
        this.id_marca = id_marca;
        this.nome = nome;
        this.gramatura = gramatura;
        this.descricao = descricao;
        this.id_forne = id_forne;
        this.id_tpremedio = id_tpremedio;
        this.preco = preco;
        this.tipo = tipo;
        this.situacao = situacao;
    }*/

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGramatura() {
        return gramatura;
    }

    public void setGramatura(String gramatura) {
        this.gramatura = gramatura;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId_forne() {
        return id_forne;
    }

    public void setId_forne(int id_forne) {
        this.id_forne = id_forne;
    }

    public int getId_tpremedio() {
        return id_tpremedio;
    }

    public void setId_tpremedio(int id_tpremedio) {
        this.id_tpremedio = id_tpremedio;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
       
}
