package entities;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
	
	public void writeDictToCsv(Dictionary dictionary) {
		try (FileWriter csvWriter = new FileWriter("new_dictionary.csv")) {
			csvWriter.append("entryName");
			csvWriter.append(",");
			csvWriter.append("notes");
			csvWriter.append("\n");
			
			List<Entry> entries = dictionary.getAllEntries();
			for (Entry entry : entries) {
				csvWriter.append(entry.getName());
				csvWriter.append(",");
				List<String> notes = new ArrayList<>();
				entry.getNotesAsList().forEach(note -> {
					notes.add(note.getDescription());
				});
				csvWriter.append("\"");
				csvWriter.append(String.join(";", notes));
				csvWriter.append("\"");
				csvWriter.append("\n");
			}			
			System.out.println("\tSaved successfully as new_dictionary.csv\n");
			csvWriter.close();
			
		} catch (IOException e) {
			System.out.println("\tAn error has ocurred");
			e.printStackTrace();
		}
	}
	
	public Dictionary readCsv(String filePath) throws FileNotFoundException {
		try (BufferedReader csvReader = new BufferedReader(new FileReader(filePath))) {
			// Read headers before entering the loop
			String row = csvReader.readLine();
			
			Dictionary dictionary = new Dictionary();
						
			while ((row = csvReader.readLine()) != null) {
				// Split each line by comma and save each element in an array
				String[] fields = row.split(",");
				
				// First element of the array is name of the entry
				String name = fields[0];
				Entry entry = new Entry(name);
				
				// Second element are the notes, each one separated by a semicolon
				String descriptions = fields[1].substring(1, fields[1].length() - 1);
				String[] notesText = descriptions.split(";");
	
				// Add notes to the entry
				for (String n : notesText) entry.addNote(new Note(n));
				
				// Add entry to dictionary
				dictionary.addEntry(entry);
			}
			
			System.out.println("\tFile loaded");
			
			return dictionary;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
