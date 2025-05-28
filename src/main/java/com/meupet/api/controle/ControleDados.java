package com.meupet.api.controle;
import com.meupet.api.modelo.*;
import main.modelo.*;

public class ControleDados {
	private Dados d = new Dados();
	
	public ControleDados() {
		d.addDados();
		
	}
	
	public Dados getDados() {
		return d;
	}
	
	public void setDados(Dados d) {
		this.d = d;
	}
	
	public Ave[] getAves() {
		return this.d.getAves();
	}
	
	public int getQtdAves() {
		return this.d.getQtdAves();	
	}
	
	public  Cachorro[] getCachorros() {
		return this.d.getCachorros();
	}
	
	public int getQtdCachorros() {
		return this.d.getQtdCachorros();
	}
	
	public Gato[] getGatos() {
		return this.d.getGatos();
	}
	
	public int getQtdGatos() {
		return this.d.getQtdGatos();
	}
	
	public Vacina[] getVacinas() {
		return this.d.getVacinas();
	}
	
	public int getQtdVacinas() {
		return this.d.getQtdVacinas();
	}
	
	/**
	 * Cadastra nova ave ou edita um ja existente
	 * @param dadosAves que contem a ave a ser inserida ou criada
	 * @return boolean, true indicando que a operação foi bem sucedida
	 */
	public boolean inserirEditarAve(String[] dadosAves) {
	
			Ave a = new Ave(dadosAves[1],dadosAves[2], 
					Double.parseDouble(dadosAves[3]),dadosAves[4],
					dadosAves[5],dadosAves[6],dadosAves[7],dadosAves[8]);
			d.inserirEditarAve(a, Integer.parseInt(dadosAves[0]));
			return true;
	
	}
	
	/**
	 * Cadastra novo gato ou edita um ja existente
	 * @param dadosGatos que contem o gato a ser inserido ou criado
	 * @return boolean, true indicando que a operação foi bem sucedida
	 */
	public boolean inserirEditarGato(String[] dadosGatos) {

			Gato g = new Gato(dadosGatos[1], dadosGatos[2], 
					Double.parseDouble(dadosGatos[3]), dadosGatos[4],
					dadosGatos[5],dadosGatos[6],dadosGatos[7],dadosGatos[8]);
			d.inserirEditarGato(g, Integer.parseInt(dadosGatos[0]));
			return true;
		
	}
	
	/**
	 * Cadastra novo cachorro ou edita um ja existente
	 * @param dadosCachorros que contem o cachorro a ser inserido ou criado
	 * @return boolean, true indicando que a operação foi bem sucedida
	 */
	public boolean inserirEditarCachorro(String[] dadosCachorros) {
		
			Cachorro c = new Cachorro(dadosCachorros[1], dadosCachorros[2], 
					Double.parseDouble(dadosCachorros[3]), dadosCachorros[4],
					dadosCachorros[5],dadosCachorros[6],dadosCachorros[7],
					dadosCachorros[8]);
			d.inserirEditarCachorro(c, Integer.parseInt(dadosCachorros[0]));
			return true;
	
	}
	
	/**
	 * Cadastra nova vacina ou edita uma ja existente
	 * @param dadosVacinas que contem a vacina a ser inserida ou criada
	 * @return boolean, true indicando que a operação foi bem sucedida
	 */
	public boolean inserirEditarVacina(String[] dadosVacinas) {
	
			Vacina v = new Vacina(dadosVacinas[1],dadosVacinas[2], 
					dadosVacinas[3]);
			d.inserirEditarVacina(v, Integer.parseInt(dadosVacinas[0]));
			return true;
		
	}
	
	/**
	 * Deleta a ave escolhida
	 * @param i, que indica a posicao da ave no array
	 * @return, true indicando que a operação foi bem sussedida
	 */
	public boolean removerAve(int i) {
		String aveRemovida =  d.getAves()[i].getNome();
		
		if(i == (d.getQtdAves()-1)) {//A ave que vai ser removida esta no final do array
			d.setQtdAves(d.getQtdAves()-1);
			d.getAves()[d.getQtdAves()] = null;
			return true;
		}else {//a ave a ser removido esta no meio do array
			int cont = 0;
			while(d.getAves()[cont].getNome().compareTo(aveRemovida)!= 0) {
				cont++;
			}
			
			for(int j = cont;j<d.getQtdAves() - 1;j++) {
				d.getAves()[j] = null;
				d.getAves()[j] = d.getAves()[j+1];
			}
			d.getAves()[d.getQtdAves()] = null;
			d.setQtdAves(d.getQtdAves()-1);
			return true;
		}
	}
	
