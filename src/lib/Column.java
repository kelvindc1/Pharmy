/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

/**
 *
 * @author Cristiano Peiter <cristiano.peiter@universo.univates.br>
 */
public class Column {

    private String name_bd;
    private String name;
    private int size;
    private boolean image;
    private boolean transformes;
    private String coluna_transformes;
    private String tabela_transformes;

    public Column(String name_bd, String name) {
        this.name_bd = name_bd;
        this.name = name;
        this.size = 50;
        this.image = false;
        this.transformes = false;
        this.coluna_transformes = "";
        this.tabela_transformes = "";
    }
    
    public Column(String name_bd, String name, boolean transformes, String coluna_transformes, String tabela_transformes) {
        this.name_bd = name_bd;
        this.name = name;
        this.size = 50;
        this.image = false;
        this.transformes = transformes;
        this.coluna_transformes = coluna_transformes;
        this.tabela_transformes = tabela_transformes;
    }

    public Column(String name_bd, String name, int size) {
        this.name_bd = name_bd;
        this.name = name;
        this.size = size;
        this.image = false;
        this.transformes = false;
        this.coluna_transformes = "";
        this.tabela_transformes = "";
    }
    
    public Column(String name_bd, String name, int size, boolean transformes, String coluna_transformes, String tabela_transformes) {
        this.name_bd = name_bd;
        this.name = name;
        this.size = size;
        this.image = false;
        this.transformes = transformes;
        this.coluna_transformes = coluna_transformes;
        this.tabela_transformes = tabela_transformes;
    }

    public Column(String name_bd, String name, int size, boolean image) {
        this.name_bd = name_bd;
        this.name = name;
        this.size = size;
        this.image = image;
        this.transformes = false;
        this.coluna_transformes = "";
        this.tabela_transformes = "";
    }

     public String getName_bd() {
        return name_bd;
    }

    public void setName_bd(String name_bd) {
        this.name_bd = name_bd;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isImage() {
        return image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }

    public boolean isTransformes() {
        return transformes;
    }

    public void setTransformes(boolean transformes) {
        this.transformes = transformes;
    }

    public String getTabela_Transformes() {
        return tabela_transformes;
    }

    public void setTabela_Transformes(String tabela_transformes) {
        this.tabela_transformes = tabela_transformes;
    }    

    public String getColuna_transformes() {
        return coluna_transformes;
    }

    public void setColuna_transformes(String coluna_transformes) {
        this.coluna_transformes = coluna_transformes;
    }

    public String getTabela_transformes() {
        return tabela_transformes;
    }

    public void setTabela_transformes(String tabela_transformes) {
        this.tabela_transformes = tabela_transformes;
    }
}
