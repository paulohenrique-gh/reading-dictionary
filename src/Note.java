import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Note {
	
	private String description;
	private LocalDateTime createdAt;
	
	public Note(String description) {
		this.description = description;
		this.createdAt = LocalDateTime.now();
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCreatedAt() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM.dd.yyyy HH:mm:ss");
		String formattedDate = this.createdAt.format(dateFormat);
		return formattedDate;
	}
}
