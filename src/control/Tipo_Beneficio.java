
package control;

/**
 *
 * @author kelvin.costa
 */
public class Tipo_Beneficio {
    
    private int id_tpbeneficio;
    private String nome;
    private String obs;

    /*public Tipo_Beneficio(int id_tpbeneficio, String nome, String obs) {
        this.id_tpbeneficio = id_tpbeneficio;
        this.nome = nome;
        this.obs = obs;
    }*/

    public int getId_tpbeneficio() {
        return id_tpbeneficio;
    }

    public void setId_tpbeneficio(int id_tpbeneficio) {
        this.id_tpbeneficio = id_tpbeneficio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
}
