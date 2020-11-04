
package control;

/**
 *
 * @author kelvin.costa
 */

public class Banco {
    
    private int id_banco;
    private String nome;

    /*public Banco(int id_banco, String nome) {
        this.id_banco = id_banco;
        this.nome = nome;
    }*/

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
