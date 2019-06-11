/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.model.saida;

/**
 *
 * @author Adroan
 */
public class Data {
    
    private Nodes nodes;
    
    private Connection conection;
    
    private Type type;
    
    private Edge edge;

    public Nodes getNodes() {
        return nodes;
    }

    public void setNodes(Nodes nodes) {
        this.nodes = nodes;
    }

    public Connection getConection() {
        return conection;
    }

    public void setConection(Connection conection) {
        this.conection = conection;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }
    
    
    
}
