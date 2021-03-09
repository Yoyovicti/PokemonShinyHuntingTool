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
	
	public static final String ZONE_PARAM = "Zones";
	public static final String PERCENTAGE_PARAM = "Slots";
	
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

	public void addZone(Zone zone) {
		zoneList.add(zone);
	}

	public void addPercentage(Percentage percentage) {
		percentageList.add(percentage);
	}

	public Percentage getPercentage(int i) {
		return percentageList.get(i);
	}

	@Override
	public String toString() {
		return name.toString();
	}
}
