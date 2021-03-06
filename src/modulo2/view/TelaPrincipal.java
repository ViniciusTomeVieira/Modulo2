/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.view;

import com.sun.glass.events.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import modulo2.control.Controles;


/**
 *
 * @author vinny
 */
public class TelaPrincipal extends JFrame implements ActionListener,MouseWheelListener,MouseListener{
    
    //Menu superior
    private JMenuBar menuBar1;
    private JMenu menuArquivo, menuSave, menuEditar, menuOpcoes, menuExporta;
    private JMenuItem miAbrir,miSair, miSalvar, miSalvarC, miSalvarT, miExcluir, miEditarFluxo, miEditarCapacidadeDaVia,miEditarDemandaDeCarros,miEditarVelocidade, miExportaMacro, miExportaMicro;
    
    

    
    
    //MapView
    private MapView mapView;
    private Controles controle;
    private JPanel paiMapView;

   
    
    
 

    // Init components
   public TelaPrincipal(){
        
        //Configurações da tela principal
        setTitle("Modulo 2");
        setBounds(400,95,1000,720);
        getContentPane().setBackground(new Color(0,128,128));
        getContentPane().setLayout(new BorderLayout());
        
        //Configuração dos menus
        menuBar1 = new JMenuBar();
        
        //Menu Arquivo
        menuArquivo = new JMenu("Arquivo");
        menuArquivo.setMnemonic(KeyEvent.VK_A);
        menuArquivo.addActionListener(this);
        menuSave = new JMenu("Salvar");
        menuSave.setIcon(new ImageIcon("res/save.png"));
        menuExporta = new JMenu("Exportar");
        menuExporta.setIcon(new ImageIcon("res/export.png"));
        miAbrir = new JMenuItem("Abrir", new ImageIcon("res/open.png"));
        miAbrir.addActionListener(this);
        miAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.ALT_MASK));
        miAbrir.setMnemonic(KeyEvent.VK_B);
        miSalvar = new JMenuItem("Salvar", new ImageIcon("res/save.png"));
        miSalvar.addActionListener(this);
        miSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.ALT_MASK));
        miSalvar.setMnemonic(KeyEvent.VK_N);
        miSalvarC = new JMenuItem("Salvar como", new ImageIcon("res/saveAs.png"));
        miSalvarC.addActionListener(this);
        miSalvarC.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.ALT_MASK));
        miSalvarC.setMnemonic(KeyEvent.VK_N);
        miSalvarT = new JMenuItem("Salvar tudo", new ImageIcon("res/saveAll.png"));
        miSalvarT.addActionListener(this);
        miSalvarT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.ALT_MASK));
        miSalvarT.setMnemonic(KeyEvent.VK_N);
        miExportaMacro = new JMenuItem("Simulação macroscópica");
	miExportaMacro.addActionListener(this);
	miExportaMacro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.ALT_MASK));
	miExportaMacro.setMnemonic(KeyEvent.VK_N);     
	miExportaMicro = new JMenuItem("Simulação microscópica");
	miExportaMicro.addActionListener(this);
	miExportaMicro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.ALT_MASK));
	miExportaMicro.setMnemonic(KeyEvent.VK_N);  
        miExcluir = new JMenuItem("Excluir", new ImageIcon("res/delete.png"));
        miExcluir.addActionListener(this);
        miExcluir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.ALT_MASK));
        miExcluir.setMnemonic(KeyEvent.VK_N);
        
        
        //Menu editar       
        menuEditar = new JMenu("Editar");
        menuEditar.setMnemonic(KeyEvent.VK_E);
        menuEditar.addActionListener(this);
        menuEditar.setVisible(true);
        miEditarFluxo = new JMenuItem("Fluxo da via", new ImageIcon("res/fluxo.png"));
        miEditarFluxo.addActionListener(this);
        miEditarFluxo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.ALT_MASK));
        miEditarFluxo.setMnemonic(KeyEvent.VK_F);
        miEditarCapacidadeDaVia = new JMenuItem("Capacidade da Via", new ImageIcon("res/fluxo.png"));
        miEditarCapacidadeDaVia.addActionListener(this);
        miEditarCapacidadeDaVia.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.ALT_MASK));
        miEditarCapacidadeDaVia.setMnemonic(KeyEvent.VK_C);
        miEditarDemandaDeCarros = new JMenuItem("Demanda de carros", new ImageIcon("res/fluxo.png"));
        miEditarDemandaDeCarros.addActionListener(this);
        miEditarDemandaDeCarros.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.ALT_MASK));
        miEditarDemandaDeCarros.setMnemonic(KeyEvent.VK_D);
        miEditarVelocidade = new JMenuItem("Velocidade", new ImageIcon("res/fluxo.png"));
        miEditarVelocidade.addActionListener(this);
        miEditarVelocidade.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.ALT_MASK));
        miEditarVelocidade.setMnemonic(KeyEvent.VK_Q);
        menuEditar.add(miEditarFluxo);
        menuEditar.add(miEditarCapacidadeDaVia);
        menuEditar.add(miEditarDemandaDeCarros);
        menuEditar.add(miEditarVelocidade);
        
        //Menu Opções
        menuOpcoes = new JMenu("Opcoes");
        menuOpcoes.setMnemonic(KeyEvent.VK_O);
        menuOpcoes.addActionListener(this);
        miSair = new JMenuItem("Sair", new ImageIcon("res/exit.png"));
        miSair.addActionListener(this);
        miSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.ALT_MASK));
        miSair.setMnemonic(KeyEvent.VK_X);
        menuOpcoes.addSeparator(); menuOpcoes.add(miSair);
        
        
        //Menu Arquivo
        menuSave.add(miSalvar); menuSave.add(miSalvarC);
        menuSave.add(miSalvarT);
        menuArquivo.add(miAbrir); menuArquivo.add(menuSave);
        menuArquivo.add(menuExporta); 
        menuExporta.add(miExportaMacro); menuExporta.add(miExportaMicro);
        menuArquivo.add(miExcluir);

        
        //Adicionando menus na menuBarSuperior
        menuBar1.add(menuArquivo); menuBar1.add(menuEditar); menuBar1.add(menuOpcoes);
        
        //Seta a menuBar no sistema
        setJMenuBar(menuBar1);
        
        
        //Adicionando painel principal
        
        paiMapView = new JPanel();
        mapView = new MapView(new ImageIcon("res/mapaDefault.png"),this);
        mapView.addMouseWheelListener(this);
        mapView.addMouseListener(this);
        getContentPane().add(mapView);
        controle = new Controles();
        
        
        
    }
    //Faz todos os métodos de clique do menu
    @Override
    public void actionPerformed(ActionEvent e) {

        
        if(e.getSource() == miAbrir){
            abrirOsm();          
        }
        if(e.getSource() == miSalvar){
            JOptionPane.showMessageDialog(rootPane, "Salvar","Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == miSalvarC){
            JOptionPane.showMessageDialog(rootPane, "Salvar como","Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == miSalvarT){
            JOptionPane.showMessageDialog(rootPane, "Salvar tudo","Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == miExportaMacro){
            exportaMacro();
	}        
	if(e.getSource() == miExportaMicro){
            exportaMicro();
	}
        if(e.getSource() == miSair){
            JOptionPane.showMessageDialog(rootPane, "Saindo do sistema","Mensagem", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        if(e.getSource()==miEditarCapacidadeDaVia){
            mapView.alterarDados("Capacidade",JOptionPane.showInputDialog(rootPane,"Digite a nova capacidade da via:"));          
        }
        if(e.getSource()==miEditarFluxo){
            mapView.alterarDados("Fluxo",JOptionPane.showInputDialog(rootPane,"Digite o novo fluxo da via:"));          
        }
        if(e.getSource()==miEditarDemandaDeCarros){
            mapView.alterarDados("Demanda",JOptionPane.showInputDialog(rootPane,"Digite a nova demanda da via:"));          
        }
        if(e.getSource()==miEditarVelocidade){
            mapView.alterarDados("Velocidade",JOptionPane.showInputDialog(rootPane,"Digite a nova velocidade da via:"));          
        }
        if(e.getSource()==miExportaMacro){
            mapView.exportarMacro();
            JOptionPane.showMessageDialog(rootPane,"Xml exportado para a area de trabalho");
        }
        if(e.getSource()==miExportaMicro){
            mapView.exportarMicro();
            JOptionPane.showMessageDialog(rootPane,"Xml exportado para a area de trabalho");
        }
    }
    
    public void abrirOsm(){
         JFileChooser fileChooser = new JFileChooser(); // Cria uma janela de selecao de arquivo
            fileChooser.setDialogTitle("Abrir mapa OSM ou TNTP"); // Titulo da janela
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  //Seta para somente arquivos         
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo OSM/TNTP", "osm","tntp"); // Cria o filtro dos arquivos
            fileChooser.setFileFilter(filter); //Coloca o filtro na janela
            int retorno = fileChooser.showOpenDialog(this); //Recebe um valor dependendo se ele escolheu ou não um arquivo
            
            if(retorno == JFileChooser.APPROVE_OPTION){ //Se abriu realmente um arquivo
                File file = fileChooser.getSelectedFile(); // Recebe o arquivo selecionado
                System.out.println(file.getPath()); // Imprime o caminho do arquivo
                controle.geraObjeto(file);
                
                
                abrirImagem();
            }else if(retorno == JFileChooser.CANCEL_OPTION){
                JOptionPane.showMessageDialog(rootPane, "Nenhum arquivo selecionado","Aviso",JOptionPane.WARNING_MESSAGE);
            }
    }

    private void abrirImagem() {
            JFileChooser fileChooser = new JFileChooser(); // Cria uma janela de selecao de arquivo
            fileChooser.setDialogTitle("Abrir imagem do mapa"); // Titulo da janela
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  //Seta para somente arquivos         
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo PGN/JPEG/SVG", "png","jpeg","svg"); // Cria o filtro dos arquivos
            fileChooser.setFileFilter(filter); //Coloca o filtro na janela
            int retorno = fileChooser.showOpenDialog(this); //Recebe um valor dependendo se ele escolheu ou não um arquivo
            
            if(retorno == JFileChooser.APPROVE_OPTION){ //Se abriu realmente um arquivo
                File file = fileChooser.getSelectedFile(); // Recebe o arquivo selecionado
                System.out.println(file.getPath()); // Imprime o caminho do arquivo 
                mapView.popularDados();
                mapView.atualizarMapa(new ImageIcon(file.getPath()));
            }else if(retorno == JFileChooser.CANCEL_OPTION){
                JOptionPane.showMessageDialog(rootPane, "Nenhuma imagem selecionada","Aviso",JOptionPane.WARNING_MESSAGE);
            }
    }

    private void exportaMacro(){
        controle.geraXmlMacro();
    }

    private void exportaMicro(){
        controle.geraXmlMicro();
    }
    
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if(e.getWheelRotation() < 0){ // pra cima
            //mapView.zoomImage();
            //mapView.adicionarPonto(-49.5400306,-27.0568799 );
            mapView.adicionarPonto(-49.538,-27.056);
            mapView.adicionarPonto(-49.5473,-27.0539);
            mapView.adicionarPonto(-49.5346,-27.0556);
            mapView.adicionarPonto(-49.5441,-27.0537);
            mapView.adicionarPonto(-49.5368,-27.0594);
            mapView.adicionarPonto(-49.5351,-27.0607); 
            mapView.adicionarPonto(-49.5361,-27.0523);
        }else{// pra baixo
            //mapView.zoomOutImage();
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {        
        mapView.verificarClique(e.getX(),e.getY());                               
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }



   
    
    
    
    
}
