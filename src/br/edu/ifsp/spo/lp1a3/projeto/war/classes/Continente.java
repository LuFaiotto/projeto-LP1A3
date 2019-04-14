package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.Collection;
import java.util.HashSet;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.*;

public class Continente {
	
	private String nome;
	private Collection<Pais> paises = new HashSet<>();
	private Collection<Continente> conexoes = new HashSet<>();
}
