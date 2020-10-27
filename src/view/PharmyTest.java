package view;

import lib.ConexaoBD;
import javax.swing.JOptionPane;

/**
 *
 * @author kelvin.costa
 */
public class PharmyTest {

    public static void main(String[] args) {
        if (ConexaoBD.getInstance() != null) {
            
            //JanelaPrincipal minhaJanela = new JanelaPrincipal();
            //minhaJanela.setVisible(true);
            
            LoginPharmy login = new LoginPharmy();
            login.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco!");
        }
    }        
}
    

