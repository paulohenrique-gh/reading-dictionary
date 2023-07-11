import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
	
	private Map<Term, List<Note>> entries;
	
	public Dictionary() {
		this.entries = new HashMap<>();
	}

	// Add entry to dictionary.
//	public void addEntry(Term entry) {
//		if (this.entries.containsKey(entry)) {
//			return;
//		}
//		
//		this.entries.put(entry, entry.getNotes());
//		System.out.println("Entry added");
//	}
	
	public String search(String search){
		
		for (Term entry : this.entries.keySet()) {
			if (entry.getName().equals(search)) {
				if (entry.getNotes().isEmpty()) {
					return "No notes for this term yet.";
				}
				
				return entry.toString();
			}
		}
		
		return "Not found.";

	}
	
}
