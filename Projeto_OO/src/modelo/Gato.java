package modelo;

/**
 * Classe Gato representa um gato e herda da classe Animal
 * @author Diego Sousa Leite
 * @since 2022
 * @version 1.0
 */
public class Gato extends Animal {
	private String unhasCortadas;
	private String gostaDeAgua;
	private String tamanhoPelo;
	
	/**
	 * Construtor Gato
	 * @param nome
	 * @param raca
	 * @param peso
	 * @param sexo
	 * @param unhas
	 * @param gostaA
	 * @param tamanhoPelo
	 * @param vacinado
	 */
	public Gato(String nome ,String raca,double peso,String sexo,String unhas,String gostaA,
			String tamanhoPelo,String vacinado) {
		super(nome, raca, peso, sexo,vacinado);
		unhasCortadas = unhas;
		gostaDeAgua = gostaA;
		this.tamanhoPelo = tamanhoPelo;
		
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

	public String getUnhasCortadas() {
		return unhasCortadas;
	}

	public void setUnhasCortadas(String unhasCortadas) {
		this.unhasCortadas = unhasCortadas;
	}

	public String getGostaDeAgua() {
		return gostaDeAgua;
	}

	public void setGostaDeAgua(String gostaDeAgua) {
		this.gostaDeAgua = gostaDeAgua;
	}
	
	public String getTamanhoPelo() {
		return tamanhoPelo;
	}

	public void setTamanhoPelo(String tamanhoPelo) {
		this.tamanhoPelo = tamanhoPelo;
	}
	
	/**
	 * Sobrescreve metodo to String() da classes Object. Constroi uma
	 * String contendo o valor de todas as variaveis da classe Gato.
	 * @return String
	 */
	public String toString() {
		return "\nNome do gato: "
				+ nome
				+ "\nRaça : "
				+ raca
				+ "\nPeso : "
				+ peso
				+ " Kg"
				+"\nSexo : "
				+ sexo
				+ "\nPossui unhas cortas: "
				+ unhasCortadas
				+ "\nGosta de água : "
				+ gostaDeAgua
				+ "\nTamanho do pelo: "
				+ tamanhoPelo;
	}
	
}
