/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.control;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modulo2.model.entrada.Node;
import modulo2.model.entrada.Osm;
import modulo2.model.saida.Data;
import modulo2.model.saida.Nodes;
import principal.GeradorXML;

/**
 *
 * @author vinny
 */
public class Controles {
    private Osm osm;
    private ConversorES converterES;
    private Data data;
    public void geraObjeto(File file) {
        osm = Osm.getInstance();
        data = Data.getInstance();
        try {
            FileReader ler = new FileReader(file);
            XStream xstream = new XStream(new DomDriver());
            xstream.autodetectAnnotations(true);
            
            xstream.alias("osm", Osm.class);
            
            osm = (Osm) xstream.fromXML(ler);
            
//            Teste para verificar se salvou no Objeto osm 
            System.out.println("Bounds.maxlat: " + osm.getBounds().getMaxlat());
            System.out.println("Bounds.minlat: " + osm.getBounds().getMinlat());
            
            System.out.println("Nodes");
            for(Node node: osm.getNode()) {
                System.out.println("Version: "+ node.getVersion());
                System.out.println("Id: "+ node.getId());
                System.out.println("------------------");
            }
                
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeradorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        data= converterES.converterES(osm,data);
    }
    
    public void geraXmlMacro(){
        Node node =  new Node();
        node.setId("1");
        
        Nodes nodes = new Nodes();
        nodes.addNodes(node);
        
        String msg = node.getId();
        System.out.println(msg);
        
        XStream stream = new XStream(new DomDriver());
        stream.alias("name", Node.class);
        
        String xml = stream.toXML(node);
        
        System.out.println("<?xml versio=\"1.0\"?>");
        System.out.println(xml);
        
        
    }
    public void geraXmlMicro(){
        JOptionPane.showMessageDialog(null, "XML Micro");
    }
    
}
