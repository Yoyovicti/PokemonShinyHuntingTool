package data;
import java.util.ArrayList;

/**
 * This implements Pokemon, with a name and a dex number and its types.
 * 
 * @author Yoyovicti
 *
 */
public class Pokemon {
	private Name name;
	private int dexNum;
	private String[] types;
	
	public Pokemon(String name) {
		this.name = new Name(name);
	}
	
	@Override
	public String toString() {
		return name.toString();
	}
}
