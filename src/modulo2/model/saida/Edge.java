/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.model.saida;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Adroan
 */
@XStreamAlias(value = "edge")
public class Edge {

    private final int RAIO_TERRA = 6371;// raio aproximado da terra em km
    private String id;
    private String ref;
    private String name;
    private String source;
    private String speed;
    private String oneway;
    private String numLanes;
    private String type;
    private String target;
    private String lenght;
    private String capacity;
    private String maxSpeed;
    private String constantA;
    private String constantB;
    private double iniLat;
    private double iniLon;
    private double FimLat;
    private double FimLon;
    Random rs = new Random();

    public Edge(String id, String source,String target, String speed, String oneway, String numLanes, String type, String capacity, String constantA, String constantB,double iniLat,double iniLon, double FimLat, double FimLon) {
        this.id = id;
        this.name = source + target;
        this.source = source;
        if (speed == null) {
            this.speed = speed;
        } else {
            this.speed = speed;
        }

        if (oneway == null) {
            if (rs.nextInt(20) != 0) {
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
        if (type == null) {
            this.type = String.valueOf(rs.nextInt(2));
        } else {
            this.type = type;
        }
        this.type = type;
        this.lenght = String.valueOf(distance(iniLat, iniLon, FimLat, FimLon));//fazer o calculo da distancia
        if (capacity == null) {
            this.capacity = gerarCapacidade();
        } else {
            this.capacity = type;
        }
        this.constantA = String.valueOf(geradordeConstanteA());
        this.constantB = String.valueOf(geradordeConstanteB());
    }

    public Edge() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getOneway() {
        return oneway;
    }

    public void setOneway(String oneway) {
        this.oneway = oneway;
    }

    public String getNumLanes() {
        return numLanes;
    }

    public void setNumLanes(String numLanes) {
        this.numLanes = numLanes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getLenght() {
        return lenght;
    }

    public void setLenght(String lenght) {
        this.lenght = lenght;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getConstantA() {
        return constantA;
    }

    public void setConstantA(String constantA) {
        this.constantA = constantA;
    }

    public String getConstantB() {
        return constantB;
    }

    public void setConstantB(String constantB) {
        this.constantB = constantB;
    }

    

    private double haversine(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }
    
    private double distance(double iniLat, double iniLong, double fimLat, double fimLong) {
        double dLat = Math.toRadians((fimLat - iniLat));
        double dLong = Math.toRadians((fimLong - iniLong));

        iniLat = Math.toRadians(iniLat);
        fimLat = Math.toRadians(fimLat);

        double a = haversine(dLat) + Math.cos(iniLat) * Math.cos(fimLat) * haversine(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RAIO_TERRA * c; //<--d
    }

    public String gerarCapacidade() {
        return String.valueOf(rs.nextInt(400));
    }

    public String gerarMaxSpeed() {
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

    public double geradordeConstanteA() {
        double cons = rs.nextDouble();
        return cons;
    }

    public double geradordeConstanteB() {
        double cons = rs.nextDouble() * 10;
        return cons;
    }

    public String gerarNumLanes() {
        return String.valueOf(rs.nextInt(8));
    }
    
    public String gerarType(){
        return String.valueOf(rs.nextInt(10)+1);
    }
    
    
}
