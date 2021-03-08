package data;

public class Form {
	private Name name;
	
	public Form(String name) {
		this.name = new Name(name);
	}
	
	public String toString() {
		return name.toString();
	}
}
