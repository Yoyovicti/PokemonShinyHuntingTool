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
	
	/*
	// Data link
	List<Game> gameList;
	
	// Panels for each application
	JPanel slotPan;
	JPanel dexPan;
	JPanel counterPan;
	JPanel otherPan;
	
	public GeneralTabbedPane() {
		super();
		gameList = Game.readGames();
		Font f = new Font("Verdana", Font.PLAIN, 15);
		this.setFont(f);
		
		initPanels();
	}
	
	private void initPanels() {
		initPrincipalSlotsPanel();
		initDexPan();
		initCounterPan();
		initOtherPan();
	}

	protected void initPrincipalSlotsPanel() {
		slotPan = new GeneralSlotsPanel();
		this.addTab("Encounter slots", slotPan);
	}

	protected void initDexPan() {
		dexPan = new JPanel();
		this.addTab("Pokédex", dexPan);
	}
	
	protected void initCounterPan() {
		counterPan = new JPanel();
		this.addTab("Counter", counterPan);
	}
	
	protected void initOtherPan() {
		otherPan = new JPanel();
		this.addTab("Other...", otherPan);
	}*/
}
