/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.model;

import javax.swing.ImageIcon;

/**
 *
 * @author Adroan
 */
public class Node {
    private String name;
    private double latitude;
    private double longitude;
    private ImageIcon imagem;

    public Node(String name, double latitude, double longitude, ImageIcon imagem) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imagem = imagem;
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
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
