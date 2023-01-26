package modelo;

/**
 * Classe Cachorro representa um cachorro e herda da classe Animal
 * @author Diego Sousa Leite
 * @since 2022
 * @version 1.0
 */
public class Cachorro extends Animal{
	private String manso;
	private String necessitaFocinheira;
	private String porte;
	
	/**
	 * Construtor Cachorro
	 * @param nome
	 * @param raca
	 * @param peso
	 * @param sexo
	 * @param manso
	 * @param focinheira
	 * @param porte
	 */
	public Cachorro(String nome ,String raca,double peso,String sexo,String manso,String focinheira,String porte) {
		super(nome, raca, peso, sexo);
		this.manso = manso;
		necessitaFocinheira = focinheira;
		this.porte = porte;
		
	}
	
	
	

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
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
	
	public String getNecessitaFocinheira() {
		return necessitaFocinheira;
	}

	public void setNecessitaFocinheira(String necessitaFocinheira) {
		this.necessitaFocinheira = necessitaFocinheira;
	}
	
	public String getManso() {
		return manso;
	}

	public void setManso(String manso) {
		this.manso = manso;
	}

	/**
	 * Sobrescreve metodo to String() da classes Object. Constroi uma
	 * String contendo o valor de todas as variaveis da classe Cachorro.
	 * @return String
	 */
	public String toString() {
		return "\nNome do cachorro: "
				+ nome
				+ "\nRaça : "
				+ raca
				+ "\nPeso : "
				+ peso
				+ " Kg"
				+"\nSexo : "
				+ sexo
				+ "\nManso : "
				+ manso
				+ "\nNecessita de focinheira para passear : "
				+ necessitaFocinheira
				+ "\nPorte : "
				+ porte;
	}


	
	
}
