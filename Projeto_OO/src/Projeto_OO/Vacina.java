package Projeto_OO;

import java.util.*;

public class Vacina {
	private String tipoVacina;
	private Date dataVacina;
	private boolean revacina;
	
	public Vacina(String vacina,boolean revacina) {
		tipoVacina = vacina;
		this.revacina = revacina;
	}
	
	public String toString() {
		return "\nO tipo da vacina : "
				+ tipoVacina
				+ "\nNecessita de revacina : "
				+ revacina;
	}

	public String getTipoVacina() {
		return tipoVacina;
	}

	public void setTipoVacina(String tipoVacina) {
		this.tipoVacina = tipoVacina;
	}

	public Date getDataVacina() {
		return dataVacina;
	}

	public void setDataVacina(Date dataVacina) {
		this.dataVacina = dataVacina;
	}

	public boolean getRevacina() {
		return revacina;
	}

	public void setRevacina(boolean revacina) {
		this.revacina = revacina;
	}
	
	
	
}
