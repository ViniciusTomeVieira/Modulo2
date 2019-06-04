/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.model;

import java.util.Random;

/**
 *
 * @author Adroan
 */
public class Connection {
    String name;
    String source;
    String target;
    String flow;
    Random rs = new Random();

    public Connection() {
    }
    
    public Connection(String name, String source, String target) {
        this.name = name;
        this.source = source;
        this.target = target;
        this.flow = String.valueOf(rs.nextInt(999));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }
    
}
