package main.modelo;
/**
 * Classe Ave representa uma ave e herda da classe Animal
 * @author Diego Sousa Leite
 * @since 2022
 * @version 1.0
 */
public class Ave extends Animal {
	private String asaCortada ;
	private String emGaiola ;
	private String exotico;
	
	/**
	 * Construtor Ave 
	 * @param nome
	 * @param raca
	 * @param peso
	 * @param sexo
	 * @param asaC
	 * @param gaiola
	 * @param exotico
	 * @param vacinado
	 */
	public Ave( String nome ,String raca,double peso,String sexo,String asaC, String gaiola,
			String exotico,String vacinado) {
		super(nome, raca, peso, sexo,vacinado);
		asaCortada = asaC;
		emGaiola = gaiola;
		this.setExotico(exotico);
		
	}
	
	public String getAsaCortada() {
		return asaCortada;
	}

	public void setAsaCortada(String asaCortada) {
		this.asaCortada = asaCortada;
	}

	public String getEmGaiola() {
		return emGaiola;
	}

	public void setEmGaiola(String emGaiola) {
		this.emGaiola = emGaiola;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRaca() {
		return raca;
	}
	
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getExotico() {
		return exotico;
	}

	public void setExotico(String exotico) {
		this.exotico = exotico;
	}
	
	/**
	 * Sobrescreve metodo to String() da classe Object. Constroi uma
	 * String contendo o valor de todas as variaveis da classe Ave.
	 * @return String
	 */
	public String toString( ) {
		return "\nNome da Ave: "
				+ nome
				+ "\nRaça : "
				+ raca
				+ "\nPeso : "
				+ peso
				+ " Kg"
				+"\nSexo : "
				+ sexo
				+ "\nPossui a asa cortada : "
				+ asaCortada
				+ "\nVive em gaiola : "
				+ emGaiola
				+ "\nÉ exótico : "
				+ exotico;
	}


	public boolean isExotico() {
		return false;
	}
}
