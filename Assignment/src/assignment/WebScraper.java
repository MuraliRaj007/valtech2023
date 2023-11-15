package assignment;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;
 
public class WebScraper {
 
    public static void main(String[] args) throws IOException {
String websiteURL = "https://en.wikipedia.org/wiki/Ikigai";
//"https://example.com"; // Replace with the actual URL
        List<String> paragraphs = getParagraphsFromWebsite(websiteURL);
        Set<String> repetitiveWords = findRepetitiveWords(paragraphs);
 
        // Remove repetitive words
        List<String> cleanedParagraphs = new ArrayList<>();
        for (String paragraph : paragraphs) {
            String[] words = paragraph.split("\\s+");
            StringBuilder cleanedParagraph = new StringBuilder();
            for (String word : words) {
                if (!repetitiveWords.contains(word)) {
                    cleanedParagraph.append(word).append(" ");
                }
            }
            cleanedParagraphs.add(cleanedParagraph.toString().trim());
        }
 
        // Remove verbs and adverbs (you may need a more sophisticated approach for this)
        List<String> nonVerbAdverbParagraphs = removeVerbsAndAdverbs(cleanedParagraphs);
 
        // Save the paragraphs to a file
        saveParagraphsToFile(nonVerbAdverbParagraphs, "output.txt");
 
        System.out.println("Processing complete.");
    }
 
    public static List<String> getParagraphsFromWebsite(String url) throws IOException {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
 
        List<String> paragraphs = new ArrayList<>();
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
 
        // Assuming paragraphs are contained within <p> tags
        Pattern pattern = Pattern.compile("<p>(.*?)</p>");
        Matcher matcher = pattern.matcher(content.toString());
        while (matcher.find()) {
paragraphs.add(matcher.group(1));
        }
 
        return paragraphs;
    }
 
    public static Set<String> findRepetitiveWords(List<String> paragraphs) {
        Set<String> repetitiveWords = new HashSet<>();
        Set<String> allWords = new HashSet<>();
        for (String paragraph : paragraphs) {
            String[] words = paragraph.split("\\s+");
            for (String word : words) {
                if (!allWords.add(word)) {
                    repetitiveWords.add(word);
                }
            }
        }
        return repetitiveWords;
    }
 
    public static List<String> removeVerbsAndAdverbs(List<String> paragraphs) {
        // You may need a more sophisticated approach to identify verbs and adverbs
        List<String> nonVerbAdverbParagraphs = new ArrayList<>();
        Set<String> verbsAndAdverbs = new HashSet<>(Arrays.asList("is", "as", "if", "and", "the", "...")); // Placeholder set
 
        for (String paragraph : paragraphs) {
            String[] words = paragraph.split("\\s+");
            StringBuilder cleanedParagraph = new StringBuilder();
            for (String word : words) {
                if (!verbsAndAdverbs.contains(word)) {
                    cleanedParagraph.append(word).append(" ");
                }
            }
            nonVerbAdverbParagraphs.add(cleanedParagraph.toString().trim());
        }
 
        return nonVerbAdverbParagraphs;
    }
    
    public static void saveParagraphsToFile(List<String> paragraphs, String fileName) throws IOException {
        String absolutePath = "Desktop" + fileName; // Replace with your desired path
        BufferedWriter writer = new BufferedWriter(new FileWriter(absolutePath));
        for (String paragraph : paragraphs) {
            writer.write(paragraph);
            writer.newLine();
        }
        writer.close();
    }
 
    
}