/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.model.entrada;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Jogos
 */
@XStreamAlias(value="member")
public class Member {
    @XStreamAsAttribute
    private String role;
    @XStreamAsAttribute
    private String ref;
    @XStreamAsAttribute
    private String type;
}
