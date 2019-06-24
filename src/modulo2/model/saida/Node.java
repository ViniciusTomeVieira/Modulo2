/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.model.saida;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Adroan
 */
@XStreamAlias(value = "node")
public class Node {
    private String id;
    private double latitude;
    private double longitude;
    private int x;
    private int y;
    private ImageIcon imagem;

    public Node(String id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imagem =new ImageIcon("res/PONTO.png");
        Image imagemReajustada = imagem.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        imagem.setImage(imagemReajustada);
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
