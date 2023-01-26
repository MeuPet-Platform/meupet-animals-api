package tela;

import javax.swing.*;


import controle.*;

public class TelaMostrarBusca {
	private JFrame janela = new JFrame("Resultado Busca");
	private JLabel labelNome= new JLabel("Nome: ");
	private JLabel valorNome;
	private JLabel labelRaca = new JLabel("Raca: ");
	private JLabel valorRaca;
	private JLabel labelPeso = new JLabel("Peso: ");
	private JLabel valorPeso;
	private JLabel labelSexo = new JLabel("Sexo: ");
	private JLabel valorSexo;
	private JLabel labelAsaCortada = new JLabel("Asa Cortada: ");
	private JLabel valorAsa;
	private JLabel labelEmGaiola = new JLabel("Em Gaiola: ");
	private JLabel valorGaiola;
	private JLabel labelExotico = new JLabel("Exotico: ");
	private JLabel valorExotico;
	
	/**
	 * Mostra o resultado da busca
	 * @param opcao, representa a escolha feita pelo usuário
	 * (1) Figurinha de Jogador
	 * (2) Figurinha de Estádio
	 * @param posicao, representa a posição da figurinha
	 * @param dados, permite acesso aos dados da figurinha
	 */
	public void mostrarTela(int opcao, int pos, ControleDados dados) {
		
		if(pos != 99999) {
			if(opcao == 1 && pos <= 50 ) {
				valorNome = new JLabel(dados.getAves()[pos].getNome());
				valorRaca = new JLabel(dados.getAves()[pos].getRaca());
				valorPeso = new JLabel(String.valueOf(dados.getAves()[pos].getPeso()));
				valorSexo = new JLabel(dados.getAves()[pos].getSexo());
				valorAsa = new JLabel(dados.getAves()[pos].getAsaCortada());
				valorGaiola = new JLabel(dados.getAves()[pos].getEmGaiola());
				valorExotico = new JLabel(dados.getAves()[pos].getExotico());
				
			}
	
			if(opcao == 2) {
				valorNome = new JLabel(dados.getCachorros()[pos].getNome());
				valorRaca = new JLabel(dados.getCachorros()[pos].getRaca());
			}
			
			
			labelNome.setBounds(10,10,150,30);
			valorNome.setBounds(150,10,330,30);
			labelRaca.setBounds(10,40,150,30);
			valorRaca.setBounds(150,40,330,30);
			labelPeso.setBounds(10,70,150,30);
			valorPeso.setBounds(150,70,330,30);
			labelSexo.setBounds(10,100,150,30);
			valorSexo.setBounds(150,100,330,30);
			labelAsaCortada.setBounds(10,130,150,30);
			valorAsa.setBounds(150,130,330,30);
			labelEmGaiola.setBounds(10,160,150,30);
			valorGaiola.setBounds(150,160,330,30);
			labelExotico.setBounds(10,190,150,30);
			valorExotico.setBounds(150,190,330,30);
			
			janela.setSize(550,350);
			janela.setLayout(null);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);
			janela.add(labelNome);
			janela.add(valorNome);
			janela.add(labelRaca);
			janela.add(valorRaca);
			janela.add(labelPeso);
			janela.add(valorPeso);
			janela.add(labelSexo);
			janela.add(valorSexo);
			janela.add(labelAsaCortada);
			janela.add(valorAsa);
			janela.add(labelEmGaiola);
			janela.add(valorGaiola);
			janela.add(labelExotico);
			janela.add(valorExotico);
			
		} else mensagemErro();
	
	}
	
	public void mensagemErro() {
		JOptionPane.showMessageDialog(null, "O Id digitado não foi cadastrado!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
}
