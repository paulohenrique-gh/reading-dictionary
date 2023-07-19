import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		if (isInDictionary(entry.getFirstLetter(), entry)) {
			return false;
		}
		
		this.entryId++;
		this.entries.get(entry.getFirstLetter()).put(this.entryId, entry);
		return true;
	}
	
	public List<Entry> getAllEntries() {
		List<Entry> entriesList = new ArrayList<>();
		
		this.entries.keySet().forEach(c -> {
			this.entries.get(c).values().forEach(e -> {
				entriesList.add(e);
			});
		});
		return entriesList;
	}
	
	public boolean isInDictionary(char letter, Entry entry) {
		return this.entries.get(letter).containsValue(entry);
	}
	
	public boolean printEntriesByFirstLetter(char firstLetter) {
		StringBuilder entriesList = new StringBuilder();
		
		if (!this.entries.keySet().contains(Character.toLowerCase(firstLetter))) {
			System.out.println("\n\tInput provided was not a valid letter.\n");
			return false;
		}
		
		Map<Integer, Entry> entries = this.entries.get(Character.toLowerCase(firstLetter));
		
		if (entries.isEmpty()) {
			System.out.println("\n\tNo entries starting with the letter " +
					Character.toUpperCase(firstLetter) + "\n");
			return false;
		}
				
		entriesList.append("\n\t*" + Character.toUpperCase(firstLetter) + "*\n");
		entries.keySet().forEach(id -> {
			entriesList.append("\t\t" + id + " - " + entries.get(id).getName() + "\n");
		});
		
		System.out.println(entriesList);
		
		return true;
	}
	
	public int getSizeInLetter() {
		return this.entryId;
	}
	
	public Entry getEntry(char letter, int entryId) {
		return this.entries.get(letter).get(entryId);
	}
	
	public boolean removeEntry(char letter, int entryId) {
		this.entries.get(letter).remove(entryId);
		
		if (isInDictionary(letter, this.getEntry(letter, entryId))) {
			return false;
		}
		
		return true;
	}
	
	public void saveToCsv() {
		FileHandler writer = new FileHandler();
		writer.writeDictToCsv(this);		
	}
	
	

}
