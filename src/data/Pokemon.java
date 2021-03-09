package data;
import java.util.ArrayList;

public class Pokemon {
	
	private Name name;
	private int dexNum;
	
	public Pokemon(String name) {
		this.name = new Name(name);
	}
	
	@Override
	public String toString() {
		return name.toString();
	}
}
