package modulo2.model.entrada;

import modulo2.model.entrada.Tag;
import modulo2.model.entrada.Nd;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.List;

/**
 *
 * @author F�bio
 */
@XStreamAlias(value = "way")
public class Way {
    
    @XStreamAsAttribute
    private String version;
    
    @XStreamAsAttribute
    private String uid;
    
    @XStreamAsAttribute
    private String user;
    
    @XStreamAsAttribute
    private String timestamp;
    
    @XStreamAsAttribute
    private String changeset;
    
    @XStreamAsAttribute
    private String visible;
    
    @XStreamAsAttribute
    private String id;
    
    @XStreamImplicit(itemFieldName = "nd")
    private List<Nd> nd;
    
    @XStreamImplicit(itemFieldName = "tag")
    private List<Tag> tag;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getChangeset() {
        return changeset;
    }

    public void setChangeset(String changeset) {
        this.changeset = changeset;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Nd> getNd() {
        return nd;
    }

    public void setNd(List<Nd> nd) {
        this.nd = nd;
    }

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    
    
    
    
}
