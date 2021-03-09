package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import data.Game;
import data.Percentage;
import data.Zone;

public class PSHGameFileReader extends PSHFileReaderParam{
	
	private PSHZoneFileReader zoneFileReader;
	
	private String fileName;
	private Game game;
	
	List<Zone> zoneList;
	
	public PSHGameFileReader(String fileName) {
		this.fileName = fileName;
		this.game = new Game(fileName); 
		
		readLines(Game.PERCENTAGE_PARAM);
		readLines(Game.ZONE_PARAM);
	}

	private void readLines(String param) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			
			String line;
			boolean add = false;

			while ((line = reader.readLine()) != null) {
				if(add && !isParam(line))
					addToParam(param, line);
				if(isParam(line)) {
					if(line.equals("# " + param)) {
						add = true;
					}
					else {
						add = false;
					}
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
		if(param.equals(Game.ZONE_PARAM)){
			zoneFileReader = new PSHZoneFileReader(this, line);
			Zone zone = zoneFileReader.getZone();
			
			game.addZone(zone);
		}
		if(param.equals(Game.PERCENTAGE_PARAM)) {
			game.addPercentage(new Percentage(line));
		}
	}

	public Game getGame() {
		return game;
	}
}