	/**
	 * Deleta o cachorro escolhido
	 * @param i, que indica a posicao do cachorro no array
	 * @return, true indicando que a operação foi bem sussedida
	 */
	public boolean removerCachorro(int i) {
		String cachorroRemovido =  d.getCachorros()[i].getNome();
		
		if(i == (d.getQtdCachorros()-1)) {//O Cachorro que vai ser removida esta no final do array
			d.setQtdCachorros(d.getQtdCachorros()-1);
			d.getCachorros()[d.getQtdCachorros()] = null;
			return true;
		}else {//o Cachorro a ser removido esta no meio do array
			int cont = 0;
			while(d.getCachorros()[cont].getNome().compareTo(cachorroRemovido)!= 0) {
				cont++;
			}
			
			for(int j = cont;j<d.getQtdCachorros() - 1;j++) {
				d.getCachorros()[j] = null;
				d.getCachorros()[j] = d.getCachorros()[j+1];
			}
			d.getCachorros()[d.getQtdCachorros()] = null;
			d.setQtdCachorros(d.getQtdCachorros()-1);
			return true;
		}
	}
	
	/**
	 * Deleta o gato escolhido
	 * @param i, que indica a posicao do gato no array
	 * @return, true indicando que a operação foi bem sussedida
	 */
	public boolean removerGato(int i) {
		String gatoRemovido =  d.getGatos()[i].getNome();
		
		if(i == (d.getQtdGatos()-1)) {//O Gato que vai ser removida esta no final do array
			d.setQtdGatos(d.getQtdGatos()-1);
			d.getGatos()[d.getQtdGatos()] = null;
			return true;
		}else {//o Gato a ser removido esta no meio do array
			int cont = 0;
			while(d.getGatos()[cont].getNome().compareTo(gatoRemovido)!= 0) {
				cont++;
			}
			
			for(int j = cont;j<d.getQtdGatos() - 1;j++) {
				d.getGatos()[j] = null;
				d.getGatos()[j] = d.getGatos()[j+1];
			}
			d.getGatos()[d.getQtdGatos()] = null;
			d.setQtdGatos(d.getQtdGatos()-1);
			return true;
		}
	}
		
	/**
	 * Deleta a vacina escolhida
	 * @param i, que indica a posicao da vacinao no array
	 * @return, true indicando que a operação foi bem sussedida
	 */
	public boolean removerVacina(int i) {
		String vacinaRemovida =  d.getVacinas()[i].getTipoVacina();
			
		if(i == (d.getQtdVacinas()-1)) {//A Vacina que vai ser removida esta no final do array
			d.setQtdVacinas(d.getQtdVacinas()-1);
			d.getVacinas()[d.getQtdVacinas()] = null;
			return true;
		}else {//a Vacina a ser removido esta no meio do array
			int cont = 0;
			while(d.getVacinas()[cont].getTipoVacina().compareTo(vacinaRemovida)!= 0) {
				cont++;
			}
				
			for(int j = cont;j<d.getQtdVacinas() - 1;j++) {
				d.getVacinas()[j] = null;
				d.getVacinas()[j] = d.getVacinas()[j+1];
			}
			d.getVacinas()[d.getQtdVacinas()] = null;
			d.setQtdVacinas(d.getQtdVacinas()-1);
			return true;
			}
		
	}
	
	/**
	 * Compara o nome recebido com os cadastrados para achar a ave
	 * @param nome,representa o nome digitado pelo usuario
	 * @return int,indica a posição do animal com o nome indicado
	 */
	public int encontrarAve(String nome) {
		int aveSelecionada = 0;
		for(int i = 0;i<d.getQtdAves();i++) {
			if(d.getAves()[i].getNome().equals(nome)) {
				aveSelecionada = i;
				return aveSelecionada;
			}
		}
		
		return 99999;
		
	}
	
	/**
	 * Compara o nome recebido com os cadastrados para achar o cachorro
	 * @param nome,representa o nome digitado pelo usuario
	 * @return int,indica a posição do animal com o nome indicado
	 */
	public int encontrarCachorro(String nome) {
		int cachorroSelecionado = 0;
		for(int i = 0;i<d.getQtdCachorros();i++) {
			if(d.getCachorros()[i].getNome().equals(nome)) {
				cachorroSelecionado = i;
				return cachorroSelecionado;
			}
		}
		
		return 99999;	
	}
	
	/**
	 * Compara o nome recebido com os cadastrados para achar o gato
	 * @param nome,representa o nome digitado pelo usuario
	 * @return int,indica a posição do animal com o nome indicado
	 */
	public int encontrarGato(String nome) {
		int gatoSelecionado = 0;
		for(int i = 0;i<d.getQtdGatos();i++) {
			if(d.getGatos()[i].getNome().equals(nome)) {
				gatoSelecionado = i;
				return gatoSelecionado;
			}
		}
		
		return 99999;
		
	}
	/**
	 * Compara o nome recebido com os cadastrados para achar a vacina
	 * @param nome,representa o nome digitado pelo usuario
	 * @return int,indica a posição do animal com o nome indicado
	 */
	public int encontrarVacina(String nome) {
		int vacinaSelecionada = 0;
		for(int i = 0;i<d.getQtdVacinas();i++) {
			if(d.getVacinas()[i].getTipoVacina().equals(nome)) {
				vacinaSelecionada = i;
				return vacinaSelecionada;
			}
		}
		
		return 99999;
		
	}
	
	
	
	
	
}
