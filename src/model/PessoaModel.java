/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import lib.GenericModel;
import control.Pessoa;

/**
 *
 * @author Cris
 */
public class PessoaModel extends GenericModel<Pessoa> implements interfaces.InterfaceModel<Pessoa>
{
    public PessoaModel() 
    {
        super(Pessoa.class);
    }
}
