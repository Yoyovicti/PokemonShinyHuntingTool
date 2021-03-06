package display;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Game;
import data.Zone;

public class GeneralSlotPanel extends JPanel implements ActionListener{
	private GeneralTabbedPane parentPane;
	
	private SlotListPanel slotListPanel;
	
	private JComboBox<Game> gameOption;
	private JComboBox<Zone> routeOption;
	
	public GeneralSlotPanel(GeneralTabbedPane parent) {
		this.parentPane = parent;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel comboBoxPanel = loadComboBoxPanel();
		
		this.slotListPanel = new SlotListPanel();
		
		this.add(comboBoxPanel);
		this.add(slotListPanel);
		
	}

	protected JPanel loadComboBoxPanel() {
		JPanel comboBoxPanel = new JPanel();
		
		this.gameOption = new JComboBox<Game>();
		this.routeOption = new JComboBox<Zone>();
		
		loadGameOption();
		gameOption.addActionListener(this);
		
		loadRouteOption();
		
		comboBoxPanel.add(gameOption);
		comboBoxPanel.add(routeOption);
		return comboBoxPanel;
	}

	protected void loadGameOption() {
		List<Game> gameList = parentPane.getGameList();
		for(Game g : gameList)
			gameOption.addItem(g);
	}
	
	protected void loadRouteOption() {
		Game selectedGame = (Game) gameOption.getSelectedItem();
		List<Zone> zoneList = selectedGame.getZoneList();
		for(Zone z : zoneList)
			routeOption.addItem(z);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		updateRouteOption();
	}

