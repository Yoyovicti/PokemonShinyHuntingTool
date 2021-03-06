package data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import file.PSHGameFileReader;
import file.PSHGameListFileReader;

public class Game{
	
	private Name name;
	private List<Percentage> percentageList;
	private List<Zone> zoneList;
	
	public Game(String name) {
		this.name = new Name(name);
		
		this.percentageList = new ArrayList<Percentage>();
		this.zoneList = new ArrayList<Zone>();
	}

	public static List<Game> readGames() {
		try {
			PSHGameListFileReader gameListFileReader = new PSHGameListFileReader();
			return gameListFileReader.getGameList();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<Zone> getZoneList() {
		return zoneList;
	}

	public void addData(String param, String line) {
		switch(param) {
			case "Zones":
				this.addZone(line);
				break;
			case "Slots":
				this.addPercentage(line);
				break;
		}
	}

	private void addZone(String line) {
		Zone z = new Zone(line);
		zoneList.add(z);
	}

	private void addPercentage(String line) {
		Percentage p = new Percentage(line);
		percentageList.add(p);
	}

	@Override
	public String toString() {
		return name.toString();
	}
	
	
	
	/*
	String name;
	
	List<Zone> zoneList;
	List<Integer> percentageList;
	
	public Game(String name) {
		this.name = name;
		this.percentageList = readPercentageList();
		this.zoneList = readZoneList();
	}

	private List<Integer> readPercentageList() {
		List<String> percentageStringList = readFromParameter(name, "Slots");
		List<Integer> percentageList = new ArrayList<Integer>();
		
		if(percentageStringList != null) {
			for(String str : percentageStringList) {
				percentageList.add(Integer.parseInt(str));
			}
		}
		return percentageList;
	}

	private List<Zone> readZoneList() {
		List<String> zoneStringList = readFromParameter(name, "Zones");
		List<Zone> zoneList = new ArrayList<Zone>();
		
		if(zoneStringList != null) {
			for(String str : zoneStringList) {
				zoneList.add(new Zone(this, str));
			}
		}
		
		return zoneList;
	}
	
	private List<String> readFromParameter(String fileName, String param) {
		List<String> lines = new ArrayList<String>();
		String hashParam = "# " + param;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			
			String line = "";

			while (!line.equals(hashParam)) {
				line = reader.readLine();
				
				if(line == null) {
					reader.close();
					return null;
				}
			}
			while((line = reader.readLine()) != null && line.charAt(0) != '#') {
				lines.add(line);
			}
			
			reader.close();
			
			
		} catch (FileNotFoundException e) {
			System.err.println("File not found : " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lines;
	}

	public int getPercentage(int index) {
		return percentageList.get(index);
	}

	public String getName() {
		return name;
	}

	public List<Zone> getZoneList() {
		return zoneList;
	}

	@Override
	public String toString() {
		return name + "\n" + zoneList + "\n" + percentageList + "\n";
	}

	public Zone getZoneFromString(String zoneName) {
		for(Zone z : zoneList) {
			if(z.getName() == zoneName) {
				return z;
			}
		}
		return null;
	}

	public static List<Game> readGames() {
		PSHGameListFileReader glfReader = new PSHGameListFileReader();
		return glfReader.read();
	}
	
	*/
}
