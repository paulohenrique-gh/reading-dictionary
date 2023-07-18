import java.io.BufferedReader;
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
			System.out.println("Saved successfully as new_dictionary.csv");
			csvWriter.close();
			
		} catch (IOException e) {
			System.out.println("An error has ocurred");
			e.printStackTrace();
		}
	}
	
	public void readCsv(String filePath) {
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader(filePath));
			String row;
			while ((row = csvReader.readLine()) != null) {
				System.out.println(row);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
