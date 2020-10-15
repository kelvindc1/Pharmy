
package control;

import java.util.Date;

/**
 *
 * @author kelvin.costa
 */
public class Funcionario {
    
    private int id_func;
    private String nome;
    private String cpf;
    private String rg;
    private Date dt_nasc;
    private Date dt_admissao;
    private Date dt_demissao = null;
    private String sexo;
    private String telefone;
    private int id_contrato;
    private int id_cid;
    private int id_dados;
    private String situacao;

    /*public Funcionario(int id_func, String nome, String cpf, String rg, Date dt_nasc, Date dt_admissao, String sexo, String telefone, int id_contrato, int id_cid, int id_dados, String situacao) {
        this.id_func = id_func;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dt_nasc = dt_nasc;
        this.dt_admissao = dt_admissao;
        this.sexo = sexo;
        this.telefone = telefone;
        this.id_contrato = id_contrato;
        this.id_cid = id_cid;
        this.id_dados = id_dados;
        this.situacao = situacao;
    }*/

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
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

    public Date getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(Date dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    public Date getDt_admissao() {
        return dt_admissao;
    }

    public void setDt_admissao(Date dt_admissao) {
        this.dt_admissao = dt_admissao;
    }

    public Date getDt_demissao() {
        return dt_demissao;
    }

    public void setDt_demissao(Date dt_demissao) {
        this.dt_demissao = dt_demissao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public int getId_cid() {
        return id_cid;
    }

    public void setId_cid(int id_cid) {
        this.id_cid = id_cid;
    }

    public int getId_dados() {
        return id_dados;
    }

    public void setId_dados(int id_dados) {
        this.id_dados = id_dados;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
     
}
