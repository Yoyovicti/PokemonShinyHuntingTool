package display;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Slot;
import data.Zone;
import file.PSHFileReader;
import file.PSHZoneFileReader;

public class SlotListPanel extends JPanel {
	
	private GeneralSlotPanel parentGeneralSlotPanel;
	
	private List<SlotPanel> slotPanelList;
	
	public SlotListPanel(GeneralSlotPanel parent) {
		super();
		this.parentGeneralSlotPanel = parent;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		loadSlotPanelList();
	}

	public Slot getSlot(int index) {
		return parentGeneralSlotPanel.getSlot(index);
	}

	public void update() {
		this.removeAll();
		loadSlotPanelList();
		this.updateUI();
	}

	protected void loadSlotPanelList() {
		this.slotPanelList = new ArrayList<SlotPanel>();
		loadTitlePanel();

		for (int i = 0; i < 12; i++) {
			SlotPanel slotPanel = new SlotPanel(this, i);
			slotPanelList.add(slotPanel);
			this.add(slotPanel);
		}
	}

	private void loadTitlePanel() {
		JPanel titlePanel = new JPanel();
		
		JLabel percTitle = new JLabel("Pourcentage",JLabel.CENTER);
		percTitle.setPreferredSize(new Dimension(100, 40));
		JLabel pokemonTitle = new JLabel("Pokémon",JLabel.CENTER);
		pokemonTitle.setPreferredSize(new Dimension(100, 40));
		JLabel formTitle = new JLabel("Forme",JLabel.CENTER);
		formTitle.setPreferredSize(new Dimension(100, 40));
		JLabel levelTitle = new JLabel("Niveau",JLabel.CENTER);
		levelTitle.setPreferredSize(new Dimension(100, 40));
		
		titlePanel.add(percTitle);
		titlePanel.add(pokemonTitle);
		if(formsExist())
			titlePanel.add(formTitle);
		titlePanel.add(levelTitle);
		
		this.add(titlePanel);
	}

	public boolean formsExist() {
		for(SlotPanel sp : slotPanelList) {
			if(sp.haveForm())
				return true;
		}
		return false;
	}
}
