package com.valtech.training.day3;

import java.util.Random;

public class EmployeeGeneration {
	
	String name;
	int age;
    int experience;
    int level;
	
	public void generateEmployee() {
		
		Random r=new Random();
		
//		String [] Names= {"Murali","Jeevan","Govind","Sumanth","Harsha","Venkat"};
//		
//		name=Names[r.nextInt(Names.length)];
		
		String name="";
		int nameSize=r.nextInt(7)+4;

		for (int i = 0; i <=nameSize ; i++) {
			if(i==0) {
				char c=(char) (r.nextInt(26)+65);
				name+=c;
			}else {
				char c = (char) (r.nextInt(26)+97); 
				name+=c;
			}
		}

//		name=name.substring(0,1).toUpperCase()+name.substring(1); 
				
		experience=r.nextInt(14)+2;
		
		if(experience >=2 && experience<5) {
			age=r.nextInt(1,3)+25+experience;
			level=1;
		}else if(experience>=5 && experience<7) {
			age=r.nextInt(1,3)+25+experience;
			level=2;
		}else if(experience>=7 && experience<10) {
			age=r.nextInt(1,3)+25+experience;
			level=3;
		}else if(experience>=10 && experience<12) {
			age=r.nextInt(1,3)+25+experience;
			level=4;
		}else if(experience>=12 ) {
			age=r.nextInt(1,3)+25+experience;
			level=5;
		}else {
			age=r.nextInt(1,3)+25+experience;
			level=0;
		}	
		
		System.out.println("Name="+name+"  Age="+age+"  Experience="+experience+"  Level="+level);
	}

	
	public static void main(String[] args) {
		EmployeeGeneration e=new EmployeeGeneration();
		for (int i = 0; i < 10; i++) {
			e.generateEmployee();
		}
		
		
	}
}
