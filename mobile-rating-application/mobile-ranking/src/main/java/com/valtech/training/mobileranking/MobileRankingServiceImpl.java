package com.valtech.training.mobileranking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class MobileRankingServiceImpl implements MobileRankingService {

	@Override
	public List<String> rankPhoneNumbers(Map<String, Integer> phoneNumbersWithScores) {

		List<Map.Entry<String, Integer>> entries = new ArrayList<>(phoneNumbersWithScores.entrySet());

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

}
