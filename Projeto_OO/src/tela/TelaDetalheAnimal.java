package tela;

import java.awt.Color;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.*;

import controle.*;

/**
 * Implementa uma interface para mostrar os detalhes de cada animal cadastrado e
 * permitir a edição desses dados, além de poder mostrar a interface de cadastro
 * de um novo animal
 * 
 * @author Diego Sousa Leite
 * @version 2022
 * @version 1.0
 */

public class TelaDetalheAnimal implements ActionListener {

	private String opcoes[] = { " ", "Não", "Sim" };
	private String tamanho[] = { " ", "Grande", "Médio", "Pequeno" };
	private String sexo[] = { " ", "Macho", "Fêmea", "Indefinido" };
	private String[] listaTipos = new String[50];
	private JFrame f;
	private JLabel nomeAnimal = new JLabel("Nome: ");
	private JTextField nome = new JTextField();
	private JLabel racaAnimal = new JLabel("Raça: ");
	private JTextField raca = new JTextField();
	private JLabel pesoAnimal = new JLabel("Peso: ");
	private JTextField peso = new JTextField();
	private JLabel sexoAnimal = new JLabel("Sexo: ");
	private JComboBox<String> sexoA = new JComboBox<String>(sexo);
	private JLabel asaCortada = new JLabel("Asas cortadas: ");
	private JComboBox<String> asa = new JComboBox<String>(opcoes);
	private JLabel emGaiola = new JLabel("Vive em gaiola : ");
	private JComboBox<String> gaiola = new JComboBox<String>(opcoes);
	private JLabel aveExotica = new JLabel("Ave é exotica: ");
	private JComboBox<String> exotica = new JComboBox<String>(opcoes);
	private JLabel manso = new JLabel("Manso: ");
	private JComboBox<String> eManso = new JComboBox<String>(opcoes);
	private JLabel necessitaFocinheira = new JLabel("Necessita de focinheira: ");
	private JComboBox<String> necFocinheira = new JComboBox<String>(opcoes);
	private JLabel porteCachorro = new JLabel("Porte do cachorro: ");
	private JComboBox<String> porteDog = new JComboBox<String>(tamanho);
	private JLabel unhasCortadas = new JLabel("Unhas cortadas: ");
	private JComboBox<String> unhas = new JComboBox<String>(opcoes);
	private JLabel gostaDeAgua = new JLabel("Gosta de água : ");
	private JComboBox<String> gostaA = new JComboBox<String>(opcoes);
	private JLabel tamanhoDoPelo = new JLabel("Tamanho do pelo: ");
	private JComboBox<String> tamPelo = new JComboBox<String>(tamanho);
	private JLabel vacinado = new JLabel("Vacinado com:");
	private JComboBox<String> vacina;
	JLabel tipoVacina = new JLabel("Tipo da Vacina: ");
	JTextField tipoV = new JTextField();
	JLabel dataVacina = new JLabel("Data da Vacina: ");
	JTextField dataV = new JTextField();
	JLabel necRevacina = new JLabel("Necessita de revacina: ");
	JComboBox<String> revacina = new JComboBox<String>(opcoes);
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[50];
	private ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;

