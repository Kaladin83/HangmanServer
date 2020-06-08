package com.hangmanserver.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hangmanserver.model.HangmanResult;
import com.hangmanserver.services.HangmanService;

@RestController
@RequestMapping("/")
public class MainControler {

	@Autowired
	private HangmanService service;
	
	@GetMapping("startGame")
	public HangmanResult startGame() {
		service.getWordsFromFile();
		service.chooseWord();
		service.replaceChars(' ');
		
		List<String> listOfWords = service.getListOfWords();
		HangmanResult result = new HangmanResult();
		result.setReturnCode(0);
		result.setOriginalWord(service.getOriginalWord());
		result.setWord(service.getResultWord());
		result.setListOfWords(listOfWords.stream().map(s-> s.toString()).collect(Collectors.toList()));	  
		return result;	     
	}

	@GetMapping("checkLetter")
	public HangmanResult checkLetter(@RequestParam char letter) {
		HangmanResult result = new HangmanResult();
		
		result.setFound(service.replaceChars(letter));
		result.setWord(service.getResultWord());
		result.setReturnCode(service.getResultWord().contains("_")? 0: 1);
		return result;
	}
}
