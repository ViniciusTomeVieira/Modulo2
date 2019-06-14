/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.control;

import java.util.Random;
import modulo2.model.entrada.*;
import modulo2.model.entrada.Osm;
import modulo2.model.saida.Connection;
import modulo2.model.saida.Data;
import modulo2.model.saida.Edge;
import modulo2.model.saida.Type;

/**
 *
 * @author Jogos
 */
public class ConversorES {

    private double iniLat;
    private double iniLon;
    private double FimLat;
    private double FimLon;
    private String speed="";
    private String oneWay="";
    private String numLanes="";
    private String type="";
    private String capacidade="";
    private String constA="";
    private String constB="";
            
            
    private Random rs =new Random();

    public Data converterES(Osm osm, Data data) {
        speed = gerarMaxSpeed();
        oneWay = gerarOneway();
        numLanes =gerarNumLanes();
        type =gerarType();
        capacidade =gerarCapacidade();
        constA =geradordeConstanteA();
        constB =geradordeConstanteB();

        for (Node node : osm.getNode()) {
            data.getNodes().addNode(new modulo2.model.saida.Node(node.getId(), Double.parseDouble(node.getLat()), Double.parseDouble(node.getLon())));
        }
        for (Way way : osm.getWay()) {
            for (Nd nd : way.getNd()) {
                for (modulo2.model.saida.Node node : data.getNodes().getNode()) {
                    if (way.getId().equals(node.getId())) {
                        iniLat = node.getLatitude();
                        iniLon = node.getLongitude();
                    }
                    if (nd.getRef().equals(node.getId())) {
                        FimLat = node.getLatitude();
                        FimLon = node.getLongitude();
                    }
                }
                data.getEdges().add(new Edge(way.getId(), way.getId(), nd.getRef(), speed, oneWay, numLanes, type, capacidade, constA,constB, iniLat, iniLon, FimLat, FimLon));
            }
        }
        for (Edge edge:data.getEdges().getEdge()) {
            data.getTypes().add(new Type(speed, speed, oneWay, numLanes, capacidade));
        }

        for (modulo2.model.saida.Node node : data.getNodes().getNode()) {
            for (modulo2.model.saida.Node node2 : data.getNodes().getNode()) {
                data.getConnections().add(new Connection(node.getId(),node2.getId()));
            }
        }
        return data;
    }
        public String gerarCapacidade() {
        return String.valueOf(rs.nextInt(400));
    }

    private String gerarMaxSpeed() {
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

    private String geradordeConstanteA() {
        return String.valueOf(rs.doubles());
    }

    private String geradordeConstanteB() {
        return String.valueOf(rs.doubles());
    }

    private String gerarNumLanes() {
        return String.valueOf(rs.nextInt(8));
    }
    
    private String gerarType(){
        return String.valueOf(rs.nextInt(10)+1);
    }
    
    private String gerarOneway(){
        if(rs.nextInt(20)==0){
            return "true";
        }
        return"false";
                
    }
}
