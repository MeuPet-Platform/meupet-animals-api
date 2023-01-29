package controle;
import modelo.*;
/**
 * Controla a classe Gato
 * @author Diego Sousa Leite
 * @since 2022
 * @version 1.0 
 */
public class ControleGato {
	private Gato[] g;
	private int qtdGatos;
	
	public ControleGato(ControleDados d) {
		g = d.getGatos();
		qtdGatos = d.getQtdGatos();
	}
	
	/**
	 * Armazena os nomes em um vetor de String
	 * @return String, um vetor de string com os nomes
	 */
	public String[] getNomeGato() {
		String [] s = new String[qtdGatos];
		for(int i = 0;i<qtdGatos;i++) {
			s[i]= g[i].getNome();
		}
		return s;
	}
	
	public int getQtd() {
		return qtdGatos;
	}
	
	public void setQtd(int qtd) {
		this.qtdGatos = qtd;
	}
	
	public String getNome(int i) {
		return g[i].getNome();
	}
	
	public String getRaca(int i) {
		return g[i].getRaca();
	}
	
	public Double getPeso(int i) {
		return g[i].getPeso();
	}
	
	public String getSexo(int i) {
		return g[i].getSexo();
	}
	
	public void setQtdGatos(int qtdGatos) {
		this.qtdGatos = qtdGatos;
	}
	
	public String getUnhasCortadas(int i) {
		return g[i].getUnhasCortadas();
	}
	
	public String getGostaDeAgua(int i) {
		return g[i].getGostaDeAgua();
	}
	
	public String getTamanhoPelo(int i) {
		return g[i].getTamanhoPelo();
	}
	
	public String getVacinado(int i) {
		return g[i].getVacinado();
	}
}
