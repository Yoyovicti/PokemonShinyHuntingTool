package data;

/**
 * This class implements percentages.
 * 
 * @author Yoyovicti
 *
 */
public class Percentage {
	private int number;
	
	public Percentage(String number) {
		this.number = Integer.parseInt(number);
	}

	@Override
	public String toString() {
		return Integer.toString(number) + " %";
	}
}