	/**
	 * Cadastra novos animais e mostra detalhes dos já existentes, permitindo a
	 * edição desses dados
	 * 
	 * @param op,representa a opcao escolhida pelo usuário
	 * @param d
	 * @param a,            permite acesso aos dados dos animais
	 * @param pos,posição   do animal escolhido na JList
	 */
	public void inserirEditar(int op, ControleDados d, TelaAnimal a, int pos) {
		opcao = op;
		posicao = pos;
		dados = d;

		listaTipos = new ControleVacina(dados).getTipoVacina();
		vacina = new JComboBox<String>(listaTipos);

		if (op == 1)
			s = "Cadastro de Ave";
		if (op == 2)
			s = "Cadastro de Cachorro";
		if (op == 3)
			s = "Cadastro de Gato";
		if (op == 4)
			s = "Cadastro de Vacina";
		if (op == 5)
			s = "Detalhe de Ave";
		if (op == 6)
			s = "Detalhe de Cachorro";
		if (op == 7)
			s = "Detalhe de Gato";
		if (op == 8)
			s = "Detalhe de Vacina";

		f = new JFrame(s);

		// Preenche dados com dados da ave clicada
		if (op == 5) {
			nome = new JTextField(d.getAves()[pos].getNome(), 200);
			raca = new JTextField(d.getAves()[pos].getRaca(), 200);
			peso = new JTextField(String.valueOf(d.getAves()[pos].getPeso()));
			sexoA.setSelectedItem(d.getAves()[pos].getSexo());
			asa.setSelectedItem(d.getAves()[pos].getAsaCortada());
			gaiola.setSelectedItem(d.getAves()[pos].getEmGaiola());
			exotica.setSelectedItem(d.getAves()[pos].getExotico());
			vacina.setSelectedItem(d.getAves()[pos].getVacinado());

		}
		// Preenche dados com dados do cachorro clicado
		if (op == 6) {
			nome = new JTextField(d.getCachorros()[pos].getNome(), 200);
			raca = new JTextField(d.getCachorros()[pos].getRaca(), 200);
			peso = new JTextField(String.valueOf(d.getCachorros()[pos].getPeso()));
			sexoA.setSelectedItem(d.getCachorros()[pos].getSexo());
			eManso.setSelectedItem(d.getCachorros()[pos].getManso());
			necFocinheira.setSelectedItem(d.getCachorros()[pos].getNecessitaFocinheira());
			porteDog.setSelectedItem(d.getCachorros()[pos].getPorte());
			vacina.setSelectedItem(d.getCachorros()[pos].getVacinado());
		}
		// Preenche dados com dados do gato clicado
		if (op == 7) {
			nome = new JTextField(d.getGatos()[pos].getNome(), 200);
			raca = new JTextField(d.getGatos()[pos].getRaca(), 200);
			peso = new JTextField(String.valueOf(d.getGatos()[pos].getPeso()));
			sexoA.setSelectedItem(d.getCachorros()[pos].getSexo());
			unhas.setSelectedItem(d.getGatos()[pos].getUnhasCortadas());
			gostaA.setSelectedItem(d.getGatos()[pos].getGostaDeAgua());
			tamPelo.setSelectedItem(d.getGatos()[pos].getTamanhoPelo());
			vacina.setSelectedItem(d.getGatos()[pos].getVacinado());
		}
		// Preenche dados com dados da vacina clicada
		if (op == 8) {
			tipoV = new JTextField(d.getVacinas()[pos].getTipoVacina(), 200);
			dataV = new JTextField(d.getVacinas()[pos].getDataVacina(), 200);
			revacina.setSelectedItem(d.getVacinas()[pos].getRevacina());
		}

		if (op == 5 || op == 6 || op == 7 || op == 8) {
			botaoSalvar.setBounds(330, 250, 150, 30);
			botaoExcluir.setBounds(200, 250, 150, 30);
			this.f.add(botaoExcluir);
		}

		f.setBackground(Color.cyan);
		f.setSize(600, 350);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setLayout(null);

		nomeAnimal.setBounds(10, 10, 150, 30);
		nome.setBounds(150, 10, 330, 30);
		racaAnimal.setBounds(10, 40, 150, 30);
		raca.setBounds(150, 40, 330, 30);
		pesoAnimal.setBounds(10, 70, 150, 30);
		peso.setBounds(150, 70, 330, 30);
		sexoAnimal.setBounds(10, 100, 150, 30);
		sexoA.setBounds(150, 100, 330, 30);
		asaCortada.setBounds(10, 130, 150, 30);
		asa.setBounds(150, 130, 330, 30);
		emGaiola.setBounds(10, 160, 150, 30);
		gaiola.setBounds(150, 160, 330, 30);
		aveExotica.setBounds(10, 190, 150, 30);
		exotica.setBounds(150, 190, 330, 30);
		unhasCortadas.setBounds(10, 130, 150, 30);
		unhas.setBounds(150, 130, 330, 30);
		gostaDeAgua.setBounds(10, 160, 150, 30);
		gostaA.setBounds(150, 160, 330, 30);
		tamanhoDoPelo.setBounds(10, 190, 150, 30);
		tamPelo.setBounds(150, 190, 330, 30);
		manso.setBounds(10, 130, 150, 30);
		eManso.setBounds(150, 130, 330, 30);
		necessitaFocinheira.setBounds(10, 160, 150, 30);
		necFocinheira.setBounds(150, 160, 330, 30);
		porteCachorro.setBounds(10, 190, 150, 30);
		porteDog.setBounds(150, 190, 330, 30);
		tipoVacina.setBounds(10, 10, 150, 30);
		tipoV.setBounds(150, 10, 330, 30);
		dataVacina.setBounds(10, 40, 150, 30);
		dataV.setBounds(150, 40, 330, 30);
		necRevacina.setBounds(10, 70, 150, 30);
		revacina.setBounds(150, 70, 330, 30);
		botaoSalvar.setBounds(300, 265, 150, 30);
		botaoExcluir.setBounds(100, 265, 150, 30);
		vacinado.setBounds(10, 220, 150, 30);
		vacina.setBounds(150, 220, 330, 30);
		

		if (op == 1 || op == 5) {
			this.f.add(asaCortada);
			this.f.add(asa);
			this.f.add(emGaiola);
			this.f.add(gaiola);
			this.f.add(aveExotica);
			this.f.add(exotica);
			this.f.add(vacinado);
			this.f.add(vacina);
		}

		if (op == 2 || op == 6) {
			this.f.add(manso);
			this.f.add(eManso);
			this.f.add(necessitaFocinheira);
			this.f.add(necFocinheira);
			this.f.add(porteCachorro);
			this.f.add(porteDog);
			this.f.add(vacinado);
			this.f.add(vacina);
		}

		if (op == 3 || op == 7) {
			this.f.add(unhasCortadas);
			this.f.add(unhas);
			this.f.add(gostaDeAgua);
			this.f.add(gostaA);
			this.f.add(tamanhoDoPelo);
			this.f.add(tamPelo);
			this.f.add(vacinado);
			this.f.add(vacina);
		}

		if (op == 4 || op == 8) {
			this.f.add(tipoVacina);
			this.f.add(tipoV);
			this.f.add(dataVacina);
			this.f.add(dataV);
			this.f.add(necRevacina);
			this.f.add(revacina);
			this.f.add(botaoSalvar);
			this.f.add(botaoExcluir);
		} else {
			this.f.add(nomeAnimal);
			this.f.add(nome);
			this.f.add(racaAnimal);
			this.f.add(raca);
			this.f.add(pesoAnimal);
			this.f.add(peso);
			this.f.add(sexoAnimal);
			this.f.add(sexoA);
			this.f.add(botaoSalvar);
			this.f.add(botaoExcluir);

		}

		this.f.setBackground(Color.cyan);
		this.f.setSize(550, 350);
		this.f.setVisible(true);
		this.f.setLocationRelativeTo(null);
		this.f.setLayout(null);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == botaoSalvar) {
			try {
				boolean res = false;
				if (opcao == 1)
					novoDado[0] = Integer.toString(dados.getQtdAves());
				else if (opcao == 2)
					novoDado[0] = Integer.toString(dados.getQtdCachorros());
				else if (opcao == 3)
					novoDado[0] = Integer.toString(dados.getQtdGatos());
				else if (opcao == 4)
					novoDado[0] = Integer.toString(dados.getQtdVacinas());
				else
					novoDado[0] = Integer.toString(posicao);

				if (opcao == 1 || opcao == 5) {
					novoDado[1] = nome.getText();
					novoDado[2] = raca.getText();
					novoDado[3] = peso.getText();
					novoDado[4] = (String) sexoA.getSelectedItem();
					novoDado[5] = (String) asa.getSelectedItem();
					novoDado[6] = (String) gaiola.getSelectedItem();
					novoDado[7] = (String) exotica.getSelectedItem();
					novoDado[8] = (String) vacina.getSelectedItem();
					res = dados.inserirEditarAve(novoDado);
				} else if (opcao == 2 || opcao == 6) {
					novoDado[1] = nome.getText();
					novoDado[2] = raca.getText();
					novoDado[3] = peso.getText();
					novoDado[4] = (String) sexoA.getSelectedItem();
					novoDado[5] = (String) eManso.getSelectedItem();
					novoDado[6] = (String) necFocinheira.getSelectedItem();
					novoDado[7] = (String) porteDog.getSelectedItem();
					novoDado[8] = (String) vacina.getSelectedItem();
					res = dados.inserirEditarCachorro(novoDado);
				} else if (opcao == 3 || opcao == 7) {
					novoDado[1] = nome.getText();
					novoDado[2] = raca.getText();
					novoDado[3] = peso.getText();
					novoDado[4] = (String) sexoA.getSelectedItem();
					novoDado[5] = (String) unhas.getSelectedItem();
					novoDado[6] = (String) gostaA.getSelectedItem();
					novoDado[7] = (String) tamPelo.getSelectedItem();
					novoDado[8] = (String) vacina.getSelectedItem();
					res = dados.inserirEditarGato(novoDado);
				} else {
					novoDado[1] = tipoV.getText();
					novoDado[2] = dataV.getText();
					novoDado[3] = (String) revacina.getSelectedItem();
					res = dados.inserirEditarVacina(novoDado);

				}

				if (res) {
					mensagemSucessoCadastro();
				} else
					mensagemErroCadastro();
			} catch (NumberFormatException exc1) {
				mensagemErroCadastro();
			}
		}

