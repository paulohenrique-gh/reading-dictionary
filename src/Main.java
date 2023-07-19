import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		FileHandler writer = new FileHandler();
		
		UserInterface ui = new UserInterface(scanner);
		ui.start();
	}

}
