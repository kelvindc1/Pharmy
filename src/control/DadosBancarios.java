
package control;

/**
 *
 * @author kelvin.costa
 */
public class DadosBancarios {
    
    private int id_dados;
    private int conta;
    private int agencia;
    private int id_banco;

    /*public DadosBancarios(int id_dados, int conta, int agencia, int id_banco) {
        this.id_dados = id_dados;
        this.conta = conta;
        this.agencia = agencia;
        this.id_banco = id_banco;
    }*/

    public int getId_dados() {
        return id_dados;
    }

    public void setId_dados(int id_dados) {
        this.id_dados = id_dados;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }
        
}
