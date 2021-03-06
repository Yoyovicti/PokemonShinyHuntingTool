package data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Zone{
	
	private Game parentGame;
	
	private Name name;
	private List<Slot> slotList;
	
	public Zone(String name) {
		this.name = new Name(name);
	}

	@Override
	public String toString() {
		return name.toString();
	}
	
	
	/*
	Game game;
	String name;
	List<Slot> slotList;
	
	public Zone(Game game, String name) {
		this.game = game;
		this.name = name;
	}

	private List<Slot> readESlist() {
		List<Slot> ESlist = new ArrayList<Slot>();
		Slot es;
		
		try {
			BufferedReader ESReader = new BufferedReader(new FileReader(name));
			String line;
			int index = 0;

			while ((line = ESReader.readLine()) != null) {
				es = new Slot(this, line, index);
				ESlist.add(es);
				index++;
			}
			
			ESReader.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found : " + name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ESlist;
	}

	public int readPercentage(int lineNum) {
		return game.getPercentage(lineNum);
	}

	public String getName() {
		return name;
	}

	public List<Slot> getSlotList() {
		return slotList;
	}
	*/

//	public void readSlotsFromFile(String fileName) {
//		EncounterSlot es = new EncounterSlot();
//		
//		BufferedReader reader = new BufferedReader(new FileReader(fileName));
//		String line;
//		int index = 0;
//		while((line = reader.readLine()) != null) {
//			es = EncounterSlot.readSlotFromLine(this, line);
//			es.percentage = game.getPercentage(index);
//			ESlist.add(es);
//			
//			index++;
//		}
//		reader.close();
//		
//	}


}
