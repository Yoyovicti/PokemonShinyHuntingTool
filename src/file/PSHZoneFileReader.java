package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import data.Game;
import data.Percentage;
import data.Slot;
import data.Zone;

public class PSHZoneFileReader extends PSHFileReaderBasic{
	
	private PSHGameFileReader gameFileReader;
	
	private String fileName;
	private Zone zone;
	
	public PSHZoneFileReader(PSHGameFileReader gameFileReader, String fileName) {
		this.gameFileReader = gameFileReader;
		this.fileName = fileName;
		
		Game game = gameFileReader.getGame();
		this.zone = new Zone(game , fileName);
		
		readLines();
	}

	private void readLines() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			
			String line;
			int i = 0;
			
			while ((line = reader.readLine()) != null) {
				addSlot(line, i);
				i++;
			}
			
			reader.close();

		} catch (IOException e) {
			System.err.println("File not found : " + fileName);
		}
	}

	private void addSlot(String line, int i) {
		Game zoneGame = zone.getGame();
		Percentage perc = zoneGame.getPercentage(i);
		
		String[] slotTab = line.split(",");
		Slot slot = new Slot(slotTab, perc);
		
		zone.addSlot(slot);
		
	}

	public Zone getZone() {
		return zone;
	}
}
