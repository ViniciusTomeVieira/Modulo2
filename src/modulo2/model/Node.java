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
    private int id;
    private double x;
    private double y;
    private ImageIcon imagem;

    public int getId() {
        return id;
    }

    public Node(double x, double y, ImageIcon imagem) {
        this.x = x;
        this.y = y;
        this.imagem = imagem;
    }

    public ImageIcon getImagem() {
        return imagem;
    }

    public void setImagem(ImageIcon imagem) {
        this.imagem = imagem;
    }
    
    

    public void setId(int id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    
}
