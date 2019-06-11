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
    
    
    private Bounds bounds;
    
    @XStreamImplicit(itemFieldName = "node")
    private List<Node> node ;
    
    private Way way;
    
    

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

    public Way getWay() {
        return way;
    }

    public void setWay(Way way) {
        this.way = way;
    }
    
    
    
}
