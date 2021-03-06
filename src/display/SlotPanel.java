package display;

import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Slot;

public class SlotPanel extends JPanel{
	
	private SlotPanel parentSlotPanel;
	
	private JLabel pokeNameLabel;
	private JLabel formLabel;
	private JLabel levelLabel;
	
	public SlotPanel() {
		super();
		
		pokeNameLabel = new JLabel("testPokeName");
		formLabel = new JLabel("testForm");
		levelLabel = new JLabel("testLevel");
		
		this.add(pokeNameLabel);
		this.add(formLabel);
		this.add(levelLabel);
	}
	
	/*
	Slot slot;
	JLabel[] labels;

	public SlotPanel(Slot slot) {
		this.slot = slot;
		
		this.labels = new JLabel[3];
	}
	*/
}
