package data;

/**
 * This class is used to store alternate forms of Pokemon.
 * 
 * @author Yoyovicti
 *
 */
public class Form {
	private Name name;
	
	public Form(String name) {
		this.name = new Name(name);
	}
	
	public String toString() {
		return name.toString();
	}
}
