package principal;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Bounds;
import objetos.Nd;
import objetos.Node;
import objetos.Osm;
import objetos.Tag;
import objetos.Way;


/**
 * Classe Main para testes de XML
 * 
 * @author Fábio
 */
public class GeradorXML {
    
    // Objeto
    static Osm osm;
    
    public static void main(String[] args) {
        
        // Aqui geramos um objeto a partir de um XML
        osm = geraObjeto();
        
        // Teste se o objeto esta vindo aqui.
//        System.out.println("Bouns: " + osm.getBounds().getMaxlat());
        
        
        
        // A partir de agora vamos gerar um XML a partir do objeto acima => osm
        
        // Estância de um objeto XStream
        XStream xstream = new XStream(new DomDriver());
        
        // Alias para as tag's 
        xstream.alias("osm", Osm.class);
        xstream.alias("node", Node.class);
        xstream.alias("nd", Nd.class);
        xstream.alias("tag", Tag.class);
        
        
        // Transforma o objeto em XML
        String xml = xstream.toXML(osm);
        
        // Print XML
        System.out.println(xml);
        
        // Gera o arquivo XML a partir do objeto osm
        geraXML(xml);
        
    }
    
    // Transforma Arquivo XML em Objeto
    public static Osm geraObjeto() {
        try {
            FileReader ler = new FileReader("C:\\xmlFabio\\map.xml");
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
        return osm;
        
    }
    
    //Transforma Objeto em Arquivo XML
    public static void geraXML(String xml) {
        PrintWriter print = null;
        try {
            File file = new File("C:\\xmlFabio\\map2.xml");
            print = new PrintWriter(file);
            print.write(xml);
            print.flush();
            print.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeradorXML.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            print.close();
        }
    }
}
    
   
