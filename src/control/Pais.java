
package control;

/**
 *
 * @author kelvin.costa
 */
public class Pais {
    
    private int id_pais;
    private String nome;
    private String sigla;

    /*public Pais(int id_pais, String nome, String sigla) {
        this.id_pais = id_pais;
        this.nome = nome;
        this.sigla = sigla;
    }*/

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
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
    
}
