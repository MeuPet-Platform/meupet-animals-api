package modelo;

import java.util.*;

/**
 * Classe Vacina representa uma vacina
 * @author Diego Sousa Leite
 * @since 2022
 * @version 1.0
 */
public class Vacina {
	private String tipoVacina;
	private String dataVacina;
	private String revacina;
	
	/**
	 * Construtor Vacina
	 * @param vacina
	 * @param revacina
	 * @param dataVacina
	 */
	public Vacina(String vacina,String dataVacina,String revacina) {
		tipoVacina = vacina;
		this.dataVacina = dataVacina;
		this.revacina = revacina;
	}
	
	
	public String getTipoVacina() {
		return tipoVacina;
	}

	public void setTipoVacina(String tipoVacina) {
		this.tipoVacina = tipoVacina;
	}

	public String getDataVacina() {
		return dataVacina;
	}

	public void setDataVacina(String dataVacina) {
		this.dataVacina = dataVacina;
	}

	public String getRevacina() {
		return revacina;
	}

	public void setRevacina(String revacina) {
		this.revacina = revacina;
	}
	
	/**
	 * Sobrescreve metodo to String() da classes Object. Constroi uma
	 * String contendo o valor de todas as variaveis da classe Vacina.
	 * @return String
	 */
	public String toString() {
		return "\nO tipo da vacina : "
				+ tipoVacina
				+ "\nNecessita de revacina : "
				+ revacina;
	}

	
	

	
	
}
