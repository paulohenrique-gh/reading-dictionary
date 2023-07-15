import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {

	
	public void write(Dictionary dictionary) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("dictionary.csv"));
			List<Entry> entries = dictionary.getAllEntries();
			
			for (Entry entry : entries) {
				writer.write(entry.getName());
			}
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
