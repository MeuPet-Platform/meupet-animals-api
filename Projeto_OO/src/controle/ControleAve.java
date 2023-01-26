package controle;
import modelo.*;

/**
 * Controla a classe Ave
 * @author Diego Sousa Leite
 * @since 2022
 * @version 1.0 
 */
public class ControleAve {
	private Ave[] a;
	private int qtdAves;
	
	
	public ControleAve(ControleDados d) {
		a = d.getAves();
		qtdAves = d.getQtdAves();
	}
	
	/**
	 * Armazena os nomes em um vetor de String
	 * @return String, um vetor de string com os nomes
	 */
	public String[] getNomeAve() {
		String [] s = new String[qtdAves];
		for(int i = 0;i<qtdAves;i++) {
			s[i]= a[i].getNome();
		}
		return s;
	}
	public int getQtd() {
		return qtdAves;
	}
	
	public void setQtd(int qtd) {
		this.qtdAves = qtd;
	}
	
	public String getNome(int i) {
		return a[i].getNome();
	}
	
	public String getRaca(int i) {
		return a[i].getRaca();
	}
	
	public Double getPeso(int i) {
		return a[i].getPeso();
	}
	
	public String getSexo(int i) {
		return a[i].getSexo();
	}
	
	public void setQtdGatos(int qtdAves) {
		this.qtdAves = qtdAves;
	}
	
	public String getAsaCortada(int i) {
		return a[i].getAsaCortada();
	}
	
	public String getEmGaiola(int i) {
		return a[i].getEmGaiola();
	}
	
	public String getExotico(int i) {
		return a[i].getExotico();
	}
	
}
