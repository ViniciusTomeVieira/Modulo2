/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.model.saida;

import modulo2.model.entrada.Osm;

/**
 *
 * @author Adroan
 */
public class Data {
        private static Data instance;
    
    private Data(){}
    
    public static synchronized Data getInstance(){
        if(instance==null){
            instance = new Data();
        }
        return instance;
    }
    private Osm osm;
    
    private Nodes nodes;
    
    private Double xMax;
    private Double xMin;
    private Double yMax;
    private Double yMin;
    
    private Connections connections;
    
    private Types types;
    
    private Edges edges;

    public Nodes getNodes() {
        return nodes;
    }

    public void setNodes(Nodes nodes) {
        this.nodes = nodes;
    }

    public Connections getConnections() {
        return connections;
    }

    public void setConnections(Connections connections) {
        this.connections = connections;
    }

    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    public Edges getEdges() {
        return edges;
    }

    public void setEdges(Edges edges) {
        this.edges = edges;
    }

    public Double getxMax() {
        return xMax;
    }

    public void setxMax(Double xMax) {
        this.xMax = xMax;
    }

    public Double getxMin() {
        return xMin;
    }

    public void setxMin(Double xMin) {
        this.xMin = xMin;
    }

    public Double getyMax() {
        return yMax;
    }

    public void setyMax(Double yMax) {
        this.yMax = yMax;
    }

    public Double getyMin() {
        return yMin;
    }

    public void setyMin(Double yMin) {
        this.yMin = yMin;
    }
    
}
