package Projeto_OO;

public class Cachorro extends Animal{
	private boolean manso;
	private boolean necessitaFocinheira;
	private String porte;
	
	public Cachorro(String nome ,String raca,double peso,char sexo,boolean manso,boolean focinheira,String porte) {
		super(nome, raca, peso, sexo);
		this.manso = manso;
		necessitaFocinheira = focinheira;
		this.porte = porte;
		
	}
	
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
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public boolean getNecessitaFocinheira() {
		return necessitaFocinheira;
	}

	public void setNecessitaFocinheira(boolean necessitaFocinheira) {
		this.necessitaFocinheira = necessitaFocinheira;
	}
	
	public boolean getManso() {
		return manso;
	}

	public void setManso(boolean manso) {
		this.manso = manso;
	}

	


	
	
}
