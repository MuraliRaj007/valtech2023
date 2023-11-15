package com.valtech.training.mobileratingui;

import com.valtech.training.mobileranking.MobileRankingService;
import com.valtech.training.mobileranking.MobileRankingServiceImpl;

public class RatingHelper {
	
	private MobileRankingService mobileRankingService =new MobileRankingServiceImpl();
	
	public int getRanking(String mobile) {
		return mobileRankingService.rankmobile(mobile);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
