package tela;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

/**
 * Implementa uma interface que mostra os animais cadastrados no sistema
 * 
 * @author Diego Sousa Leite
 * @version 2022
 * @version 1.0
 */
public class TelaAnimal implements ActionListener, ListSelectionListener {
	private JFrame j;
	private JLabel titulo;
	private JButton cadastroAve;
	private JButton refreshAve;
	private JButton cadastroGato;
	private JButton refreshGato;
	private JButton cadastroCachorro;
	private JButton refreshCachorro;
	private JButton cadastroVacina;
	private JButton refreshVacina;
	private ControleDados dados;
	private JList<String> listaAvesCadastrados;
	private JList<String> listaCachorrosCadastrados;
	private JList<String> listaGatosCadastrados;
	private JList<String> listaVacinasCadastrados;
	private String[] listaNomes = new String[50];
	private String[] listaTipos = new String[50];

	/**
	 * Mostra os animais cadastrados através de uma JList
	 * 
	 * @param d,acessar     os dados dos produtos
	 * @param op,representa a opcao de tipo de produto escolhido pelo usuário
	 */
	public void mostrarDados(ControleDados d, int op) {
		dados = d;

		switch (op) {
		case 1:// Mostrar Dados de Aves cadastradas
			listaNomes = new ControleAve(dados).getNomeAve();
			listaAvesCadastrados = new JList<String>(listaNomes);
			j = new JFrame("Aves");
			titulo = new JLabel("Aves Cadastradas");
			cadastroAve = new JButton("Cadastrar");
			refreshAve = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaAvesCadastrados.setBounds(20, 50, 350, 120);
			listaAvesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaAvesCadastrados.setVisibleRowCount(10);

			cadastroAve.setBounds(70, 177, 100, 30);
			refreshAve.setBounds(200, 177, 100, 30);

			j.setLayout(null);

			j.add(titulo);
			j.add(listaAvesCadastrados);
			j.add(cadastroAve);
			j.add(refreshAve);

			j.setSize(400, 250);
			j.setVisible(true);
			j.setLocationRelativeTo(null);

			cadastroAve.addActionListener(this);
			refreshAve.addActionListener(this);
			listaAvesCadastrados.addListSelectionListener(this);

			break;

		case 2: // Mostrar dados de Cachorros cadastrados
			listaNomes = new ControleCachorro(dados).getNomeCachorro();
			listaCachorrosCadastrados = new JList<String>(listaNomes);
			j = new JFrame("Cachorro");
			titulo = new JLabel("Cachorros Cadastrados");
			cadastroCachorro = new JButton("Cadastrar");
			refreshCachorro = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaCachorrosCadastrados.setBounds(20, 50, 350, 120);
			listaCachorrosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaCachorrosCadastrados.setVisibleRowCount(10);

			cadastroCachorro.setBounds(70, 177, 100, 30);
			refreshCachorro.setBounds(200, 177, 100, 30);

			j.setLayout(null);

			j.add(titulo);
			j.add(listaCachorrosCadastrados);
			j.add(cadastroCachorro);
			j.add(refreshCachorro);

			j.setSize(400, 250);
			j.setVisible(true);
			j.setLocationRelativeTo(null);

			cadastroCachorro.addActionListener(this);
			refreshCachorro.addActionListener(this);
			listaCachorrosCadastrados.addListSelectionListener(this);

			break;

		case 3: // Mostrar dados de Gatos cadastrados
			listaNomes = new ControleGato(dados).getNomeGato();
			listaGatosCadastrados = new JList<String>(listaNomes);
			j = new JFrame("Gatos");
			titulo = new JLabel("Gatos Cadastrados");
			cadastroGato = new JButton("Cadastrar");
			refreshGato = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaGatosCadastrados.setBounds(20, 50, 350, 120);
			listaGatosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaGatosCadastrados.setVisibleRowCount(10);

			cadastroGato.setBounds(70, 177, 100, 30);
			refreshGato.setBounds(200, 177, 100, 30);

			j.setLayout(null);

			j.add(titulo);
			j.add(listaGatosCadastrados);
			j.add(cadastroGato);
			j.add(refreshGato);

			j.setSize(400, 250);
			j.setVisible(true);
			j.setLocationRelativeTo(null);

			cadastroGato.addActionListener(this);
			refreshGato.addActionListener(this);
			listaGatosCadastrados.addListSelectionListener(this);

			break;

		case 4: // Mostrar dados de Vacinas cadastrados
			listaTipos = new ControleVacina(dados).getTipoVacina();
			listaVacinasCadastrados = new JList<String>(listaTipos);
			j = new JFrame("Vacina");
			titulo = new JLabel("Vacinas Cadastradas");
			cadastroVacina = new JButton("Cadastrar");
			refreshVacina = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaVacinasCadastrados.setBounds(20, 50, 350, 120);
			listaVacinasCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaVacinasCadastrados.setVisibleRowCount(10);

			cadastroVacina.setBounds(70, 177, 100, 30);
			refreshVacina.setBounds(200, 177, 100, 30);

			j.setLayout(null);

			j.add(titulo);
			j.add(listaVacinasCadastrados);
			j.add(cadastroVacina);
			j.add(refreshVacina);

			j.setSize(400, 250);
			j.setVisible(true);
			j.setLocationRelativeTo(null);

			cadastroVacina.addActionListener(this);
			refreshVacina.addActionListener(this);
			listaVacinasCadastrados.addListSelectionListener(this);

			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção não encontrada!", null, JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Captura eventos relacionados ao JList
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		// Atualiza a lista de nomes das aves mostradas no JList
		if (e.getValueIsAdjusting() && src == listaAvesCadastrados) {
			new TelaDetalheAnimal().inserirEditar(5, dados, this, listaAvesCadastrados.getSelectedIndex());
		}
		// Atualiza a lista de nomes dos cachorros mostrados no JList
		if (e.getValueIsAdjusting() && src == listaCachorrosCadastrados) {
			new TelaDetalheAnimal().inserirEditar(6, dados, this, listaCachorrosCadastrados.getSelectedIndex());
		}
		// Atualiza a lista de nomes dos gatoss mostrados no JList
		if (e.getValueIsAdjusting() && src == listaGatosCadastrados) {
			new TelaDetalheAnimal().inserirEditar(7, dados, this, listaGatosCadastrados.getSelectedIndex());
		}
		// Atualiza a lista de nomes das vacinas mostradas no JList
		if (e.getValueIsAdjusting() && src == listaVacinasCadastrados) {
			new TelaDetalheAnimal().inserirEditar(8, dados, this, listaVacinasCadastrados.getSelectedIndex());
		}

	}

	/**
	 * Captura eventos relacionados aos botões da interface
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		// Cadastro de nova Ave
		if (src == cadastroAve)
			new TelaDetalheAnimal().inserirEditar(1, dados, this, 0);
		// Cadastro novo cachorro
		if (src == cadastroCachorro)
			new TelaDetalheAnimal().inserirEditar(2, dados, this, 0);
		// Cadastro novo gato
		if (src == cadastroGato)
			new TelaDetalheAnimal().inserirEditar(3, dados, this, 0);
		// Cadastro nova vacina
		if (src == cadastroVacina)
			new TelaDetalheAnimal().inserirEditar(4, dados, this, 0);

		// Atualiza a lista de nome de aves
		if (src == refreshAve) {
			listaAvesCadastrados.setListData(new ControleAve(dados).getNomeAve());
			listaAvesCadastrados.updateUI();
		}
		// Atualiza a lista de nome de cachorros
		if (src == refreshCachorro) {
			listaCachorrosCadastrados.setListData(new ControleCachorro(dados).getNomeCachorro());
			listaCachorrosCadastrados.updateUI();
		}
		// Atualiza a lista de nome de gatos
		if (src == refreshGato) {
			listaGatosCadastrados.setListData(new ControleGato(dados).getNomeGato());
			listaGatosCadastrados.updateUI();
		}
		// Atualiza a lista de tipos de vacinas
		if (src == refreshVacina) {
			listaVacinasCadastrados.setListData(new ControleVacina(dados).getTipoVacina());
			listaVacinasCadastrados.updateUI();
		}

	}

}
