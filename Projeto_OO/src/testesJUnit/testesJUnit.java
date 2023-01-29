package testesJUnit;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import controle.ControleDados;
/**
 * Implementa testes unitarios de validação
 * @author Diego Sousa Leite
 * @version 2022
 * @version 1.0 
 */
class testesJUnit {
	
	ControleDados dados = new ControleDados();
	String[] novoDado = new String[13];
	
	
	
	/**
	 * Verifica se o método em questão está funcionando corretamente, 
	 * dado os parametros
	 * @return void
	 */
	@Test
	void testEncontrarCachorro() {
		assertEquals(0,dados.encontrarGato("Tobias0"));
	}
	/**
	 * Verifica se o parametro 4,representa a possição do cliente da array,
	 * funciona para o método em questão
	 * @return void
	 */
	@Test
	void testDeletarAve() {
		assertTrue(dados.removerAve(4));
	}
	
	/**
	 * Verifica se o parametro novoDado, representa novos dados para um objeto 
	 * vacina funciona para o método em questão 
	 * @return void
	 */
	@Test
	void testInserirEditarVacina() {
		novoDado[0] = "0";
		novoDado[1] =  "Giardia";
		novoDado[2] =  "12/02/2023";
		novoDado[3] =  "Sim";
		assertTrue(dados.inserirEditarVacina(novoDado));
		
	}
	
	
	
}
