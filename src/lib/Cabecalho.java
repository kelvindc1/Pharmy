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
public class Cabecalho {
    
    private Column[] columns;

    public Cabecalho(Column... columns) {
        this.columns = columns;
    }

    public Column[] getColumns() {
        return columns;
    }

    public void setColumn(Column[] columns) {
        this.columns = columns;
    }
}
