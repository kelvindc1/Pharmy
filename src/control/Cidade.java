
package control;

/**
 *
 * @author kelvin.costa
 */
public class Cidade {
    
    private int id_cid;
    private String nome;
    private int id_est;

    /*public Cidade(int id_cid, String nome, int id_est) {
        this.id_cid = id_cid;
        this.nome = nome;
        this.id_est = id_est;
    }*/

    public int getId_cid() {
        return id_cid;
    }

    public void setId_cid(int id_cid) {
        this.id_cid = id_cid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_est() {
        return id_est;
    }

    public void setId_est(int id_est) {
        this.id_est = id_est;
    }
       
}
