package main;

import java.util.List;

import data.Pokemon;
import display.GeneralWindow;

public class Main {
	
	/**
	 * Main method that creates the principal frame of the program.
	 * 
	 * @param args (unused)
	 */
	public static void main(String[] args) {
		String version = "0.1.0dev";
		
		new GeneralWindow(version);
	}
}
