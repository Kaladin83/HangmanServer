package com.hangmanserver.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class HangmanService {
	
	private List<String> list = new ArrayList<>();
	private String chosenWord;
	private String resultWord = "";

	public void getWordsFromFile(){
		File file = 
			      new File("src/main/resources/words.txt"); 
		Scanner scaner;
		try {
			scaner = new Scanner(file);
			while (scaner.hasNextLine()) {
				String str = scaner.nextLine();
				if (!str.contains("(")) {
					list.add(str);
				}
			}
			      
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public void chooseWord() {
		Random r = new Random();
		int index = r.nextInt(list.size());
		chosenWord = list.get(index);
	}
	
	public boolean replaceChars(char letter) {
		if (letter != ' ') {
			return getResult(letter);
		}
		else {
			return getNewResult();
		}
	}
	
	private boolean getNewResult() {
		for (int i = 0; i < chosenWord.length(); i++) {
			resultWord += chosenWord.charAt(i) == '-'? '-': "_";		
		}
		return true;
	}
	
	private boolean getResult(char letter) {
		boolean wasChanged = false;
		char[] word = resultWord.toCharArray();
		
		for (int i = 0; i < chosenWord.length(); i++) {
			if (chosenWord.charAt(i) == letter) {
				word[i] = letter;
				wasChanged = true;
			}
		}
		resultWord = String.valueOf(word);
		return wasChanged;
	}
	
	public List<String> getListOfWords(){
		return list;
	}
	
	public String getResultWord(){
		return resultWord;
	}
	
	public String getOriginalWord(){
		return chosenWord;
	}
}
