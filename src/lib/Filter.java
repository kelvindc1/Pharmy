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
public class Filter {

    private Operator operator;
    private String property;
    private Object value;
    private Object value2;

    public Filter(Operator operator, String property, Object value) {
        this.operator = operator;
        this.property = property;
        this.value = value;
    }

    public Filter(Operator operator, String property, Object value, Object value2) {
        this.operator = operator;
        this.property = property;
        this.value = value;
        this.value2 = value2;
    }

    public Operator getOperator() {
        return operator;
    }

    public String getProperty() {
        return property;
    }

    public Object getValue() {
        return value;
    }

    public Object getValue2() {
        return value2;
    }

    private String formatOperator() {
        if (operator == Operator.EQ) {
            return "=";
        }
        if (operator == Operator.GE) {
            return ">=";
        }
        if (operator == Operator.GT) {
            return ">";
        }
        if (operator == Operator.ILIKE) {
            return "ILIKE";
        }
        if (operator == Operator.LIKE) {
            return "LIKE";
        }
        if (operator == Operator.LE) {
            return "<=";
        }
        if (operator == Operator.LT) {
            return "<";
        }
        if (operator == Operator.NEQ) {
            return "<>";
        }
        if (operator == Operator.BET) {
            return "BETWEEN";
        }
        throw new RuntimeException("Operador inválido");
    }

    public String getStatement() {
        if (operator == Operator.BET) {
            return property + " " + formatOperator() + " ? AND ?";
        } else {
            return property + " " + formatOperator() + " ? ";
        }
    }

}
