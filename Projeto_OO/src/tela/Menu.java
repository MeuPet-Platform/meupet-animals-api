package tela;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import controle.*;


/**
 * Implementa uma interface que mostra o menu principal
 * @author Diego Sousa Leite
 * @since 2022
 * @version 1.0 
 */
public class Menu implements ActionListener {

	private static JFrame f = new JFrame("Menu Principal");
	private static JButton cadastroCachorro = new JButton("Cadastrar Cachorro");
	private static JButton cadastroAve = new JButton("Cadastrar Ave");
	private static JButton cadastroGato = new JButton("Cadastrar Gato");
	private static JButton cadastroVacina = new JButton("Cadastrar Vacina");
	private static JButton buscarAnimal = new JButton ("Buscar animal"); 
	public static ControleDados dados = new ControleDados();
	
	/**
	 * Cria a tela do menu do sistema
	 */
	public Menu() {
		
		
		f.setBackground(Color.cyan);
		f.setSize(550,350);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		
		
		
		
		cadastroCachorro.setBounds(50,50,200,40);
		cadastroGato.setBounds(50,100,200,40);
		cadastroAve.setBounds(300,50,200,40);
		cadastroVacina.setBounds(300,100,200,40);
		buscarAnimal.setBounds(175,150,200,40);
		
		
		
		f.add(cadastroCachorro);
		f.add(cadastroGato);
		f.add(cadastroAve);
		f.add(cadastroVacina);
		f.add(buscarAnimal);
	}
	
	/**
	 * Instacia os ActioListener para os butões do menu
	 * @param args
	 */
	public static void main(String[] args) {
		Menu frame = new Menu();
		cadastroCachorro.addActionListener(frame);
		cadastroGato.addActionListener(frame);
		cadastroAve.addActionListener(frame);
		cadastroVacina.addActionListener(frame);
		buscarAnimal.addActionListener(frame);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cadastroAve) {
			new TelaAnimal().mostrarDados(dados, 1);
			
		}else if(src == cadastroCachorro) {
			new TelaAnimal().mostrarDados(dados, 2);
			
		}else if(src == cadastroGato) {
			new TelaAnimal().mostrarDados(dados, 3);
			
		}else if(src == cadastroVacina) {
			new TelaAnimal().mostrarDados(dados, 4);
			
		}else if(src == buscarAnimal) {
			new TelaMenuBuscar();
			//new TelaDeBusca().mostrarTela(1, dados);
		}
		
	}



}
