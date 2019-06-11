/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.model.entrada;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.List;

/**
 *
 * @author Jogos
 */
@XStreamAlias(value="relation")
public class Relation {
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
    @XStreamImplicit(itemFieldName = "member")
    private List<Member> member;
    @XStreamImplicit(itemFieldName = "tag")
    private List<Tag> tag;
    
}
