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
public class Order {

    private String value;
    private String order;

    public Order(String value, String order) {
        this.value = value;
        this.order = order;
    }

    public Order(String value) {
        this.value = value;
        this.order = "ASC";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getStatement() {
        return " ORDER BY " + value + " " + order;
    }

}
