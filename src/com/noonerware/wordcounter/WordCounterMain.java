package com.noonerware.wordcounter;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WordCounterMain {

	//
	// Count the number of times a word is used in the sentence.  Ignore case.  Output the words that appear more than one time
	// with a counter of the number of times they occur.  Sort the output by the key.
	//
	
	final String SENTENCE = "We’re excited to announce PromptCare Engage, our new online platform designed to make managing your supply needs easier than ever. With PromptCare Engage, "
			+ "you can conveniently request supplies and stay connected with our team. Creating your account is simple. Visit PromptCare to get started today!";
	
	public static void main(String[] args) {
			WordCounterMain thisClass = new WordCounterMain();
			thisClass.countWords();
	}

	void countWords() {
		Map<String, Integer> wordMap = new HashMap<>();
		
		String[] words = SENTENCE.split(" ");
		for (String word : words) {
			String loopWord = word.trim().toLowerCase();
			
			loopWord = loopWord.replaceAll("[!,.?]", "");
			
			Integer counter = wordMap.get(loopWord);
			if (null == counter) {
				counter = 0;
			}
			counter++;
			
			wordMap.put(loopWord, counter);
		}
		
		TreeMap<String, Integer> sortedWordMap = new TreeMap<String, Integer>(wordMap);
		
		for (Map.Entry<String, Integer> entry : sortedWordMap.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			if (value > 1) {
				System.out.println(String.format("%s: %d", key, value));
			}
		}
	}
	
}
