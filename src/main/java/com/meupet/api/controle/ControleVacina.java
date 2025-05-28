package com.meupet.api.controle;
import main.modelo.*;

/**
 * Controla a classe Vacina
 * @author Diego Sousa Leite
 * @since 2022
 * @version 1.0 
 */
public class ControleVacina {
	private Vacina[] v;
	private int qtdVacinas;
	
	public ControleVacina(ControleDados d) {
		v = d.getVacinas();
		qtdVacinas = d.getQtdVacinas();
	}

	/**
	 * Armazena os nomes em um vetor de String
	 * @return String, um vetor de string com os nomes
	 */
	public String[] getTipoVacina() {
		String [] s = new String[qtdVacinas];
		for(int i = 0;i<qtdVacinas;i++) {
			s[i]= v[i].getTipoVacina();
		}
		return s;
	}
	
	public int getQtd() {
		return qtdVacinas;
	}
	
	public void setQtd(int qtd) {
		this.qtdVacinas = qtd;
	}
	
	public String getTipoVacina(int i) {
		return v[i].getTipoVacina();
	}
	
	public String getDataVacina(int i) {
		return v[i].getDataVacina();
	}
	
	public String getRevacina(int i) {
		return v[i].getRevacina();
	}
	
	
	

	
	
}
