import java.util.Hashtable;
public class WordGuesser {
	
	//Fields needed for the game
	private String word;
	private Hashtable <Character,Boolean> wordCharacters;
	private int wrongLetters;
	private boolean allLettersGuessed;
	private char guess;
	
	/*
	 * WordGuesser Constructor with no parameters
	 */
	public WordGuesser() {
		word=null;
		wordCharacters=null;
		wrongLetters=0;
		guess='\0';
	}//WordGuesser with no parameters
	
	
	public WordGuesser(String word) {
		super();
		this.word=word;
		wordCharacters = new Hashtable<Character,Boolean>();
		setHashtable();
	}//WordGuesser with one parameter
	
	
	public void setGuess(char guess){
		if(!(guess>= 'a' && guess <='z')) throw new IllegalArgumentException();
		this.guess=guess;
	}//setGuess
	
	
	private void setHashtable() {
		for(int i=0;i<word.length();++i) {
			if(word.charAt(i)==' ')continue;
				wordCharacters.put(word.charAt(i), false);
		}
	}//setHashtable
	
	
	public char getGuess() {
		return guess;
	}//getGuess
	
	/*
	 * @return the number of times the user has guessed a wrong letter
	 */
	public int getWrongLetters() {
		return wrongLetters;
	}//getWrongLetters
	
	/*
	 * @return if the user guessed all the correct letters or not
	 */
	public boolean getAllLettersGuessed() {
		return allLettersGuessed;
	}//getAllLettersGuessed
	
	
	public String gameUpdate() {
		String gameUpdater="<html><center>";
		gameUpdater+="You are guessing: ";
		
		for(int i=0;i<word.length();++i) {
			if(word.charAt(i)==' ')gameUpdater+=" ";
			else if(!wordCharacters.get(word.charAt(i)) )gameUpdater+="_";
			else gameUpdater+=""+word.charAt(i);
		}
		
		gameUpdater+="<br>You have guessed ("+wrongLetters+") wrong letters <br>";
		gameUpdater+="Guess a letter: </center></html>";
		return gameUpdater;
	}//gameUpdate
	
	
	public void checkGuess(char letter) {
		boolean isFound=false;
		for(int i=0;i<wordCharacters.size();++i) {
			if(wordCharacters.containsKey(letter)) {
				wordCharacters.put(letter, true);
				isFound=true;
			}
		}
		if(isFound)return;
		++wrongLetters;
	}//checkGuess
	
	
	public void checkGame() {
		if(wrongLetters == 10) {
			return;
		}
		allLettersGuessed=true;
		for(int i=0;i<wordCharacters.size();i++) {
			if(wordCharacters.contains(false))allLettersGuessed=false;
		}
	}//checkGame
	
	
	public String displayResults() {
		String resultDisplayer="<html>";
		if(allLettersGuessed) {
			resultDisplayer+="<center>You win<br>";
			resultDisplayer+="You have guessed '"+word+"' correctly</center></html>";
		}else {
			resultDisplayer+="<center>Sorry, You lost!<br>";
			resultDisplayer+="The correct guess was '" +word+"'</center></html>";
		}
		return resultDisplayer;
	}//displayResults
	

}