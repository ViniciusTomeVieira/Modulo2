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
public class Connections {
    @XStreamImplicit(itemFieldName = "connections")
    List<Connection> conection = new ArrayList<>();
    
    public List<Connection> getConnection() {
        return conection;
    }

    public void setConection(List<Connection> conection) {
        this.conection = conection;
    }
    
    public void add(Connection od){
        this.conection.add(od);
        
    }
}
