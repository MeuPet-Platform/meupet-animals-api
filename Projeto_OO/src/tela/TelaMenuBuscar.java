package tela;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

import controle.*;

public class TelaMenuBuscar implements ActionListener {
	private static JFrame f = new JFrame("Menu Buscar");
	private static JButton buscarAve = new JButton ("Buscar Ave");
	private static JButton buscarCachorro = new JButton ("Buscar Cachorro");
	private static JButton buscarGato = new JButton ("Buscar Gato");
	private static JButton buscarVacina = new JButton ("Buscar Vacina");
	public static ControleDados dados = new ControleDados();
	
	public TelaMenuBuscar(){
		f.setBackground(Color.cyan);
		f.setSize(550,350);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		
		buscarAve.setBounds(50,50,200,40);
		buscarCachorro.setBounds(50,100,200,40);
		buscarGato.setBounds(300,50,200,40);
		buscarVacina.setBounds(300,100,200,40);
		
		f.add(buscarAve);
		f.add(buscarCachorro);
		f.add(buscarGato);
		f.add(buscarVacina);
		
			buscarAve.addActionListener(this);
			buscarCachorro.addActionListener(this);
			buscarGato.addActionListener(this);
			buscarVacina.addActionListener(this);
	}
	
			
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == buscarAve) {
			new TelaDeBusca().mostrarTela(1, dados);
		}else if(src == buscarCachorro) {
			new TelaDeBusca().mostrarTela(2, dados);
		}else if(src == buscarGato) {
			new TelaDeBusca().mostrarTela(3, dados);
		}else if(src == buscarVacina) {
			new TelaDeBusca().mostrarTela(4, dados);
		}
		
		
		
	}	
	
	
}
