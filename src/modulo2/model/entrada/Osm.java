package modulo2.model.entrada;

import modulo2.model.entrada.Node;
import modulo2.model.entrada.Bounds;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.List;

/**
 *
 * @author F�bio
 */
@XStreamAlias(value = "osm")
public class Osm {    
    
    private static Osm instance;
    
    private Osm(){
        
    }
    
    public static synchronized Osm getInstance(){
        if(instance==null){
            instance = new Osm();
        }
        return instance;
    }
    
    private Bounds bounds;
    
    @XStreamImplicit(itemFieldName = "node")
    private List<Node> node ;
    
    @XStreamImplicit(itemFieldName = "way")
    private List<Way> way;
    @XStreamImplicit(itemFieldName = "way")
    private List<Relation> relation;
    

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public List<Node> getNode() {
        return node;
    }

    public void setNode(List<Node> node) {
        this.node = node;
    }

    public List<Way> getWay() {
        return way;
    }

    public void setWay(List<Way> way) {
        this.way = way;
    }


    
    
}
