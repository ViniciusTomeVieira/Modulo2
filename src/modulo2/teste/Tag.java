package modulo2.teste;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author F�bio
 */
@XStreamAlias(value = "tag")
public class Tag {
    
    @XStreamAsAttribute
    private String v;
    
    @XStreamAsAttribute
    private String k;
    
    

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }
    
    
    
}
