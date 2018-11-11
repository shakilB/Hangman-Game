import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class RandomWordGenerator {
	
	// Fields needed to go through the file
	private File file;
	private Scanner fileReader;
	private ArrayList<String> listOfWords;
	
	
	public RandomWordGenerator(String fileName) {
		try {
			file = new File(fileName);
			fileReader = new Scanner(file);
		}catch(FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "File not found");
			return;
		}
		listOfWords = new ArrayList<String>();
	}//RandomWordGenerator Constructor
	
	
	private void generateList() {
		while(fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			listOfWords.add(line);
		}
	}//generateList
	
	
	public String generateRandomWord() {
		generateList();
		return listOfWords.get((int)(Math.random() * listOfWords.size()));
	}//generateRandomWord
}