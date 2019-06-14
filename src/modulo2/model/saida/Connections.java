/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.model.saida;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adroan
 */
public class Connections {
    List<Connection> connection = new ArrayList<>();

    public List<Connection> getConnection() {
        return connection;
    }

    public void setConnection(List<Connection> connection) {
        this.connection = connection;
    }
    
    public void add(Connection  connection){
        this.connection.add(connection);
    }
}
