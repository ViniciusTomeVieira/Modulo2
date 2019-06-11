/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.model.saida;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.util.Random;

/**
 *
 * @author Adroan
 */
@XStreamAlias(value = "edge")
public class Edge {
    private final int RAIO_TERRA = 6371;// raio aproximado da terra em km
    @XStreamAsAttribute
    String id;
    @XStreamAlias(value = "nd")
    @XStreamAsAttribute
    String ref;
    String idRef = id+"-"+ref;
    
    String source=id;
    String target=ref;
    Type type;
    String leght;
    String capacity;
    String maxSpeed;
    String constantA;
    String constantB;
    Random rs = new Random();

    public Edge(String id, String source, String target, Type type, String leght, String capacity, String maxSpeed, String constantA, String constantB) {
        this.id = id;
        this.source = source;
        this.target = target;
        this.type = type;
        this.leght = leght;
        this.capacity = capacity;
        this.maxSpeed = maxSpeed;
        this.constantA = constantA;
        this.constantB = constantB;
    }

    public Edge() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getLeght() {
        return leght;
    }

    public void setLeght(String leght) {
        this.leght = leght;
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
    
    private double haversine(double val){
        return Math.pow(Math.sin(val/2), 2);
    }
    public double distance(double iniLat,double iniLong, double fimLat,double fimLong){
        double dLat = Math.toRadians((fimLat-iniLat));
        double dLong = Math.toRadians((fimLong - iniLong));
        
        iniLat = Math.toRadians(iniLat);
        fimLat = Math.toRadians(fimLat);
        
        double a = haversine(dLat) + Math.cos(iniLat)*Math.cos(fimLat)*haversine(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        
        return RAIO_TERRA * c; //<--d
    }
    
    public String gerarCapacidade(){
        return String.valueOf(rs.nextInt(400));
    }
    
    public String gerarMaxSpeed(){
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

