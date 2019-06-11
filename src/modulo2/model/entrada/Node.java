
package modulo2.model.entrada;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author F�bio
 */
@XStreamAlias(value="node")
public class Node {
    
    @XStreamAsAttribute
    private String version;
    
    @XStreamAsAttribute
    private String lon;
    
    @XStreamAsAttribute
    private String lat;
    
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

    
    
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
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
    
    
}
