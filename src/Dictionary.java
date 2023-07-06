import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
	
	private Map<Entry, List<Note>> entries;
	
	public Dictionary() {
		this.entries = new HashMap<>();
	}

	// Add entry to dictionary.
	public void addEntry(Entry entry) {
		if (this.entries.containsKey(entry)) {
			return;
		}
		
		this.entries.put(entry, entry.getNotes());
		System.out.println("Entry added");
	}
	
	public String search(String search){
		
		for (Entry entry : this.entries.keySet()) {
			if (entry.getName().equals(search)) {
				StringBuilder notes = new StringBuilder();
				this.entries.get(entry).forEach(note -> {
					notes.append("- " + note.getDescription());
					notes.append("\n");
				});	
				notes.deleteCharAt(notes.length() - 1);
				
				return notes.toString();
			}
		}
		
		return "";
	}

	
}
