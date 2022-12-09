package Projeto_OO;

public class Ave extends Animal {
	private boolean asaCortada ;
	private boolean emGaiola ;
	private boolean exotico;
	
	public Ave( String nome ,String raca,double peso,char sexo,boolean asaC, boolean gaiola,boolean exotico) {
		super(nome, raca, peso, sexo);
		asaCortada = asaC;
		emGaiola = gaiola;
		this.setExotico(exotico);
	}
	
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
	
	public boolean getAsaCortada() {
		return asaCortada;
	}

	public void setAsaCortada(boolean asaCortada) {
		this.asaCortada = asaCortada;
	}

	public boolean getEmGaiola() {
		return emGaiola;
	}

	public void setEmGaiola(boolean emGaiola) {
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
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public boolean isExotico() {
		return exotico;
	}

	public void setExotico(boolean exotico) {
		this.exotico = exotico;
	}


}
