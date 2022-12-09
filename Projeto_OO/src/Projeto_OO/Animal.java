package Projeto_OO;

public abstract class Animal {
	protected String nome;
	protected String raca;
	protected  double peso;
	protected  char sexo;
	protected Vacina[] vacina = new Vacina[40];
	
	
	public Animal(String nome,String raca,double peso,char sexo) {
		this.nome = nome;
		this.raca = raca;
		this.peso = peso;
		this.sexo = sexo;
	}

	public Vacina[] getVacina() {
		return this.vacina;
	}

	public void setVacina(Vacina[] vacina) {
		this.vacina = vacina;
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
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	
}
