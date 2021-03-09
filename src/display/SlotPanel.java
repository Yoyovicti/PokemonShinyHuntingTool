package display;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Form;
import data.Percentage;
import data.Pokemon;
import data.Slot;

public class SlotPanel extends JPanel{
	
	private SlotListPanel parentSlotPanel;
	
	private JLabel pokemonLabel;
	private JLabel formLabel;
	private JLabel levelLabel;
	private JLabel percLabel;
	
	private Slot slot;

	public SlotPanel(SlotListPanel parent, int index) {
		super();
		this.parentSlotPanel = parent;
		
		this.slot = parentSlotPanel.getSlot(index);
		
		if(slot != null) {
			Percentage percentage = slot.getPercentage();
			percLabel = new JLabel(percentage.toString(), JLabel.CENTER);
			
			Pokemon pokemon = slot.getPokemon();
			pokemonLabel = new JLabel(pokemon.toString(),JLabel.CENTER);
			
			Form form = slot.getForm();
			formLabel = new JLabel(form.toString(),JLabel.CENTER);
			
			int level = slot.getLevel();
			levelLabel = new JLabel(Integer.toString(level),JLabel.CENTER);
		}
		else {
			percLabel = new JLabel("null", JLabel.CENTER);
			pokemonLabel = new JLabel("null",JLabel.CENTER);
			formLabel = new JLabel("null",JLabel.CENTER);
			levelLabel = new JLabel("null",JLabel.CENTER);
		}
		
		percLabel.setPreferredSize(new Dimension(100, 40));
		pokemonLabel.setPreferredSize(new Dimension(100, 40));
		formLabel.setPreferredSize(new Dimension(100, 40));
		levelLabel.setPreferredSize(new Dimension(100, 40));
		
		this.add(percLabel);
		this.add(pokemonLabel);
		if(parentSlotPanel.formsExist()) {
			System.out.println("test " + slot.getForm().toString().equals(""));
			this.add(formLabel);}
		this.add(levelLabel);
	}


	public boolean haveForm() {
		if(slot != null) {
			Form f = slot.getForm();
			return !f.toString().equals("");
		}
		return false;
	}
}
