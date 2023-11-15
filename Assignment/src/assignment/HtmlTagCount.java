package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagCount {

	public static void main(String[] args) {
		String fileName = "login.html";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			int lineNumber = 0;
			Map<String, Integer> tagCount = new HashMap<>();
            int totalTags = 0;
			
			while ((line = br.readLine()) != null) {
				lineNumber++;
				Pattern pattern = Pattern.compile("<(\\w+)(\\s+[^>]*)?>");
				Matcher matcher = pattern.matcher(line);
				while (matcher.find()) {
					String tagName = matcher.group(1);
					int start = matcher.start() + 1; // Adding 1 because the match starts with '<'
					int end = matcher.end();
					
					tagCount.put(tagName, tagCount.getOrDefault(tagName, 0) + 1);
				
					System.out.println("Tag: " + tagName);
					System.out.println("Start Line: " + lineNumber + ", Start Position: " + start);
					System.out.println("End Line: " + lineNumber + ", End Position: " + end);
					totalTags++;
				}
			}
			System.out.println("\nTag Counters: ");
			for(Map.Entry<String,Integer>entry:tagCount.entrySet()) {
				System.out.println(entry.getKey()+": "+entry.getValue());
			}
			System.out.println("\nTotal Tags: "+totalTags);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
