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
}
