package display;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Form;
import data.Percentage;
import data.Pokemon;
import data.Slot;

public class SlotPanel extends JPanel{
	
	private SlotListPanel parentSlotPanel;
	
	private JLabel percLabel;
	private JLabel pokemonLabel;
	private JLabel formLabel;
	private JLabel levelLabel;
	
	private Slot slot;

	public SlotPanel(String title) {
		super();
		String[] titleElems = title.split(",");
		
		createLabels(titleElems);
		
		setPreferredSizes();
		addLabels();
	}

	public SlotPanel(SlotListPanel parent, int index) {
		super();
		this.parentSlotPanel = parent;
		
		this.slot = parentSlotPanel.getSlot(index);
		
		if(slot != null) {
			Percentage percentage = slot.getPercentage();
			Pokemon pokemon = slot.getPokemon();
			Form form = slot.getForm();
			int level = slot.getLevel();
			
			createLabels(
					percentage.toString(), 
					pokemon.toString(), 
					form.toString(), 
					Integer.toString(level));
		}
		else {
			createLabels("null", "null", "null", "null");
		}
		
		setPreferredSizes();
		addLabels();
	}

	public void createLabels(String ...labelStrings) {
		percLabel = createLabel(labelStrings[0]);
		pokemonLabel = createLabel(labelStrings[1]);
		formLabel = createLabel(labelStrings[2]);
		levelLabel = createLabel(labelStrings[3]);
	}

	private JLabel createLabel(String name) {
		return new JLabel(name, JLabel.CENTER);
	}

	protected void setPreferredSizes() {
		percLabel.setPreferredSize(new Dimension(100, 40));
		pokemonLabel.setPreferredSize(new Dimension(100, 40));
		formLabel.setPreferredSize(new Dimension(100, 40));
		levelLabel.setPreferredSize(new Dimension(100, 40));
	}
	
	protected void addLabels() {
		this.add(percLabel);
		this.add(pokemonLabel);
		this.add(formLabel);
		this.add(levelLabel);
	}

	public Slot getSlot() {
		return slot;
	}

	public Component getFormLabel() {
		return formLabel;
	}
}
