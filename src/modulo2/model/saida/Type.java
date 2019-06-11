/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.model.saida;

import java.util.Random;

/**
 *
 * @author Adroan
 */
public class Type {
    String type;
    String numLanes;
    String speed;
    Random rs = new Random();

    public Type(String type, String numLanes, String speed) {
        this.type = type;
        this.numLanes = numLanes;
        this.speed = speed;
    }

    public Type() {
    }
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumLanes() {
        return numLanes;
    }

    public void setNumLanes(String numLanes) {
        this.numLanes = numLanes;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
    
    public String gerarNumLanes(){
        return String.valueOf(rs.nextInt(8));
    }
    
    public String gerarSpeed(){
        int vel = rs.nextInt(10);
        String velFim;
        switch(vel){
            case 0:
                velFim = "30";
                break;
            case 1:
                velFim = "40";
                break;
            case 2:
                velFim = "50";
                break;
            case 3:
                velFim = "60";
                break;
            case 4:
                velFim = "70";
                break;
            case 5:
                velFim = "80";
                break;
            case 6:
                velFim = "90";
                break;
            case 7:
                velFim = "100";
                break;
            case 8:
                velFim = "110";
                break;
            case 9:
                velFim = "120";
                break;
            default:
                velFim = "999";
                break;
        }
        return velFim;
    }
    
    
}
