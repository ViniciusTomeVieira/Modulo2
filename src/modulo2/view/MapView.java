/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Jogos
 */
public class MapView extends JPanel {
    
    private ImageIcon mapa;
    private ImageObserver obs;

    public MapView(ImageIcon mapa, ImageObserver observer) {
        this.mapa = mapa;
        this.obs = observer;
    }
        
    @Override
    public void paint(Graphics g) {
        g.drawImage(mapa.getImage(), 0,0, obs);
        System.out.println("Eu existo");
        System.out.println("Valor do mapa: " + mapa.toString());
    }
    
    public void atualizarMapa(ImageIcon mapa){
        this.mapa = mapa;
        repaint();
    }
    
    
    
}
