/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2.view;

import javax.swing.JFrame;

/**
 *
 * @author Jogos
 */
public class main implements Runnable {

    public static void main(String[] args) {
         JFrame janela = new TelaPrincipal();
        janela.setUndecorated(false);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Saida clicando no "X"
        janela.setVisible(true);
        janela.setResizable(false);
    }

    @Override
    public void run() {
        JFrame janela = new TelaPrincipal();
        janela.setUndecorated(false);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Saida clicando no "X"
        janela.setVisible(true);
        janela.setResizable(false);
    }
}
