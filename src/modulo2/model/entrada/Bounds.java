package modulo2.model.entrada;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author F�bio
 */
@XStreamAlias(value = "bounds")
public class Bounds {
    
    @XStreamAsAttribute
    private String maxlon;
        
    @XStreamAsAttribute
    private String maxlat;
    
    @XStreamAsAttribute
    private String minlon;
    
    @XStreamAsAttribute
    private String minlat;
  
    
    
    public String getMinlat() {
        return minlat;
    }

    public void setMinlat(String minlat) {
        this.minlat = minlat;
    }

    public String getMinlon() {
        return minlon;
    }

    public void setMinlon(String minlon) {
        this.minlon = minlon;
    }

    public String getMaxlat() {
        return maxlat;
    }

    public void setMaxlat(String maxlat) {
        this.maxlat = maxlat;
    }

    public String getMaxlon() {
        return maxlon;
    }

    public void setMaxlon(String maxlon) {
        this.maxlon = maxlon;
    }

//    @Override
//    public String toString() {
//        return "Bounds{" + "maxlon=" + maxlon + ", maxlat=" + maxlat + ", minlon=" + minlon + ", minlat=" + minlat + '}';
//    }
    
    
    
}
