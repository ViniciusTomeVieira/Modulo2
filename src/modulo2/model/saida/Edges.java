/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.model.saida;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adroan
 */
public class Edges {
    @XStreamImplicit(itemFieldName = "edge")
    List<Edge> edge = new ArrayList<>();

    public List<Edge> getEdge() {
        return edge;
    }

    public void setEdge(List<Edge> edge) {
        this.edge = edge;
    }
    
    public void add(Edge edge){
        this.edge.add(edge);
    }
    
}
