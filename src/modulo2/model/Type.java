/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.model;

/**
 *
 * @author Adroan
 */
public class Type {
    String type;
    String numLanes;
    String speed;

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
    
    
}
