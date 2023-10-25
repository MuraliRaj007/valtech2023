package com.valtech.training.jdk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringSort {

	List<String> breakIntoWords(String s) {

		List<String> words = Arrays.asList(s.split(" ")) ;
		return words;
	}

	Map<String, Integer> countVowels(List<String> list) {

		Map<String, Integer> vowelCount = new HashMap<String, Integer>();
		for (String word : list) {
			int count = 0;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
						|| ch == 'O' || ch == 'U') {
					count += 1;
				}
			}
			System.out.println(word + " " + count);
			vowelCount.put(word, count);
		}
		return vowelCount;
	}
	

	void sortWords(Map<String, Integer> vowelCount) {
				
	}

	public static void main(String[] args) {

		StringSort ss = new StringSort();

		ss.countVowels(ss.breakIntoWords("Hello how are you"));
	}

}
