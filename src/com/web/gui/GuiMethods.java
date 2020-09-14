package com.web.gui;

import java.io.IOException;
import java.io.FileWriter;

public class GuiMethods {

	public static void playAudio(String audio) {
		String command = "ffplay " + audio;

		try {
			Process proc = Runtime.getRuntime().exec(command);
			proc.waitFor();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String createString(String audio, String word1, String word2, String IPA, int word) {
		String toReturn = "ErrorCratingTheCSVString";

		String sound = "[sound:" + audio + "];";
		word1 = word1.substring(0, 1).toUpperCase() + word1.substring(1);
		word2 = word2.substring(0, 1).toUpperCase() + word2.substring(1);
		String pair = word1 + " – " + word2 + ";";
		String ipa = IPA + ";";
		String answerWord = "notSet";
		if (word == 1) {
			answerWord = word1;
		} else if (word == 2) {
			answerWord = word2;
		}

		toReturn = sound + pair + ipa + answerWord;

		return toReturn;
	}

	public static void writeCSV(String word) {

		try {
			FileWriter myWriter = new FileWriter("/home/../Desktop/English/SoundsPairs/pairCSVAnki.csv", true);
			myWriter.write(word + "\n");
			myWriter.close();
			System.out.println("Word successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred writing the word.");
			e.printStackTrace();
		}

	}
	
	public static void copyFile(String path1, String path2) {
		String command = "cp " + path1 + path2;

		try {
			Process proc = Runtime.getRuntime().exec(command);
			proc.waitFor();
			System.out.println("File copied");
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