	protected void updateRouteOption() {
		routeOption.removeAllItems();
		loadRouteOption();
	}

	
	
	
	
	
	/*
	// Données
	Game currentGame;
	Zone currentZone;
	
	PSHFileReader fileReader;

	JComboBox<String> gameOption;
	JComboBox<String> routeOption = new JComboBox<String>();
	SlotListPanel slotSubPan;
	
	GridBagConstraints dispConstraints;

	public GeneralSlotPanel() {
		super();

		initPrincipalSlotsPanel();
	}

	private void initPrincipalSlotsPanel() {
		initLayout();
		
		initGame();
		initRoute();
		
		
		initSlotSubPan();
		
	}

	private void initLayout() {
		this.setLayout(new GridBagLayout());
		dispConstraints = new GridBagConstraints();
		dispConstraints.anchor = GridBagConstraints.NORTH;
	}

	private void initGame() {
		// File reader
		fileReader = new PSHGameListFileReader();
		// Game combobox
		initGameOption();
		// CurrentGame
		updateCurrentGame();
	}

	protected void initGameOption() {
		gameOption = new JComboBox<String>();

		List<String> gameList = fileReader.read();
		for (String gameName : gameList)
			gameOption.addItem(gameName);
		
		//Layout
		dispConstraints.gridx = 0;
		dispConstraints.gridy = 0;
		dispConstraints.weightx = 1;
		dispConstraints.weighty = 1;
		gameOption.setPreferredSize(new Dimension(100, 20));
		
		this.add(gameOption, dispConstraints);
		gameOption.addActionListener(this);
	}

	private void initRoute() {
		updateRoute();
		initRouteOption();
	}

	protected void initRouteOption() {
		// Layout
		dispConstraints.gridx = 1;
		dispConstraints.gridy = 0;
		dispConstraints.weightx = 1;
		dispConstraints.weighty = 1;
		routeOption.setPreferredSize(new Dimension(100, 20));

		this.add(routeOption, dispConstraints);
		routeOption.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == gameOption)
			updateCurrentGame();
			updateRoute();
		if(e.getSource() == routeOption) {
			slotSubPan.updateZone(currentZone);
		}
	}

	private void updateCurrentGame() {
		String currentGameAsString = (String) gameOption.getSelectedItem();
		currentGame = new Game(currentGameAsString);
	}

	protected void updateRoute() {
		System.out.println("update route option");
		routeOption.removeAllItems();
		
		fileReader = new PSHGameFileReader(currentGame.getName());
		
		List<List<String>> elements = fileReader.read();
		if(elements != null) {
			List<String> zoneList = ((PSHFileReaderParam) fileReader).getFromParam(elements, PSHGameFileReader.zoneParam);
			
			for(String zoneName : zoneList) {
				routeOption.addItem(zoneName);
			}
			
			String currentZoneAsString = (String) routeOption.getSelectedItem();
			currentZone = new Zone(currentGame, currentZoneAsString);
			
			if(!zoneList.isEmpty()) {
				slotSubPan.updateZone(currentZone);
			}
				
		}
	}

	private void initSlotSubPan() {
		slotSubPan = new SlotListPanel(currentZone);
		
		dispConstraints.gridx = 0;
		dispConstraints.gridy = 1;
		dispConstraints.weightx = 2;
		dispConstraints.weighty = 12;
		gameOption.setPreferredSize(new Dimension(200, 200));
		
		this.add(slotSubPan, dispConstraints);
	}
	*/

//	private void initESDisplayPan() {
//		ESDispGBConstraints.weightx = 1;
//		ESDispGBConstraints.weighty = 1;
//
//		String gameName = (String) ESGameOption.getSelectedItem();
//		Game game = this.getGameFromString(gameName);
//		String zoneName = (String) ESRouteOption.getSelectedItem();
//		Zone zone = game.getZoneFromString(zoneName);
//		List<EncounterSlot> ESlist = zone.getSlotList();
//		displayES(ESlist);
//
//	}
//
//	private List<String> getZoneList(String gameName) {
//		Game game = gameList.get(0);
//		int index = 1;
//		while (game.getName() != gameName && index < gameList.size()) {
//			game = gameList.get(index);
//			index++;
//		}
//
//		List<Zone> zoneList = game.getZoneList();
//		List<String> zoneListAsString = new ArrayList<String>();
//
//		for (Zone zone : zoneList) {
//			zoneListAsString.add(zone.getName());
//		}
//
//		return zoneListAsString;
//	}
//
//	public void actionPerformed(ActionEvent evt) {
//		String gameName = (String) ESGameOption.getSelectedItem();
//		Game game = this.getGameFromString(gameName);
//		List<Zone> zoneList = game.getZoneList();
//
//		if (evt.getSource() == ESGameOption) {
//			// Update
//			ESRouteOption.removeAllItems();
//
//			for (Zone zone : zoneList) {
//				ESRouteOption.addItem(zone.getName());
//			}
//			this.add(ESRouteOption);
//		} else if (evt.getSource() == ESRouteOption) {
//			String zoneName = (String) ESRouteOption.getSelectedItem();
//			Zone zone = game.getZoneFromString(zoneName);
//			List<EncounterSlot> ESlist = zone.getSlotList();
//
//			// Update
//			ESDisplayPan.removeAll();
//			displayES(ESlist);
//		}
//
//	}
//
//	private void displayES(List<EncounterSlot> ESlist) {
//		EncounterSlot es;
//		Pokemon pokemon;
//		JLabel esLabel;
//		for (int i = 0; i < ESlist.size(); i++) {
//			es = ESlist.get(i);
//			pokemon = es.getPokemon();
//			esLabel = new JLabel(pokemon.toString());
//
//			ESDispGBConstraints.gridx = 0;
//			ESDispGBConstraints.gridy = i;
//			ESDispGBConstraints.gridwidth = 1;
//			ESDispGBConstraints.gridheight = 1;
//			ESDisplayPan.add(esLabel, ESDispGBConstraints);
//		}
//	}
//
//	// Retourne la liste des jeux à partir du fichier Games
//	private List<Game> readGameList() {
//		PSHGameListFileReader gameListFileReader = new PSHGameListFileReader();
//		return gameListFileReader.getLineListAs();
//	}
//
//	public List<Game> getGameList() {
//		return gameList;
//	}
//
}
