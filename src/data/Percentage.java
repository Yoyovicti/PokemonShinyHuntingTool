package data;

public class Percentage {
	private int number;
	
	public Percentage(String number) {
		this.number = Integer.parseInt(number);
		System.out.println(this);
	}

	@Override
	public String toString() {
		return Integer.toString(number) + " %";
	}
}
