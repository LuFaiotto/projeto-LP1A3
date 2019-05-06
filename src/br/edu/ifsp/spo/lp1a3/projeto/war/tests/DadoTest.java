package br.edu.ifsp.spo.lp1a3.projeto.war.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Dado;

class DadoTest {
	//1. Configuração
	//2. Execução
	//3. Asserção

	@Test
	void dado_deve_retornar_numero_entre_1_e_6(){
		//1. Configuração
		Dado dice = new Dado(6);
		int maior_que_6 = 0;
		int menor_que_1 = 0;
		int rolagem = 0;
		//2. Execução
		for(int i = 0; i <= 5000; i++){
			rolagem = dice.rolarDado();
			if(rolagem > 6) {
				maior_que_6++;
			} else if(rolagem < 1) {
				menor_que_1++;
			}
		}
		//3. Asserção
		assertEquals(maior_que_6, 0);
		assertEquals(menor_que_1, 0);
	}

}
