
package control;

/**
 *
 * @author kelvin.costa
 */
public class Estado {
    
    private int id_est;
    private String nome;
    private String sigla;
    private int id_pais;

    /*public Estado(int id_est, String nome, String sigla, int id_pais) {
        this.id_est = id_est;
        this.nome = nome;
        this.sigla = sigla;
        this.id_pais = id_pais;
    }*/

    public int getId_est() {
        return id_est;
    }

    public void setId_est(int id_est) {
        this.id_est = id_est;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }
    
}
