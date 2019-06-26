package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.ArrayList;

public class Cor {
	static int i = 0;
	static ArrayList<String> cores = loadCores();
	
	public static String getCor() {
		int temp = i;
		i = i + 1;
		return cores.get(temp);
	}
	
	static ArrayList<String> loadCores(){
		ArrayList<String> c = new ArrayList<>();
		c.add("blue");
		c.add("gray");
		c.add("yellow");
		c.add("purple");
		c.add("green");
		c.add("pink");
		c.add("black");
		c.add("orange");
		return c;
	}
	
}
