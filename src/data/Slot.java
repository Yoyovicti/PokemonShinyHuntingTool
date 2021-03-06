package data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Slot {
	
	private Zone parentZone;
	
	private Pokemon pokemon;
	
	private int index;
	
	/*
	Zone zone;
	int percentage;
	Pokemon pokemon;
	String form;
	int level;
	
	// Create an ES from a String containing pokemon, form and level
	public Slot(Zone zone, String ESString, int lineNum) {
		this.zone = zone;
		this.percentage = readPercentage(lineNum);
		
		List<String> parts = split(ESString);
		
		this.pokemon = new Pokemon(parts.get(0));
		this.form = parts.get(1);
		this.level = Integer.parseInt(parts.get(2));
	}

	private int readPercentage(int lineNum) {
		return zone.readPercentage(lineNum);
	}

	private List<String> split(String ESString) {
		List<String> partsArray = new ArrayList<String>();
		
		String[] partSplit = ESString.split(",");
		for(String str : partSplit) {
			partsArray.add(str);
		}
		
		return partsArray;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	@Override
	public String toString() {
		return pokemon + ", " + form + ", " + level + ", " + percentage + ", " + zone;
	}*/
}
