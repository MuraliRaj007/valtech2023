package com.valtech.training.jdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Streams {
	
	private void traditional() {
		List<Integer> nums=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> sqrs=new ArrayList<Integer>();
		for(int i : nums) {
			sqrs.add(i*i);
		}
		System.out.println(nums);
		System.out.println(sqrs);
		
	}

	public static void main(String[] args) {
		
		Streams s=new Streams();
		s.traditional();
		List<Integer> nums=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> sqrs=nums.stream().map(i->i*i).collect(Collectors.toList());
		List<Double> sqrts=nums.stream().map(i-> Math.sqrt(i)).collect(Collectors.toList());
		List<Integer> odds=nums.stream().filter(i->(i%2==1)).collect(Collectors.toList());
		List<Integer> evens=nums.stream().filter(i->(i%2==0)).collect(Collectors.toList());
		
		System.out.println(sqrs);
		System.out.println(sqrts);
		System.out.println(odds);
		System.out.println(evens);
		
	}

}
