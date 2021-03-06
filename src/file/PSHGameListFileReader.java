package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import data.Game;

public class PSHGameListFileReader extends PSHFileReaderBasic{
	
	PSHGameFileReader gameFileReader;
	
	private static final String gamesFileName = "Games";
	List<Game> gameList;
	
	public PSHGameListFileReader() throws FileNotFoundException {
		gameList = new ArrayList<Game>();
		readLines();
	}

	private void readLines() throws FileNotFoundException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(gamesFileName));
			String line;

			while ((line = reader.readLine()) != null) {
				addGame(line);
			}
			
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addGame(String line) {
		gameFileReader = new PSHGameFileReader(line);
		Game g = gameFileReader.getGame();
		
		gameList.add(g);
		
	}

	public List<Game> getGameList() {
		return gameList;
	}
	
	/*
	
	private List<String> lines;
	private List<Game> gameList;
	private PSHGameFileReader gameFileReader;

	public PSHGameListFileReader() {
		super(gamesFileName);
		this.readLines();
		this.convert();
	}

	public void readLines() {
		lines = new ArrayList<String>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();

		} catch (FileNotFoundException e) {
			System.err.println("File not found : " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void convert() {
		gameList = new ArrayList<Game>();
		for(String line : lines)
			gameList.add(new Game(line));
	}

	@Override
	protected Game convertTo(String line) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getLines() {
		return this.lines;
	}

	public List<Game> getGameList() {
		return this.gameList;
	}

	public List<String> getZoneLines() {
		return gameFileReader.getZoneLines();
	}
	
	*/
}
