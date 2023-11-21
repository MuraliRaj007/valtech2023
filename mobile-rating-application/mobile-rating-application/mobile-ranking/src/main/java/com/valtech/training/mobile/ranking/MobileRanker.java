package com.valtech.training.mobile.ranking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.valtech.training.pattern.checker.PatternChecker;

public class MobileRanker {

	public static List<String> rankMobiles(Map<String, Integer> phoneScores) {
		List<Map.Entry<String, Integer>> entries = new ArrayList<>(phoneScores.entrySet());

		// Sort the entries based on scores in descending order
		Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue());
            }

        });

		// Create a list to store sorted phone numbers
		List<String> sortedPhoneNumbers = new ArrayList<>();

		// Add sorted phone numbers to the list
		for (Map.Entry<String, Integer> entry : entries) {
			sortedPhoneNumbers.add(entry.getKey());
		}

		return sortedPhoneNumbers;
	}

//	public static void main(String[] args) {
//		List<String> phoneNumbers = Arrays.asList("1234567890", "2345678901", "3456789012", "4567890123", "5678901234",
//				"6789054321", "7890123456", "8901234567", "9012345678", "0123456789");
//
//		PatternChecker checker = new PatternChecker();
//		Map<String, Integer> answer = checker.checkPatterns(phoneNumbers);
//
//		System.out.println(answer);
//
//		MobileRanker mobileRanker = new MobileRanker();
//		List<String> rankedNumbers = mobileRanker.rankMobiles(answer);
//
//		System.out.println(rankedNumbers);
//	}
}
