package Projeto_OO;

public class Gato extends Animal {
	private boolean unhasCortadas;
	private boolean gostaDeAgua;
	private String tamanhoPelo;
	
	public Gato(String nome ,String raca,double peso,char sexo,boolean unhas,boolean gostaA,String tamanhoPelo) {
		super(nome, raca, peso, sexo);
		unhasCortadas = unhas;
		gostaDeAgua = gostaA;
		this.tamanhoPelo = tamanhoPelo;
		
	}

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

	public boolean getUnhasCortadas() {
		return unhasCortadas;
	}

	public void setUnhasCortadas(boolean unhasCortadas) {
		this.unhasCortadas = unhasCortadas;
	}

	public boolean getGostaDeAgua() {
		return gostaDeAgua;
	}

	public void setGostaDeAgua(boolean gostaDeAgua) {
		this.gostaDeAgua = gostaDeAgua;
	}
	
	public String getTamanhoPelo() {
		return tamanhoPelo;
	}

	public void setTamanhoPelo(String tamanhoPelo) {
		this.tamanhoPelo = tamanhoPelo;
	}
	
	
}
