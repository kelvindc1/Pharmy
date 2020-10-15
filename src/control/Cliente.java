
package control;

import java.util.Date;

/**
 *
 * @author kelvin.costa
 */
public class Cliente {
    
    private int id_cliente;
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private Date dt_cadastro;
    private String sexo;
    private int id_cid;
    private String situacao;

    /*public Cliente(int id_cliente, String nome, String cpf, String rg, String telefone, Date dt_cadastro, String sexo, int id_cid, String situacao) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.dt_cadastro = dt_cadastro;
        this.sexo = sexo;
        this.id_cid = id_cid;
        this.situacao = situacao;
    }*/

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId_cid() {
        return id_cid;
    }

    public void setId_cid(int id_cid) {
        this.id_cid = id_cid;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
           
}
