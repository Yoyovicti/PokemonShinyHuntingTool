package display;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import data.Slot;

public class SlotListPanel extends JPanel {
	
	private GeneralSlotPanel parentGeneralSlotPanel;
	
	private List<SlotPanel> slotPanelList;
	private SlotPanel titlePanel;
	
	public SlotListPanel(GeneralSlotPanel parent) {
		super();
		this.parentGeneralSlotPanel = parent;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		loadTitle();
		loadSlotPanelList();
	}

	public Slot getSlot(int index) {
		return parentGeneralSlotPanel.getSlot(index);
	}

	public void update() {
		this.removeAll();
		loadTitle();
		loadSlotPanelList();
		
		this.updateUI();
	}

	protected void loadSlotPanelList() {
		this.slotPanelList = new ArrayList<SlotPanel>();

		createAndAddSlotPanels();
		removeFormLabelsIfExist();
	}

	protected void createAndAddSlotPanels() {
		for (int i = 0; i < 12; i++) {
			SlotPanel slotPanel = new SlotPanel(this, i);
			
			slotPanelList.add(slotPanel);
			this.add(slotPanel);
		}
	}

	protected void removeFormLabelsIfExist() {
		if(!formExist()) {
			removeFormLabels();
		}
	}

	private void loadTitle() {
		titlePanel = new SlotPanel("Pourcentage,Pokémon,Forme,Niveau");
		this.add(titlePanel);
	}

	private boolean formExist() {
		for(int i = 0; i < slotPanelList.size(); i++) {
			Slot slot = this.getSlot(i);
			
			if(slot!= null && slot.hasForm()) {
				System.out.println(
						slot.getLevel() + ","  + 
						slot.getPokemon() + "," + 
						slot.getPokemon() + "," +
						slot.getPercentage());
				return true;
			}
		}
		return false;
	}

	private void removeFormLabels() {
		titlePanel.remove(titlePanel.getFormLabel());
		
		for(SlotPanel sp : slotPanelList) {
			sp.remove(sp.getFormLabel());
		}
		
	}
}
