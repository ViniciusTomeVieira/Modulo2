/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import modulo2.model.Node;

/**
 *
 * @author Jogos
 */
public class MapView extends JPanel {
    
    private ImageIcon mapa;
    private ImageIcon background = new ImageIcon("res/background.jpg");
    private ImageObserver obs;
    private List<Image> imagens = new ArrayList<>();
    private List<String> index = new ArrayList<>();
    private List<Node> pontos = new ArrayList<>();
    private int x;
    private int y;

    public MapView(ImageIcon mapa, ImageObserver observer) {
        this.mapa = mapa;
        this.obs = observer;
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(background.getImage(), 0, 0, obs);
        g2.drawImage(mapa.getImage(), 0,0, obs);
        
        if(pontos.size() > 0){
            for(Node nodo: pontos){  
                x= (int)nodo.getX() * -1;
                y= (int)nodo.getY() * -1;
                g2.drawImage(nodo.getImagem().getImage(), x,y, obs);
                System.out.println("X: " + x);
                System.out.println("Y: " + y);
            }
        }
    }
    
    public void atualizarMapa(ImageIcon mapa){
        this.mapa = mapa;
        Image imagemReajustada = this.mapa.getImage().getScaledInstance(1000, 720, Image.SCALE_DEFAULT);
        this.mapa.setImage(imagemReajustada);
        index.add("+1");
        imagens.add(mapa.getImage());
        repaint();
    }
    
    public void zoomImage(){
        BufferedImage buf = new BufferedImage(mapa.getImage().getWidth(obs)+100,mapa.getImage().getHeight(obs)+100, BufferedImage.TYPE_INT_RGB);
        if(index.size() < 5){
            Graphics2D grf = buf.createGraphics();
            grf.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            grf.drawImage(mapa.getImage(),0,0,mapa.getImage().getWidth(obs)+100,mapa.getImage().getHeight(obs)+100, null);
            grf.dispose();
            imagens.add(buf);
            index.add("+1");
            mapa.setImage(buf);
            redesenharMapa();
        }
        
    }
    
    
    public void zoomOutImage() {
        if (index.size() > 1) {
            Image imagem = imagens.get(index.size() - 2);
            mapa.setImage(imagem);
            index.remove(0);
            redesenharMapa();
        } else if (index.size() == 1) {
            Image imagem = imagens.get(0);
            mapa.setImage(imagem);
            index.remove(0);
            redesenharMapa();
        }
    }
    
    public void adicionarPonto(double x, double y){        
        ImageIcon icon = new ImageIcon("res/PONTO.png");
        Image imagemReajustada = icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        icon.setImage(imagemReajustada);
        int xInteiro = (int)x ;
        int yInteiro = (int)y ;
        double xReal = x - xInteiro;
        double yReal = y - yInteiro; 
        System.out.println("xReal: " + xReal);
        System.out.println("yReal: " + yReal);
        xReal += xReal;
        yReal += yReal;
        pontos.add(new Node((xReal*700)/1.25,yReal*4000,icon));
        redesenharMapa();
    }
    
    public void redesenharMapa(){
        repaint();
    }

    public ImageIcon getMapa() {
        return mapa;
    }

    public void setMapa(ImageIcon mapa) {
        this.mapa = mapa;
    }

    public ImageObserver getObs() {
        return obs;
    }

    public void setObs(ImageObserver obs) {
        this.obs = obs;
    }
    
    

    

    

    
    
    
}
