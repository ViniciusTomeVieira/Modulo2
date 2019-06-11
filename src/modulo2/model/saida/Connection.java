/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.model.saida;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.util.Random;

/**
 *
 * @author Adroan
 */
@XStreamAlias(value = "od")
public class Connection {
    @XStreamAlias(value = "way")
    @XStreamAsAttribute
    String id;
    @XStreamAlias(value = "nd")
    @XStreamAsAttribute
    String ref;
    
    
    String source = id;
    String target = ref;
    String idRef;
    String flow;
    Random rs = new Random();

    public Connection() {
    }
    
    public Connection(String name, String source, String target) {
        this.idRef = id+"-"+ref;
        this.source = source;
        this.target = target;
        this.flow = gerarFlow();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    public String gerarFlow(){
        return String.valueOf(rs.nextInt(1000));
    }
}