		if (src == botaoExcluir) {
			boolean res = false;

			if (opcao == 5) {// exclui ave
				res = dados.removerAve(posicao);
				if (res)
					mensagemSucessoExclusao();
				else
					mensagemErroExclusaoAve();
			}

			if (opcao == 6) { // exclui cachorro
				res = dados.removerCachorro(posicao);
				if (res)
					mensagemSucessoExclusao();
				else
					mensagemErroExclusaoCachorro();
			}
			if (opcao == 7) { // exclui gato
				res = dados.removerGato(posicao);
				if (res)
					mensagemSucessoExclusao();
				else
					mensagemErroExclusaoGato();
			}
			if (opcao == 8) { // exclui vacina
				res = dados.removerVacina(posicao);
				if (res)
					mensagemSucessoExclusao();
				else
					mensagemErroExclusaoVacina();
			}
		}

	}

	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null,
				JOptionPane.INFORMATION_MESSAGE);
		f.dispose();
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
				JOptionPane.INFORMATION_MESSAGE);
		f.dispose();
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null, "ERRO AO SALVAR OS DADOS!\n ", null, JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroExclusaoAve() {
		JOptionPane.showMessageDialog(null,
				"Ocorreu um erro ao excluir o dado.\n " + "Verifique se a Ave está cadastrada\n", null,
				JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroExclusaoCachorro() {
		JOptionPane.showMessageDialog(null,
				"Ocorreu um erro ao excluir o dado.\n " + "Verifique se o Cachorro está cadastrado\n", null,
				JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroExclusaoGato() {
		JOptionPane.showMessageDialog(null,
				"Ocorreu um erro ao excluir o dado.\n " + "Verifique se o Gato está cadastrado\n", null,
				JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroExclusaoVacina() {
		JOptionPane.showMessageDialog(null,
				"Ocorreu um erro ao excluir o dado.\n " + "Verifique se a Vacina está cadastrada\n", null,
				JOptionPane.ERROR_MESSAGE);
	}

}
