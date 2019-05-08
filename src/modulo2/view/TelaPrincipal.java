/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.view;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

/**
 *
 * @author vinny
 */
public class TelaPrincipal extends JFrame implements ActionListener{
    
    private JMenuBar menuBar1;
    private JMenu menuArquivo, menuSave;
    private JMenuItem miAbrir,miSair, miSalvar, miSalvarC, miSalvarT;
    
    public static void main(String[] args) {
        JFrame janela = new TelaPrincipal();
        janela.setUndecorated(false); // Tirar a decoração deafult da janela
        //janela.getRootPane().setWindowDecorationStyle(JRootPane.FRAME); // Colocar uma nova decoração
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Saida clicando no "X"
        janela.setVisible(true);
    }

    // Init components
    TelaPrincipal(){
        
        //Configurações da tela principal
        setTitle("Modulo 2");
        setBounds(300,50,500,500);
        getContentPane().setBackground(new Color(0,128,128));
        
        //Configuração dos menus
        menuBar1 = new JMenuBar();
        menuArquivo = new JMenu("Arquivo");
        menuArquivo.setMnemonic(KeyEvent.VK_A);
        menuArquivo.addActionListener(this);
        menuSave = new JMenu("Salvar");
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
        miSair = new JMenuItem("Sair", new ImageIcon("res/exit.png"));
        miSair.addActionListener(this);
        miSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.ALT_MASK));
        miSair.setMnemonic(KeyEvent.VK_N);
        
        
        //Fazendo adições nos menus
        menuSave.add(miSalvar); menuSave.add(miSalvarC);
        menuSave.add(miSalvarT);
        menuArquivo.add(miAbrir); menuArquivo.add(menuSave);
        menuArquivo.addSeparator(); menuArquivo.add(miSair);
        menuBar1.add(menuArquivo);
        setJMenuBar(menuBar1);
        
    }
    //Faz todos os métodos de clique do menu
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == miAbrir){
            JOptionPane.showMessageDialog(rootPane, "Abrir arquivo","Mensagem", JOptionPane.INFORMATION_MESSAGE);
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
        if(e.getSource() == miSair){
            JOptionPane.showMessageDialog(rootPane, "Saindo do sistema","Mensagem", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    
    
}
