package com.valtech.training.jdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayMountain {
	
	public void isMoutain() {
		
	}
	

	public static void main(String[] args) {
		
		List<Integer> arr=Arrays.asList(1,2,3,4,6,4,3,1);
		List<Integer> asceArr=new ArrayList<Integer>();
		List<Integer> descArr=new ArrayList<Integer>();
		int len=arr.size();
		int j=0;
		for(int i=0;i<len;i++) {
			if(arr.get(i)<arr.get(i+1)) {
				asceArr.add(arr.get(i));
			}else {
				asceArr.add(arr.get(i));
				j=i+1;
				break;
			}
		}
		for(int i=j;i<len-1;i++) {
			if(arr.get(i)>arr.get(i+1)) {
				descArr.add(arr.get(i));
			}
		}
		descArr.add(arr.get(len-1));
		System.out.println(asceArr);
		System.out.println(descArr);
		asceArr.addAll(descArr);
		if(arr.equals(asceArr)) {
			System.out.println("It is array Mountain");
		}else {
			System.out.println("It is not array Mountain");
		}
	}

}
