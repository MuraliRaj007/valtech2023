package com.valtech.training.mobileranking;


import java.util.List;

import com.valtech.training.patternchecker.PatternCheckerService;
import com.valtech.training.patternchecker.PatternCheckerServiceImpl;

public class MobileRankingServiceImpl implements MobileRankingService {
	
	private PatternCheckerService patternCheckerService= new PatternCheckerServiceImpl();

	@Override
	public int rankmobile(String mobile){
		List<String> patterns=patternCheckerService.listPatterns(mobile);
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
