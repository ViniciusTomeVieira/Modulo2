package modulo2.model.entrada;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author F�bio
 */
@XStreamAlias(value = "nd")
public class Nd {
    
    @XStreamAsAttribute
    private String ref;
    
    

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
    
    
    
    
    
}
