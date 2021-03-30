package data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import file.PokemonFileReader;

/**
 * This implements Pokemon, with a name and a dex number and its types.
 * 
 * @author Yoyovicti
 *
 */
public class Pokemon {
	private int dexNum;
	private Name name;
	private Name type1;
	private Name type2;
	
	public Pokemon(String dataString) {
		if(!dataString.contains(",")) {
			this.name = new Name(dataString);
		}
		else {
			String[] dataTab = dataString.split(",");
			
			dexNum = Integer.parseInt(dataTab[0]);
			name = new Name(dataTab[1], dataTab[2]);
			
			type1 = new Name(dataTab[3], dataTab[5]);
			
			if(dataTab.length > 6) {
				type2 = new Name(dataTab[4], dataTab[6]);
			}
			else {
				type2 = new Name("", "");
			}
		}
		
		
	}
	
	public static List<Pokemon> readData() {
		try {
			PokemonFileReader pkfReader = new PokemonFileReader();
			return pkfReader.getPokeList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String pokemonDataAsString() {
		return dexNum + "\t" + name.toString() + "\t" + type1 + "\t" + type2; 
	}
	
	@Override
	public String toString() {
		return name.toString();
	}
}
