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
import data.Slot;
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
		
		this.slotListPanel = new SlotListPanel(this);
		
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
		routeOption.addActionListener(this);
		
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
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == gameOption)
			updateRouteOption();
		if(event.getSource() == routeOption)
			slotListPanel.update();
		
	}

	protected void updateRouteOption() {
		routeOption.removeAllItems();
		loadRouteOption();
	}

	public Slot getSlot(int index) {
		try {
			Zone currentZone = (Zone) routeOption.getSelectedItem();
	 		return currentZone.getSlot(index);
	 	} 
		catch(NullPointerException e) {
	 		System.err.println("Warning : the current zone is null");
	 	}
	 	return null;
	}

	public int getNumberOfSlots() {
		Zone currentZone = (Zone) routeOption.getSelectedItem();
		
		if(currentZone == null)
			return 0;
		
		List<Slot> slotList = currentZone.getSlotList();
		return slotList.size();
	}
}
