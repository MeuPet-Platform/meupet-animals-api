package com.meupet.api.controle;
import main.modelo.*;

/**
 * Controla a classe Cachorro
 * @author Diego Sousa Leite
 * @since 2022
 * @version 1.0 
 */
public class ControleCachorro {
	private Cachorro[] c;
	private int qtdCachorros;
	
	public ControleCachorro(ControleDados d) {
		c = d.getCachorros();
		qtdCachorros = d.getQtdCachorros();
	}
	
	/**
	 * Armazena os nomes em um vetor de String
	 * @return String, um vetor de string com os nomes
	 */
	public String[] getNomeCachorro() {
		String [] s = new String[qtdCachorros];
		for(int i = 0;i<qtdCachorros;i++) {
			s[i] = c[i].getNome();
		}
		return s;
	}
	
	public int getQtd() {
		return qtdCachorros;
	}
	
	public void setQtd(int qtd) {
		this.qtdCachorros = qtd;
	}
	
	public String getNome(int i) {
		return c[i].getNome();
	}
	
	public String getPorte(int i) {
		return c[i].getPorte();
	}
	
	public String getRaca(int i) {
		return c[i].getRaca();
	}
	
	public Double getPeso(int i) {
		return c[i].getPeso();
	}
	
	public String getSexo(int i) {
		return c[i].getSexo();
	}
	
	public String getNecessitaFocinheira(int i) {
		return c[i].getNecessitaFocinheira();
	}
	
	public String getVacinado(int i) {
		return c[i].getVacinado();
	}
	
	public void setQtdCachorros(int qtdCachorros) {
		this.qtdCachorros = qtdCachorros;
	}
	
	
}

