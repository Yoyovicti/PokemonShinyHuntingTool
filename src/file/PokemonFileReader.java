package file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import data.Pokemon;

public class PokemonFileReader {
	final String fileName = "pokedata.csv";
	List<Pokemon> pokeList;
	
	public PokemonFileReader() {
		pokeList = new ArrayList<Pokemon>();
	}

	public List<Pokemon> getPokeList() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF8"));
		
		String line = "";
		while((line = reader.readLine()) != null) {
			pokeList.add(new Pokemon(line));
		}
		
		reader.close();
		return pokeList;
	}

}
