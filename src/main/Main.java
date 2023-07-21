package main;
import java.util.Scanner;

import ui.UserInterface;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		UserInterface ui = new UserInterface(scanner);
		ui.start();
	}

}
