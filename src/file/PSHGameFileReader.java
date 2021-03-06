package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import data.Game;

public class PSHGameFileReader extends PSHFileReaderParam{
	
	private PSHZoneFileReader zoneFileReader;
	
	private String fileName;
	private Game game;
	
	public PSHGameFileReader(String fileName) {
		this.fileName = fileName;
		this.game = new Game(fileName);
		
		readLines();
	}

	private void readLines() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			
			String line;
			String param = "";

			while ((line = reader.readLine()) != null) {
				if(isParam(line)) {
					param = getParam(line);
				}
				else if (param != ""){
					addToParam(param, line);
				}
			}
			
			reader.close();

		} catch (IOException e) {
			System.err.println("File not found : " + fileName);
		}
	}

	private boolean isParam(String line) {
		return line.charAt(0) == '#';
	}

	private String getParam(String line) {
		return line.substring(2);
	}

	private void addToParam(String param, String line) {
		game.addData(param, line);
		
	}

	public Game getGame() {
		return game;
	}

	
	
	/*
	public final static String zoneParam = "Zones";
	public final static String slotParam = "Slots";
	private List<String> zoneLines;
	
	public PSHGameFileReader(String fileName) {
		super(fileName);
		this.setParameter(zoneParam, slotParam);
		
	}
	
	@Override
	protected List<Object> readSubList(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getZoneLines() {
		return this.zoneLines;
	}
	*/
}
