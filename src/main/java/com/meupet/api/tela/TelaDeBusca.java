//package com.meupet.api.tela;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.*;
//
//import com.meupet.api.controle.ControleDados;
//import main.controle.*;
//
//public class TelaDeBusca implements ActionListener {
//	private JFrame janela;
//	private JLabel tituloAnimal;
//	private JTextField valorNomeAnimal;
//	private JButton botao;
//	private ControleDados dados;
//	private TelaAnimal a;
//	private int animal;
//	int opcao;
//	/**
//	 * Permite o usuario digitar o nome do animal que deseja buscar
//	 * @param opcao define a opção de busca
//	 * (1) opcao = ave
//	 * (2) opcao = cachorro
//	 * (3) opcao = gato
//	 * (4) opcao = vacina
//	 */
//	public void mostrarTela(int opcao, ControleDados dados){
//		this.dados = dados;
//		this.opcao = opcao;
//		janela = new JFrame("Busca de Animal");
//		tituloAnimal = new JLabel("Digite o nome do animal que deseja buscar");
//		valorNomeAnimal =  new JTextField(200);
//		botao = new JButton("Buscar");
//
//		tituloAnimal.setBounds(15, 10, 350, 30);
//		valorNomeAnimal.setBounds(115, 60, 90, 25);
//		botao.setBounds(230, 80, 90, 30);
//		tituloAnimal.setFont(new Font("Calibri", Font.BOLD, 16));
//
//		janela.setLayout(null);
//
//		if(opcao == 1) {
//			janela.add(tituloAnimal);
//			janela.add(valorNomeAnimal);
//
//		}
//
//		if(opcao == 2) {
//			janela.add(tituloAnimal);
//			janela.add(valorNomeAnimal);
//		}
//		if(opcao == 3) {
//			janela.add(tituloAnimal);
//			janela.add(valorNomeAnimal);
//		}
//		if(opcao == 4) {
//			janela.add(tituloAnimal);
//			janela.add(valorNomeAnimal);
//		}
//
//		janela.add(botao);
//		janela.setSize(350,150);
//		janela.setVisible(true);
//		janela.setLocationRelativeTo(null);
//
//		botao.addActionListener(this);
//
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == botao) {
//			if(opcao == 1) { //mostra tela para busca de uma ave
//				String nomeAve = valorNomeAnimal.getText();
//				animal = dados.encontrarAve(nomeAve);
//				if(animal<99999) {
//					new TelaDetalheAnimal().inserirEditar(5, dados, a, animal);
//				}else {
//					mensagemErro();
//				}
//
//			}
//			if(opcao == 2) {//mostra tela para busca de um cachorro
//				String nomeCachorro = valorNomeAnimal.getText();
//				animal = dados.encontrarCachorro(nomeCachorro);
//				if(animal<99999) {
//					new TelaDetalheAnimal().inserirEditar(6, dados, a, animal);
//				}else {
//					mensagemErro();
//				}
//			}
//			if(opcao == 3) {//mostra tela para busca de um gato
//				String nomeGato = valorNomeAnimal.getText();
//				animal = dados.encontrarGato(nomeGato);
//				if(animal<99999) {
//					new TelaDetalheAnimal().inserirEditar(7, dados, a, animal);
//				}else {
//					mensagemErro();
//				}
//			}
//			if(opcao == 4) {//mostra tela para busca de uma vacina
//				String nomeVacina = valorNomeAnimal.getText();
//				animal = dados .encontrarVacina(nomeVacina);
//				if(animal<99999) {
//					new TelaDetalheAnimal().inserirEditar(8, dados, a, animal);
//				}else {
//					mensagemErro();
//				}
//			}
//		}
//
//	}
//
//
//	public void mensagemErro() {
//		JOptionPane.showMessageDialog(null,"Animal não cadastrado\n ", null,
//				JOptionPane.ERROR_MESSAGE);
//	}
//}
//
//