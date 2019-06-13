/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.model.saida;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;
import java.util.List;
import modulo2.model.entrada.Node;
/**
 *
 * @author Adroan
 */
public class Nodes {
    @XStreamImplicit(itemFieldName = "node")
    List<Node> node = new ArrayList<>();

    public List<Node> getNodes() {
        return node;
    }

    public void setNodes(List<Node> node) {
        this.node = node;
    }
    public void addNodes(Node node){
        this.node.add(node);
    }
    
}
