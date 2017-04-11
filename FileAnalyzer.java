package assignment;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileAnalyzer {

	public static void main(String[] args) throws IOException {
		System.out.println("Filename: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		FileCounter counter = new FileCounter();
		FileReader reader = new FileReader(name);
		Scanner fileIn = new Scanner(reader);
		counter.read(fileIn);
		fileIn.close();
		System.out.println("Character: " + counter.getCharacterCount());
		System.out.println("Words: " + counter.getWordCount());
		System.out.println("Lines: " + counter.getLineCount());

	}
}

/**
A class to count the number of characters, words, and lines in files.
*/

 class FileCounter {
	private int wordCount;
	private int lineCount;
	private int characterCount;

	public FileCounter() {
		 wordCount = 0;
	     lineCount = 0;
	     characterCount = 0;
	}
	
/**
 * Process an input source and adds its character, words, and line counts to this counter.
 * @param in the scanner to process
 */
	
public void read (Scanner in) {
	
	
	while(in.hasNextLine()) {
		String next = in.next();
		characterCount = next.length();
		wordCount++;		
	}
	
	in.nextLine();
	lineCount++;	
	
	while (in.hasNextByte()) {
		in.nextByte();
		characterCount++;
	}
}

/**
 * Gets the number of words in this counter.
 * @return the number of words
 */

public int getWordCount() {
	return wordCount;
	
}

/**
 * Gets the number of lines in this counter.
 * @return the number of lines
 */

public int getLineCount() {
	return lineCount;
	
}

/**
 * Gets the number of characters in this counter.
 * @return the number of characters
 */

public int getCharacterCount() {
	return characterCount;
	
}
}