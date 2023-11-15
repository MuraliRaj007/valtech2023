package assignment;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class HexaToRGBConvertion {

	public static void main(String[] args) {
		try {
			//String fileName = "C://Users/Bhavana.D/Desktop/style.css";
			BufferedReader reader = new BufferedReader(new FileReader("C://Users/Bhavana.D/Desktop/style.css"));
			String line;

			Pattern classSelectorPattern = Pattern.compile("\\.(\\w+)\\s*\\{");
			Pattern intAttributePattern = Pattern.compile("(\\w+)\\s*:\\s*(\\d+)\\s*;");
			Pattern hexColorPattern = Pattern.compile("(\\w+)\\s*:\\s*#([0-9A-Fa-f]{6})\\s*;");

			while ((line = reader.readLine()) != null) {
				Matcher classSelectorMatcher = classSelectorPattern.matcher(line);
				Matcher intAttributeMatcher = intAttributePattern.matcher(line);
				Matcher hexColorMatcher = hexColorPattern.matcher(line);

				while (classSelectorMatcher.find()) {
					String classSelectorName = classSelectorMatcher.group(1);
					System.out.println("Class Selector: " + classSelectorName);
				}

				while (intAttributeMatcher.find()) {
					String attributeName = intAttributeMatcher.group(1);
					int attributeValue = Integer.parseInt(intAttributeMatcher.group(2));
					System.out.println("Integer Attribute: " + attributeName + " = " + attributeValue);
				}

				while (hexColorMatcher.find()) {
					String colorAttributeName = hexColorMatcher.group(1);
					String hexColor = hexColorMatcher.group(2);
					System.out.println("Attribute value before in Hexadecimal:#" + hexColor);
					// Convert hex color to RGB
					int r = Integer.parseInt(hexColor.substring(0, 2), 16);
					int g = Integer.parseInt(hexColor.substring(2, 4), 16);
					int b = Integer.parseInt(hexColor.substring(4, 6), 16);
					String rgbColor = String.format("rgb(%d, %d, %d)", r, g, b);
					System.out.println("RGB Color Attribute: " + colorAttributeName + " = " + rgbColor);
				}
			}

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
