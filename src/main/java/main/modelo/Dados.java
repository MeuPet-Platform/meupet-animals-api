package main.modelo;

import java.util.*;

/**
 * Classe Dados 
 * @author Diego Sousa Leite
 * @since 2022
 * @version 1.0
 */
public class Dados {
	private Ave[] aves = new Ave[50];
	private int qtdAves = 0;
	private Cachorro[] cachorros = new Cachorro[50];
	private int qtdCachorros = 0;
	private Gato[] gatos = new Gato[50];
	private int qtdGatos = 0;
	private Vacina[] vacinas = new Vacina[50];
	private int qtdVacinas = 0;
	
	/**
	 * Atribui uma informação para o respectivo objeto a cada iteração do for
	 * 
	 */
	public void addDados() {
		for(int i =0;i<5;i++) {
			aves[i] = new Ave("Tico"+i,"Papagaio"+i, 10, "Macho","Sim" , "Sim", "Sim","tuberculose1"); 
			cachorros[i] = new Cachorro("Billy"+i,"Shit izu"+i, 10, "Macho","Sim" , "Sim", "Médio","tuberculose3"); 
			gatos[i] = new Gato("Tobias"+i,"Sem raça"+i, 10, "Femea","Sim" , "Sim", "Pequeno","tuberculose4"); 
			vacinas[i] = new Vacina("antirrábica"+i,"12/02/2021", "Sim");
		}
		qtdAves = 5;
		qtdCachorros = 5;
		qtdGatos = 5;
		qtdVacinas = 5;
	}
	
	public Ave[] getAves() {
		return aves;
	}
	public void setAves(Ave[] aves) {
		this.aves = aves;
	}
	
	/**
	 * Metodo para inserir e editar a ave
	 * @param a
	 * @param pos
	 */
	public void inserirEditarAve(Ave a,int pos) {
		this.aves[pos] = a;
		if(pos == qtdAves) qtdAves++;
	}
	public int getQtdAves() {
		return qtdAves;
	}
	public void setQtdAves(int qtdAves) {
		this.qtdAves = qtdAves;
	}
	
	public Cachorro[] getCachorros() {
		return cachorros;
	}
	public void setCachorros(Cachorro[] cachorros) {
		this.cachorros = cachorros;
	}
	/**
	 * Metodo para inserir e editar cachorro
	 * @param c
	 * @param pos
	 */
	public void inserirEditarCachorro(Cachorro c,int pos) {
		this.cachorros[pos] = c;
		if(pos == qtdCachorros) qtdCachorros++;
	}
	public int getQtdCachorros() {
		return qtdCachorros;
	}
	public void setQtdCachorros(int qtdCachorros) {
		this.qtdCachorros = qtdCachorros;
	}
	
	public Gato[] getGatos() {
		return gatos;
	}
	public void setAves(Gato[] gatos) {
		this.gatos = gatos;
	}
	/**
	 * Metodo para inserir e editar gato
	 * @param g
	 * @param pos
	 */
	public void inserirEditarGato(Gato g,int pos) {
		this.gatos[pos] = g;
		if(pos == qtdGatos) qtdGatos++;
	}
	public int getQtdGatos() {
		return qtdGatos;
	}
	public void setQtdGatos(int qtdGatos) {
		this.qtdGatos = qtdGatos;
	}
	
	public Vacina[] getVacinas() {
		return vacinas;
	}
	public void setVacinas(Vacina[] vacinas) {
		this.vacinas = vacinas;
	}
	/**
	 * Metodo para inseir e editar vacina
	 * @param v
	 * @param pos
	 */
	public void inserirEditarVacina(Vacina v,int pos) {
		this.vacinas[pos] = v;
		if(pos == qtdVacinas) qtdVacinas++;
	}
	public int getQtdVacinas() {
		return qtdVacinas;
	}
	public void setQtdVacinas(int qtdVacinas) {
		this.qtdVacinas = qtdVacinas;
	}
	
	
	
	
}
