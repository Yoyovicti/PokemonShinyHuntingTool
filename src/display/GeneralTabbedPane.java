package display;
import java.awt.Font;
import java.util.List;

import javax.swing.JTabbedPane;

import data.Game;

public class GeneralTabbedPane extends JTabbedPane{
	
	private GeneralSlotPanel generalSlotPanel;
	private UnimplementedGeneralSearchPanel generalSearchPanel;
	private UnimplementedDexPanel dexPanel;
	private UnimplementedCounterPanel counterPanel;
	
	private List<Game> gameList;
	
	public GeneralTabbedPane() {
		initTabbedPane();
		
		this.gameList = Game.readGames();
		
		initPanels();
		addTabs();
	}

	protected void initTabbedPane() {
		Font f = new Font("Verdana", Font.PLAIN, 15);
		this.setFont(f);
	}

	protected void initPanels() {
		this.generalSlotPanel = new GeneralSlotPanel(this);
		
		// Unimplemented panels
		this.generalSearchPanel = new UnimplementedGeneralSearchPanel();
		this.dexPanel = new UnimplementedDexPanel();
		this.counterPanel = new UnimplementedCounterPanel();
	}

	protected void addTabs() {
		this.addTab("Encounter slots", generalSlotPanel);
		this.addTab("Search", generalSearchPanel);
		this.addTab("Pokédex", dexPanel);
		this.addTab("Counter", counterPanel);
	}

	public List<Game> getGameList() {
		return this.gameList;
	}
}
