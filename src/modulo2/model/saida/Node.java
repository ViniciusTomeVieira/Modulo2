/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.model.saida;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import javax.swing.ImageIcon;

/**
 *
 * @author Adroan
 */
@XStreamAlias(value = "node")
public class Node {
    @XStreamAlias(value = "node")
    @XStreamAsAttribute
    private String id;
    @XStreamAlias(value = "node")
    @XStreamAsAttribute
    private double latitude;
    private double longitude;
    
    private ImageIcon imagem;

    public Node(String name, double latitude, double longitude) {
        this.id = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imagem =new ImageIcon("res/PONTO.png");;
    }


    public Node() {
    }

    public ImageIcon getImagem() {
        return imagem;
    }

    public void setImagem(ImageIcon imagem) {
        this.imagem = imagem;
    }
    
    

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
