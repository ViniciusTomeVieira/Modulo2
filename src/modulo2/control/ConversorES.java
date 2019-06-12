/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.control;

import modulo2.model.entrada.*;
import modulo2.model.entrada.Osm;
import modulo2.model.saida.Data;
import modulo2.model.saida.Edge;

/**
 *
 * @author Jogos
 */
public class ConversorES {
    public Data converterES(Osm osm, Data data){
        for(Node node:osm.getNode()){
            data.getNodes().addNode(new modulo2.model.saida.Node(node.getId(), Double.parseDouble(node.getLat()), Double.parseDouble(node.getLon())));
        }
        for(Way way :osm.getWay()){
            Edge edge = new Edge(way.getId(), way.getId(),null, null, null, null, "2", null, null, null, null);
                    for(Nd nd:way.getNd()){
                        edge.addTarget(nd.getRef());
                    }
                    for(Tag tag:way.getTag()){
                        if(tag.getV().equals("yes")&&tag.getK().equals("oneway"))
                            edge.setOneway("true");
                    }
            data.getEdges().add(edge);
        }
        return data;
    }
}
