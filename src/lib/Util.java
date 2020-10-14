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
public class Util {
    
    public static boolean isNumero( char key )
    {
        if( key == '0' || key == '1' || key == '2' || key == '3' || key == '4' ||
            key == '5' || key == '6' || key == '7' || key == '8' || key == '.' || key == '9' )
        {
            return true;
        }
        return false;
    }    
}
