package display;

import javax.swing.JFrame;

public class GeneralWindow extends JFrame{
	
	private GeneralTabbedPane tabbedPane;
	
	private String version;
	private final int width = 600;
	private final int height = 600;
	
	public GeneralWindow(String version) {
		super("Pokemon Shinyhunting Tool " + version);
		this.version = version;
		
		this.tabbedPane = new GeneralTabbedPane();
		this.setContentPane(tabbedPane);
		
		setWindowParameters();
	}

	protected void setWindowParameters() {
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * Getters
	 */
	public String getVersion() {
		return this.version;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	/*
	// Constants
	final int width = 300;
	final int height = 400;
	// Elements
	GeneralTabbedPane tabbedPane;
	
	public GeneralWindow(String version) {
		super("Pokemon Shinyhunting Tool " + version);
		this.initWindow();
	}

	private void initWindow() {
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		
		this.initTabbedPane();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initTabbedPane() {
		tabbedPane = new GeneralTabbedPane();
		this.setContentPane(tabbedPane);
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	*/
}
