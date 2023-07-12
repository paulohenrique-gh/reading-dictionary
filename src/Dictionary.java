import java.util.HashMap;
import java.util.Map;

public class Dictionary {

	private Map<Character, Map<Integer, Entry>> entries;
	private int entryId;
	
	public Dictionary() {
		this.entries = new HashMap<>();
		this.entryId = 0;
		for (char i = 'a'; i <= 'z'; i++) {
			this.entries.put(i, new HashMap<>());
		}
	}
	
	public boolean addEntry(Entry entry) {
		if (isInDictionary(entry)) {
			return false;
		}
		
		this.entryId++;
		this.entries.get(entry.getFirstLetter()).put(this.entryId, entry);
		return true;
	}
	
	public boolean isInDictionary(Entry entry) {
		return this.entries.get(entry.getFirstLetter()).containsValue(entry);
	}
	
	public void printEntriesByFirstLetter(char firstLetter) {
		StringBuilder entriesList = new StringBuilder();
		
		Map<Integer, Entry> entries = this.entries.get(Character.toLowerCase(firstLetter));
		
		if (entries.isEmpty()) {
			System.out.println("\n\tNo entries starting with " +
					Character.toUpperCase(firstLetter));
			return;
		}
		
		entriesList.append("\n\t*" + Character.toUpperCase(firstLetter) + "*\n");
		entries.keySet().forEach(id -> {
			entriesList.append("\t\t" + id + " - " + entries.get(id).getName() + "\n");
		});
		
		System.out.println(entriesList);
	}
}
