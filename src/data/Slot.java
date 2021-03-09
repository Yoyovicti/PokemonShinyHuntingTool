package data;

public class Slot {
	private Zone parentZone;
	
	private Percentage percentage;
	private Pokemon pokemon;
	private Form form;
	private int level;

	public Slot(String[] slotTab, Percentage percentage) {
		try {
			this.percentage = percentage;
			pokemon = new Pokemon(slotTab[0]);
			form = new Form(slotTab[1]);
			level = Integer.parseInt(slotTab[2]);
		} catch (Exception e) {
			System.err.println("Error : could not create Slot because there are not 3 parameters");
		}
	}

	public Pokemon getPokemon() {
		return pokemon;
	}
	
	public Form getForm() {
		return form;
	}
	
	public int getLevel() {
		return level;
	}

	public Percentage getPercentage() {
		return percentage;
	}
}
