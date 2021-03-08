package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import data.Slot;
import data.Zone;

public class PSHZoneFileReader extends PSHFileReaderBasic{
	
	private PSHGameFileReader gameFileReader;
	
	private String fileName;
	private Zone zone;
	
	public PSHZoneFileReader(String fileName) {
		this.fileName = fileName;
		this.zone = new Zone(fileName);
		
		readLines();
	}

	private void readLines() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			
			String line;
			
			while ((line = reader.readLine()) != null) {
				addSlot(line);
			}
			
			reader.close();

		} catch (IOException e) {
			System.err.println("File not found : " + fileName);
		}
	}

	private void addSlot(String line) {
		String[] slotTab = line.split(",");
		Slot slot = new Slot(slotTab);
		
		zone.addSlot(slot);
		
	}

	public Zone getZone() {
		return zone;
	}
	
	/*
	public PSHZoneFileReader(String fileName) {
		super(fileName);
	}

	@Override
	protected Slot convertTo(String line) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
}
