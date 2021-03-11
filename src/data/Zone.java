package data;
import java.util.ArrayList;
import java.util.List;

public class Zone{

	private Game game;
	private Name name;
	
	private List<Slot> slotList;
	
	public Zone(Game game, String name) {
		this.game = game;
		this.name = new Name(name);
		
		slotList = new ArrayList<Slot>();
	}

	public Slot getSlot(int index) {
		if(index < slotList.size())
			return slotList.get(index);
		return null;
	}

	public void addSlot(Slot slot) {
		slotList.add(slot);
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
