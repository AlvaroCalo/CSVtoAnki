package com.web.models;

import com.web.connection.DatabaseMethods;

public class WordPairs {

	// Attributes
	private Word word1;
	private Word word2;
	private int pairNumber;

	// Constructor
	public WordPairs() {
		this.pairNumber = DatabaseMethods.setLastPair();
		String wordOneToLoad = DatabaseMethods.setFirstWord(pairNumber);
		String wordTwoToLoad = DatabaseMethods.setSecondWord(pairNumber);
		this.word1 = new Word(wordOneToLoad);
		this.word2 = new Word(wordTwoToLoad);
	}

	// Getters and Setters
	public Word getWord1() {
		return word1;
	}

	public void setWord1(Word word1) {
		this.word1 = word1;
	}

	public Word getWord2() {
		return word2;
	}

	public void setWord2(Word word2) {
		this.word2 = word2;
	}

	public int getPairNumber() {
		return pairNumber;
	}

	public void setPairNumber(int pairNumber) {
		this.pairNumber = pairNumber;
	}

	// toString()
	@Override
	public String toString() {
		return "WordPairs [word1=" + word1 + ", word2=" + word2 + ", pairNumber=" + pairNumber + "]";
	}
	

}
