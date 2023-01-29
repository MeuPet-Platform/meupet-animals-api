package modelo;


/**
 * Classe que representa um Animal, que possui nome,raça,peso e sexo.
 * @author Diego Sousa Leite
 * @since 2022
 * @version 1.0
 */
public abstract class Animal {
	protected String nome;
	protected String raca;
	protected double peso;
	protected String sexo;
	protected String vacinado;

	/**
	 * Construtor Animal
	 * @param nome
	 * @param raca
	 * @param peso
	 * @param sexo
	 * @param vacinado
	 */
	public Animal(String nome, String raca, double peso, String sexo,String vacinado) {
		this.nome = nome;
		this.raca = raca;
		this.peso = peso;
		this.sexo = sexo;
		this.vacinado = vacinado;
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

	public String getVacinado() {
		return vacinado;
	}

	public void setVacinado(String vacinado) {
		this.vacinado = vacinado;
	}

	
}
