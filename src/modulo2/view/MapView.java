/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.view;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalIconFactory;
import modulo2.model.saida.Connection;
import modulo2.model.saida.Data;
import modulo2.model.saida.Edge;
import modulo2.model.saida.Edges;
import modulo2.model.saida.Node;
import modulo2.model.saida.Type;

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
    private double xMax; //RIGHT
    private double xMin; //LEFT
    private double yMax; //BOT
    private double yMin; //TOP
    private double xMedia; //Media de largura
    private double yMedia; //Media de altura
    private double difX;
    private double difY;
    private Data data;
    private boolean desenhar = true;
    private int indexModificar = -1;

    public MapView(ImageIcon mapa, ImageObserver observer) {
        this.mapa = mapa;
        this.obs = observer;
    }
    
    public void popularDados(){
        this.data = Data.getInstance();
        pontos = data.getNodes().getNode();
        this.xMax = data.getxMax();
        this.xMin = data.getxMin();
        this.yMax = data.getyMax();
        this.yMin = data.getyMin();
        this.yMedia = (yMax + yMin)/2;
        this.xMedia = (xMax + xMin)/2;
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(background.getImage(), 0, 0, obs);
        g2.drawImage(mapa.getImage(), 0,0, obs);
        
        if(pontos.size() > 0){
            if(desenhar){



            for(Node nodo: pontos){
                
                adicionarPonto(nodo.getLongitude(), nodo.getLatitude());
                nodo.setX(this.x);
                nodo.setY(this.y);
                g2.drawImage(nodo.getImagem().getImage(), nodo.getX(),nodo.getY(), obs);
                //System.out.println("X: " + x);
                //System.out.println("Y: " + y);
            }
            desenhar = false;
            
            }
            }

        }
    
    
    public void verificarClique(int x, int y) {
        ImageIcon iconAzul = new ImageIcon("res/PONTO_SELECIONADO.png");
        Image imagemReajustadaAzul = iconAzul.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon iconVerde = new ImageIcon("res/PONTO.png");
        Image imagemReajustadaVerde = iconVerde.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        for(Node nodo: pontos){
            if((x > nodo.getX()) && (x < nodo.getX() + 20)){ //Se o mouse clicou no nodo horizontal
                if((y > nodo.getY()) && (y < nodo.getY() + 20)){ //Se o mouse clicou no nodo vertical
                    if(!(nodo.getImagem().toString().equals(iconAzul.toString()))){                       
                        iconAzul.setImage(imagemReajustadaAzul);
                        nodo.setImagem(iconAzul);
                        indexModificar = Integer.parseInt(nodo.getId());
                    }else{
                        iconVerde.setImage(imagemReajustadaVerde);
                        nodo.setImagem(iconVerde);
                    }
                }
            }
        }
        desenhar = true;
        redesenharMapa();
    }
    
    public void alterarDados(String dadoParaAlterar, String valor){
        switch(dadoParaAlterar){
            case "Fluxo": alterarFluxo(valor); break;
            case "Capacidade": alterarCapacidade(valor);break;
            case "Demanda": alterarDemanda(valor);break;
            case "Velocidade": alterarVelocidade(valor);break;
        }
    }
    
    public void atualizarMapa(ImageIcon mapa) {
        this.mapa = mapa;
        if (this.mapa.getImage().getHeight(obs) > 1000 || this.mapa.getImage().getWidth(obs) > 1500) {        
            Image imagemReajustada = this.mapa.getImage().getScaledInstance(1000, 720, Image.SCALE_DEFAULT);
            this.mapa.setImage(imagemReajustada);
            index.add("+1");
            imagens.add(mapa.getImage());
            repaint();
        } else {
            Image imagemReajustada = this.mapa.getImage().getScaledInstance(1000, 720, Image.SCALE_DEFAULT);
            this.mapa.setImage(imagemReajustada);
            index.add("+1");
            imagens.add(mapa.getImage());
            repaint();
        }

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
        descobrirXY(x,y);        
//        pontos.add(new Node(this.x,this.y,icon));
    }
    
    private void descobrirXY(double x, double y) {
        // xMAX = 1000    yMAX = 700     Fazer um de cada vez
    //double x  =  ?
        
    
        //Conversão para positivo
        if(x < 0){
            x = x*-1;
        }
        if(y < 0){
            y = y*-1;
        }
        
        if(x < xMedia){
            //System.out.println("Caiu no menor: " + (xMedia-x));
            difX = (xMedia-x)*100000;
            x*= 500;//Largura da tela/2
            x/=xMedia;
            int diferenca = (int)difX;
            //System.out.println("Diferenca: " + diferenca);
            this.x = (int)((int)x + (diferenca/2.5));
        }else{
            //System.out.println("Caiu no maior: " + (x-xMedia));
            difX = (x-xMedia)*100000;
            x*= 500;//Largura da tela/2
            x/=xMedia;
            int diferenca = (int)difX;
            //System.out.println("Diferenca: " + diferenca);
            this.x = (int)((int)x - (diferenca/2.4));
        }

        if(y < yMedia){ //RESOLVIDO
            //System.out.println("Caiu no menor: " + (yMedia-y));
            difY = (yMedia-y)*100000;
            y*= 350;//Altura da tela/2
            y/=yMedia;
            int diferenca = (int)difY;
            //System.out.println("Diferenca: " + diferenca);
            this.y = (int)((int)y - (diferenca/1.8));
            
        }else{
            //System.out.println("Caiu no maior: " + (y-yMedia));
            difY = (y-yMedia)*100000;
            y*= 350; //Altura da tela/2
            y/=yMedia;
            int diferenca = (int)difY;
            //System.out.println("Diferenca: " + diferenca);
            this.y = (int)((int)y + (diferenca/1.8));
        }
        
        
        
        
        
        
        
        
        
       
        
        //System.out.println("X: " + this.x);
        //System.out.println("Y: " + this.y);
            
//         if(x < xMedia){
//            System.out.println("Caiu no menor: " + (xMedia-x));
//            difX = (xMedia-x)*100000;
//            x*= 500;//Largura da tela/2
//            x/=xMedia;
//            int diferenca = (int)difX;
//            System.out.println("Diferenca: " + diferenca);
//            this.x = (int)((int)x + (diferenca/2.6) + 75);
//        }else{
//            System.out.println("Caiu no maior: " + (x-xMedia));
//            difX = (x-xMedia)*100000;
//            x*= 500;//Largura da tela/2
//            x/=xMedia;
//            int diferenca = (int)difX;
//            System.out.println("Diferenca: " + diferenca);
//            this.x = (int)((int)x - (diferenca/2.6) + 140);
//        }
//
//        if(y < yMedia){ //RESOLVIDO
//            //System.out.println("Caiu no menor: " + (yMedia-y));
//            difY = (yMedia-y)*100000;
//            y*= 350;//Altura da tela/2
//            y/=yMedia;
//            int diferenca = (int)difY;
//            //System.out.println("Diferenca: " + diferenca);
//            this.y = (int)((int)y - (diferenca/2.4));
//            
//        }else{
//            //System.out.println("Caiu no maior: " + (y-yMedia));
//            difY = (y-yMedia)*100000;
//            y*= 350; //Altura da tela/2
//            y/=yMedia;
//            int diferenca = (int)difY;
//            //System.out.println("Diferenca: " + diferenca);
//            this.y = (int)((int)y + (diferenca/2.2));
//        }
        
        //Faz regra de 3 com o valor de x
        //49.538,27.056
        
        //      X,Y
        
        
        
       
        //https://www.openstreetmap.org/export#map=16/-27.0581/-49.5395
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

    private void alterarFluxo(String valor) {
        if(indexModificar != -1){
       List<Connection> connections =data.getConnections().getConnection();
        for (Connection connection : connections) {
            if(connection.getSource().equals(indexModificar)){
                connection.setFlow(valor);
            }
        }
        }
    }

    private void alterarCapacidade(String valor) {
         if(indexModificar != -1){
      List<Edge> edges = data.getEdges().getEdge();
      for(Edge edge : edges){
          if(edge.getId().equals(indexModificar)){
              edge.setCapacity(valor);
          }
      }
         }
    }

    private void alterarDemanda(String valor) {
         if(indexModificar != -1){
       List<Type> types = data.getTypes().getType();
       for(Type type : types){
           if(type.getId().equals(indexModificar)){
               type.setCapacity(valor);
           }
       }
         }
    }

    private void alterarVelocidade(String valor) {
         if(indexModificar != -1){
        List<Type> types = data.getTypes().getType();
        List<Edge> edges = data.getEdges().getEdge();
        for(Type type : types){
           if(type.getId().equals(indexModificar)){
               type.setSpeed(valor);
           }
       }
        for (Edge edge : edges) {
            if(edge.getId().equals(indexModificar)){
                edge.setSpeed(valor);
            }
        }
         }
    }

    void exportarMacro() {
         XStream xstream = new XStream(new DomDriver());
         String xml = xstream.toXML(data);
         
    }

    void exportarMicro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
