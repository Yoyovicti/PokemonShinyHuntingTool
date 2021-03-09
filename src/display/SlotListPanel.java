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
		
		JLabel pokemonTitle = new JLabel("Pokémon",JLabel.CENTER);
		pokemonTitle.setPreferredSize(new Dimension(100, 40));
		JLabel formTitle = new JLabel("Forme",JLabel.CENTER);
		formTitle.setPreferredSize(new Dimension(100, 40));
		JLabel levelTitle = new JLabel("Niveau",JLabel.CENTER);
		levelTitle.setPreferredSize(new Dimension(100, 40));
		
		titlePanel.add(pokemonTitle);
		titlePanel.add(formTitle);
		titlePanel.add(levelTitle);
		
		this.add(titlePanel);
	}
	
	/*
	final int DEFAULT_SLOT_NUMBER = 12;
	
	List<SlotPanel> slotPanels;
	Zone currentZone;
	
	GridBagConstraints slotConstraints;

	public SlotListPanel(Zone currentZone) {
		super();
		initSlotSubPan(currentZone);
	}

	private void initSlotSubPan(Zone currentZone) {
		initConstraints();
		
		this.updateZone(currentZone);
		updateSlotLabels();
	}

	private void initConstraints() {
		this.setLayout(new GridBagLayout());
		slotConstraints = new GridBagConstraints();
	}

	private void updateSlotLabels() {
		initSlotLabels();

		if (this.currentZone != null) {
			List<String> slotListAsString = generateSlotList();
			
			if (slotListAsString != null) {
				List<Slot> slotList = convertToSlots(slotListAsString);
				Slot slot;
				
				for (int i = 0; i < slotListAsString.size(); i++) {
					slot = slotList.get(i);
					setConstraints(i);
					updateSlot(slot);
				}
			}
			else
				System.err.println("no slot found for zone " + currentZone);
		} else
			System.err.println("no current zone selected");
		
	}

	private void initSlotLabels() {
		slotPanels = new ArrayList<SlotPanel>(DEFAULT_SLOT_NUMBER);
		this.removeAll();
		this.updateUI();
	}
	
	private List<String> generateSlotList() {
		PSHFileReader<String> zoneReader = new PSHZoneFileReader(currentZone.getName());
		System.out.println("zone name : " + currentZone.getName());
		List<String> slotList = zoneReader.read();
		return slotList;
	}
	
	private List<Slot> convertToSlots(List<String> slotListAsString) {
		List<Slot> slotList = new ArrayList<Slot>();
		String slotString;
		
		for(int i = 0; i < slotListAsString.size(); i++) {
			slotString = slotListAsString.get(i);
			slotList.add(new Slot(currentZone, slotString, i));
		}
		
		return slotList;
	}

	private void updateSlot(Slot slot) {
		SlotPanel slotPanel = new SlotPanel(slot);
		slotPanels.add(slotPanel);
		this.add(slotPanel, slotConstraints);
	}

	private void setConstraints(int i) {
		slotConstraints.weightx = 1;
		slotConstraints.weighty = 1;
		slotConstraints.gridx = 0;
		slotConstraints.gridy = i;
	}

	public void updateZone(Zone currentZone) {
		if(currentZone.getName() != null) {
			this.currentZone = currentZone;
			updateSlotLabels();
		}
	}
	*/
	
//	this.setLayout(ESGBLayout);
//	// ESGBConstraints.weightx = 1;
//	// ESGBConstraints.weighty = 1;
//
//	for (Game game : gameList) {
//		ESGameOption.addItem(game.getName());
//	}
//
//	ESGBConstraints.gridx = 0;
//	ESGBConstraints.gridy = 0;
//	ESGBConstraints.gridwidth = 1;
//	ESGBConstraints.gridheight = 1;
//	this.add(ESGameOption, ESGBConstraints);
//
//	// Init Zone choice (Gold version first)
//	List<String> zoneList = this.getZoneList((String) ESGameOption.getSelectedItem());
//
//	for (String zone : zoneList) {
//		ESRouteOption.addItem(zone);
//	}
//
//	ESGBConstraints.gridx = 1;
//	ESGBConstraints.gridy = 0;
//	ESGBConstraints.gridwidth = 1;
//	ESGBConstraints.gridheight = 1;
//	this.add(ESRouteOption, ESGBConstraints);
//
//	// Init ES display
//	initESDisplayPan();
//	ESGBConstraints.gridx = 0;
//	ESGBConstraints.gridy = 1;
//	ESGBConstraints.gridwidth = 2;
//	ESGBConstraints.gridheight = 1;
//	this.add(ESDisplayPan, ESGBConstraints);
//
//	ESGameOption.addActionListener(this);
//	ESRouteOption.addActionListener(this);
}
