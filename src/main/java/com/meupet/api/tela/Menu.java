package com.meupet.api.tela;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

import com.meupet.api.controle.ControleDados;
import main.controle.*;

/**
 * Implementa uma interface que mostra o menu principal
 * 
 * @author Diego Sousa Leite
 * @since 2022
 * @version 1.0
 */
public class Menu implements ActionListener {

	private static JFrame f = new JFrame("Menu Principal");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton cadastroCachorro = new JButton("Cadastrar Cachorro");
	private static JButton cadastroAve = new JButton("Cadastrar Ave");
	private static JButton cadastroGato = new JButton("Cadastrar Gato");
	private static JButton cadastroVacina = new JButton("Cadastrar Vacina");
	private static JButton buscarAve = new JButton("Buscar Ave");
	private static JButton buscarCachorro = new JButton("Buscar Cachorro");
	private static JButton buscarGato = new JButton("Buscar Gato");
	private static JButton buscarVacina = new JButton("Buscar Vacina");
	public static ControleDados dados = new ControleDados();

	/**
	 * Cria a tela do menu do sistema
	 */
	public Menu() {

		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(200, 10, 150, 30);
		f.setBackground(Color.cyan);
		f.setSize(550, 350);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setLayout(null);

		cadastroCachorro.setBounds(50, 100, 200, 40);
		cadastroGato.setBounds(50, 150, 200, 40);
		cadastroAve.setBounds(50, 50, 200, 40);
		cadastroVacina.setBounds(50, 200, 200, 40);
		buscarAve.setBounds(300, 50, 200, 40);
		buscarCachorro.setBounds(300, 100, 200, 40);
		buscarGato.setBounds(300, 150, 200, 40);
		buscarVacina.setBounds(300, 200, 200, 40);

		f.add(cadastroCachorro);
		f.add(cadastroGato);
		f.add(cadastroAve);
		f.add(cadastroVacina);
		f.add(buscarAve);
		f.add(buscarCachorro);
		f.add(buscarGato);
		f.add(buscarVacina);
		f.add(titulo);
	}

	/**
	 * Instacia os ActioListener para os butões do menu
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Menu frame = new Menu();
		cadastroCachorro.addActionListener(frame);
		cadastroGato.addActionListener(frame);
		cadastroAve.addActionListener(frame);
		cadastroVacina.addActionListener(frame);
		buscarAve.addActionListener(frame);
		buscarCachorro.addActionListener(frame);
		buscarGato.addActionListener(frame);
		buscarVacina.addActionListener(frame);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == cadastroAve) {
			new TelaAnimal().mostrarDados(dados, 1);

		} else if (src == cadastroCachorro) {
			new TelaAnimal().mostrarDados(dados, 2);

		} else if (src == cadastroGato) {
			new TelaAnimal().mostrarDados(dados, 3);

		} else if (src == cadastroVacina) {
			new TelaAnimal().mostrarDados(dados, 4);

		} else if (src == buscarAve) {
			new TelaDeBusca().mostrarTela(1, dados);
		} else if (src == buscarCachorro) {
			new TelaDeBusca().mostrarTela(2, dados);
		} else if (src == buscarGato) {
			new TelaDeBusca().mostrarTela(3, dados);
		} else if (src == buscarVacina) {
			new TelaDeBusca().mostrarTela(4, dados);
		}

	}

}
