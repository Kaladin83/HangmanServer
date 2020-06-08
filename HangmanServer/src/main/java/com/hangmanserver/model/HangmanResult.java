package com.hangmanserver.model;

import java.util.List;

public class HangmanResult {

	private int returnCode;
	private boolean found;
	private String word;
	private String OriginalWord;
	private List<String> listOfWords;
	
	public int getReturnCode() {
		return returnCode;
	}
	public boolean isFound() {
		return found;
	}
	public void setFound(boolean found) {
		this.found = found;
	}
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getOriginalWord() {
		return OriginalWord;
	}
	public void setOriginalWord(String originalWord) {
		OriginalWord = originalWord;
	}
	public List<String> getListOfWords() {
		return listOfWords;
	}
	public void setListOfWords(List<String> listOfWords) {
		this.listOfWords = listOfWords;
	}
}
