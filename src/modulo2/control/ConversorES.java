/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.control;

import java.util.ArrayList;
import java.util.List;
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
    private double xMax;
    private double yMax;
    private double xMin;
    private double yMin;
    private String speed="";
    private String oneWay="";
    private String numLanes="";
    private String type="";
    private String capacidade="";
    private String constA="";
    private String constB="";
    private Osm osm;
    private Data data;
    private List<Data> dados= new ArrayList<>();
            
    private Random rs =new Random();

    public Data converterES(Osm osm, Data data) {
        speed = gerarMaxSpeed();
        oneWay = gerarOneway();
        numLanes =gerarNumLanes();
        type =gerarType();
        capacidade =gerarCapacidade();
        constA =geradordeConstanteA();
        constB =geradordeConstanteB();
        xMax = Double.parseDouble(osm.getBounds().getMaxlon());
        yMax =Double.parseDouble(osm.getBounds().getMaxlat());
        xMin = Double.parseDouble(osm.getBounds().getMinlon());
        yMin =Double.parseDouble(osm.getBounds().getMinlat());
        dados.add(data);
        this.osm=osm;
        for(Data dados: dados){
            dados.setxMax(xMax<0? xMax*-1:xMax);
            dados.setyMax(yMax<0? yMax*-1:yMax);
            dados.setxMin(xMin<0? xMin*-1: xMin);
            dados.setyMin(yMin<0? yMin*-1: yMin);
        for (Node node : this.osm.getNode()) {
            dados.getNodes().addNode(new modulo2.model.saida.Node(node.getId(), Double.parseDouble(node.getLat()), Double.parseDouble(node.getLon())));
        }
        for (Way way : this.osm.getWay()) {
            for (Nd nd : way.getNd()) {
                for (Node node : this.osm.getNode()) {
                    if (way.getId().equals(node.getId())) {
                        
                        iniLat = Double.parseDouble(node.getLat());
                        iniLon = Double.parseDouble(node.getLon());
                    }
                    if (nd.getRef().equals(node.getId())) {
                        FimLat = Double.parseDouble(node.getLat());
                        FimLon = Double.parseDouble(node.getLon());
                    }
                }
                dados.getEdges().add(new Edge(way.getId(), way.getId(), nd.getRef(), speed, oneWay, numLanes, type, capacidade, constA,constB, iniLat, iniLon, FimLat, FimLon));
            }
        }
        for (Way way : this.osm.getWay()) {
            dados.getTypes().add(new Type(way.getId(), speed, oneWay, numLanes, capacidade));
        }

        for (Node node : this.osm.getNode()) {
            for (Node node2 : this.osm.getNode()) {
                dados.getConnections().add(new Connection(node.getId(),node2.getId()));
            }
        }
        this.data=dados;
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
