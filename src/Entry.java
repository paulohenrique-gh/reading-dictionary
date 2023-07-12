import java.util.HashMap;
import java.util.Map;

public class Entry {
	
	private String name;
	private Map<Integer, Note> notes;
	private int noteId;
	private char firstLetter;
	
	public Entry(String name) {
		name = name.toLowerCase();
		this.name = name;
		this.notes = new HashMap<>();
		this.noteId = 0;
		this.firstLetter = name.charAt(0);
	}
	
	public String getName() {
		return this.name;
	}
	
	public Map<Integer, Note> getNotes() {
		return this.notes;
	}
	
	public int getNoteId(Note note) {
		for (int id : this.notes.keySet()) {
			if (this.notes.get(id).equals(note)) {
				return id;
			}
		}
		
		return -1;
	}
	
	public void setNotes(Map<Integer, Note> notes) {
		this.notes = notes;
	}
	
	public void addNote(Note note) {
		this.noteId++;
		this.notes.put(this.noteId, note);
	}
	
	public boolean removeNote(Note note) {
		int id = getNoteId(note);
		if (id == -1) {
			return false;
		}
		removeNoteById(id);
		return true;
	}
	
	public void removeNoteById(int noteId) {
		this.notes.remove(noteId);
	}
	
	public char getFirstLetter() {
		return this.firstLetter;
	}
		
	@Override
	public String toString() {
		StringBuilder fullEntry = new StringBuilder();
		
		if (this.notes.isEmpty()) {
			fullEntry.append("\n\t" + this.name + "\n");
			fullEntry.append("\t\tThis entry has no notes");
			return fullEntry.toString();
		}
		
		fullEntry.append("\n\t" + this.name + "\n");
		this.notes.keySet().forEach(id -> {
			fullEntry.append("\t\t" + id + " - " + this.notes.get(id).getDescription() + "\n");
		});
		
		return fullEntry.toString();
	}
	
	
}
