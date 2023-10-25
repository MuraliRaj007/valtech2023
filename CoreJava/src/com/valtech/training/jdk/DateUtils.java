package com.valtech.training.jdk;

import java.time.LocalDate;
import java.util.Date;

public class DateUtils {
	
	

	public static void main(String[] args) {
		
//		Index of the year 1947-1900,2023-1900
//		index of month starts at 0
//		index of day starts at 1
		Date date=new Date(47,7,15); 
		System.out.println(date);
		
		LocalDate localDate=LocalDate.of(1947, 8, 15);
		System.out.println(localDate);
}

}
