
package control;

import java.util.Date;

/**
 *
 * @author kelvin.costa
 */
public class Fornecedor {
    
    private int id_forne;
    private String cnpj;
    private String razao_social;
    private String fantasia;
    private String telefone;
    private String email;
    private int id_cid;
    private Date dt_cadastro;
    private String situacao;

    /*public Fornecedor(int id_forne, String cnpj, String razao_social, String fantasia, String telefone, String email, int id_cid, Date dt_cadastro, String situacao) {
        this.id_forne = id_forne;
        this.cnpj = cnpj;
        this.razao_social = razao_social;
        this.fantasia = fantasia;
        this.telefone = telefone;
        this.email = email;
        this.id_cid = id_cid;
        this.dt_cadastro = dt_cadastro;
        this.situacao = situacao;
    }*/

    public int getId_forne() {
        return id_forne;
    }

    public void setId_forne(int id_forne) {
        this.id_forne = id_forne;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_cid() {
        return id_cid;
    }

    public void setId_cid(int id_cid) {
        this.id_cid = id_cid;
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
       
}
