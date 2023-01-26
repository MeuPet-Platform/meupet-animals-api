package tela;

import java.awt.Color;
import java.awt.color.*;

import javax.swing.*;

public class Teste {

	public static void main(String[] args) {
		
		
		JFrame f = new JFrame();
		
		f.setBackground(Color.cyan);
		f.setSize(200,180);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		
		JButton cadastroCachorro = new JButton("Cadastrar Cachorro");
		cadastroCachorro.setBounds(50,50,100,40);
		cadastroCachorro.setVisible(true);
		
	

	}

}
