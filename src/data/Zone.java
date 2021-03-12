package data;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the zones of the various Pokemon games.
 * Any zone created must have a game attributed and contains a list of slots.
 * 
 * @author Yoyovicti
 *
 */
public class Zone{
	private Game game;
	private Name name;
	
	private List<Slot> slotList;
	
	public Zone(Game game, String name) {
		this.game = game;
		this.name = new Name(name);
		
		slotList = new ArrayList<Slot>();
	}

	/**
	 * Returns a specific slot in the slotList specified by its position in the list.
	 * 
	 * @param index
	 */
	public Slot getSlot(int index) {
		if(index < slotList.size())
			return slotList.get(index);
		return null;
	}

	public void addSlot(Slot slot) {
		slotList.add(slot);
	}

	public Game getGame() {
		return this.game;
	}

	@Override
	public String toString() {
		return name.toString();
	}

	public Game getGame() {
		return this.game;
	}

	public List<Slot> getSlotList() {
		return slotList;
	}
}
