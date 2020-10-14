/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Cristiano Peiter <cristiano.peiter@universo.univates.br>
 * @param <T>
 */
public class GenericForm<T extends Entity> extends javax.swing.JDialog {

    private final Class<T> entityClass;

    public GenericForm(Class<T> e, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        entityClass = e;
    }

    public static boolean validarCampoVazio(JFormattedTextField campo) {
        Validation validation = new Validation();
        return Validation.validarCampoComConteudo(campo);
    }

    public static boolean validarCampoVazio(JTextField campo) {
        Validation validation = new Validation();
        return Validation.validarCampoComConteudo(campo);
    }

    public static boolean validarCampoVazio(JTextArea campo) {
        Validation validation = new Validation();
        return Validation.validarCampoComConteudo(campo);
    }
    
    public static boolean validarCampoVazio(JComboBox campo) {
        Validation validation = new Validation();
        return Validation.validarCampoComConteudo(campo);
    }
    
    public static boolean validarCampoVazio(JCheckBox campo) {
        Validation validation = new Validation();
        return Validation.validarCampoComConteudo(campo);
    }
    

    public void sair() {
        this.dispose();
    }

    public boolean eCampoObrigatorio(JFormattedTextField field, ArrayList<String> camposObrigatorios) {
        //verifica se campo é obrigatorio   
        boolean fl_obrigatorio = false;
        
        if(field.getName() != null)
        {
            for (int j = 0; j < camposObrigatorios.size(); j++) {
                if (field.getName().equals(camposObrigatorios.get(j))) {
                    fl_obrigatorio = true;
                    break;
                }
            }
        }
        return fl_obrigatorio;
    }

    public boolean eCampoObrigatorio(JTextField field, ArrayList<String> camposObrigatorios) {
        //verifica se campo é obrigatorio   
        boolean fl_obrigatorio = false;
        
        if(field.getName() != null)
        {
            for (int j = 0; j < camposObrigatorios.size(); j++) {
                if (field.getName().equals(camposObrigatorios.get(j))) {
                    fl_obrigatorio = true;
                    break;
                }
            }
        }
        return fl_obrigatorio;
    }

    public boolean eCampoObrigatorio(JTextArea field, ArrayList<String> camposObrigatorios) {
        //verifica se campo é obrigatorio   
        boolean fl_obrigatorio = false;
        
        if(field.getName() != null)
        {
            for (int j = 0; j < camposObrigatorios.size(); j++) {
                if (field.getName().equals(camposObrigatorios.get(j))) {
                    fl_obrigatorio = true;
                    break;
                }
            }
        }
        return fl_obrigatorio;
    }
    
    public boolean eCampoObrigatorio(JComboBox field, ArrayList<String> camposObrigatorios) {
        //verifica se campo é obrigatorio   
        boolean fl_obrigatorio = false;
        
        if(field.getName() != null)
        {
            for (int j = 0; j < camposObrigatorios.size(); j++) {
                if (field.getName().equals(camposObrigatorios.get(j))) {
                    fl_obrigatorio = true;
                    break;
                }
            }
        }
        return fl_obrigatorio;
    }
    
    public boolean eCampoObrigatorio(JCheckBox field, ArrayList<String> camposObrigatorios) {
        //verifica se campo é obrigatorio   
        boolean fl_obrigatorio = false;
        
        if(field.getName() != null)
        {
            for (int j = 0; j < camposObrigatorios.size(); j++) {
                if (field.getName().equals(camposObrigatorios.get(j))) {
                    fl_obrigatorio = true;
                    break;
                }
            }
        }
        return fl_obrigatorio;
    }

    public boolean validarCampos(ArrayList<String> camposObrigatorios, Container container) {
        boolean fl_valida = true;

        Component c[] = container.getComponents();

        //todos os campos do container
        for (Component componente : c) {
            //verificar campos
            if (componente instanceof JFormattedTextField) {
                JFormattedTextField field = (JFormattedTextField) componente;
                //verifica se é um campo obrigatorio e se está preenchido
                if (eCampoObrigatorio(field, camposObrigatorios)) {
                    if (!validarCampoVazio(field)) {
                        fl_valida = false;
                        break;
                    }
                }
            } else if (componente instanceof JTextField) {
                JTextField field = (JTextField) componente;

                //verifica se é um campo obrigatorio e se está preenchido
                if (field.getName() != null) {
                    if (eCampoObrigatorio(field, camposObrigatorios)) {
                        if (!validarCampoVazio(field)) {
                            fl_valida = false;
                            break;
                        }
                    }
                }
            } else if (componente instanceof JScrollPane) {
                JTextArea field = (JTextArea) ((JScrollPane) componente).getViewport().getComponent(0);

                //verifica se é um campo obrigatorio e se está preenchido
                if (field.getName() != null) {
                    if (eCampoObrigatorio(field, camposObrigatorios)) {
                        if (!validarCampoVazio(field)) {
                            fl_valida = false;
                            break;
                        }
                    }
                }
            } else if (componente instanceof JComboBox) {
                JComboBox cb = (JComboBox) componente;
                
                //verifica se é um campo obrigatorio e se está preenchido
                if (cb.getName() != null) {                    
                    if (eCampoObrigatorio(cb, camposObrigatorios)) {
                        if (!validarCampoVazio(cb)) {
                            fl_valida = false;
                            break;
                        }
                    }
                }
            } else if (componente instanceof JCheckBox) {
                JCheckBox ckb = (JCheckBox) componente;
                
                //verifica se é um campo obrigatorio e se está preenchido
                if (ckb.getName() != null) {                    
                    if (eCampoObrigatorio(ckb, camposObrigatorios)) {
                        if (!validarCampoVazio(ckb)) {
                            fl_valida = false;
                            break;
                        }
                    }
                }
            }
        }

        return fl_valida;
    }
}
