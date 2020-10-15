
package control;

/**
 *
 * @author kelvin.costa
 */
public class Login {
    
    private int id_login;
    private int id_func;
    private String usuario;
    private String senha;
    private String email;
    private String situacao;

    /*public Login(int id_login, int id_func, String usuario, String senha, String email, String situacao) {
        this.id_login = id_login;
        this.id_func = id_func;
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.situacao = situacao;
    }*/

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
       
}
