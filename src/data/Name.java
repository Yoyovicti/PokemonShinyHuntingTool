package data;

/**
 * Class used to store the name of various elements.
 * In a future update, it will be used to store names in French and English.
 * 
 * @author Yoyovicti
 *
 */
public class Name {
	private String nameFR;
	private String nameEN;
	
	public Name(String nameFR) {
		this.nameFR = nameFR;
	}

	public Name(String fr, String en) {
		nameFR = fr;
		nameEN = en;
	}

	@Override
	public String toString() {
		return nameFR;
	}
}
