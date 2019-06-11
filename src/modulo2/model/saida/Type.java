/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.model.saida;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Random;

/**
 *
 * @author Adroan
 */
@XStreamAlias(value = "type")
public class Type {

    Random rs = new Random();
    private String id;
    private String speed;
    private String oneway;
    private String numLanes;
    private String capacity;

    public Type(String id, String speed, String oneway, String numLanes, String capacity) {
        this.id = id;

        if (speed == null) {
            this.speed = gerarSpeed();
        } else {
            this.speed = speed;
        }

        if (oneway == null) {
            if (rs.nextInt(1) == 0) {
                this.oneway = "true";
            } else {
                this.oneway = "false";
            }
        } else {
            this.oneway = oneway;
        }

        if (numLanes == null) {
            this.numLanes = gerarNumLanes();
        } else {
            this.numLanes = numLanes;
        }

        if (capacity == null) {
            this.capacity = String.valueOf(rs.nextInt(10000));
        } else {
            this.capacity = capacity;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        if (speed == null) {
            this.speed = gerarSpeed();
        } else {
            this.speed = speed;
        }
    }

    public String getOneway() {
        return oneway;
    }

    public void setOneway(String oneway) {
        if (oneway == null) {
            if (rs.nextInt(1) == 0) {
                this.oneway = "true";
            } else {
                this.oneway = "false";
            }
        } else {
            this.oneway = oneway;
        }
    }

    public String getNumLanes() {
        return numLanes;
    }

    public void setNumLanes(String numLanes) {
        if (numLanes == null) {
            this.numLanes = gerarNumLanes();
        } else {
            this.numLanes = numLanes;
        }
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        if (capacity == null) {
            this.capacity = String.valueOf(rs.nextInt(10000));
        } else {
            this.capacity = capacity;
        }
    }

    public String gerarNumLanes() {
        return String.valueOf(rs.nextInt(8));
    }

    public String gerarSpeed() {
        int vel = rs.nextInt(10);
        String velFim;
        switch (vel) {
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
