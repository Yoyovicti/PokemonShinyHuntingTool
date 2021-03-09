package data;

public class Name {
	private String nameFR;
	private String nameEN;
	
	public Name(String nameFR) {
		this.nameFR = nameFR;
	}

	@Override
	public String toString() {
		return nameFR;
	}
}
