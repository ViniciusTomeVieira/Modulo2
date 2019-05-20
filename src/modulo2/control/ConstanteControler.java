/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.control;

import java.util.Random;

/**
 *
 * @author Adroan
 */
public class ConstanteControler {
    private final Random rd = new Random();
    public double geradordeConstanteA(){
        double cons = rd.nextDouble();
        return cons;
    }
    public double geradorConstanteB(){
        double cons = rd.nextDouble()*1000;
        return cons;
    }
}
