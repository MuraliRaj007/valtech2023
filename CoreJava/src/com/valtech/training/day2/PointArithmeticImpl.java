package com.valtech.training.day2;

import com.valtech.training.day1.Point;


public class PointArithmeticImpl implements PointArithmetic {

	
	@Override
	public Point add(Point a, Point b) {
		int x=a.x+b.x;
		int y=a.y+b.y;
		Point p=new Point(x,y);
		return p;
	}

	@Override
	public Point sub(Point a, Point b) {
		int x=a.x-b.x;
		int y=a.y-b.y;
		Point p=new Point(x,y);
		return p;
	}
	
	@Override
	public double dis(Point a, Point b) {
		int difx=a.x-b.x;
		int dify=a.y-b.y;
		return Math.sqrt(difx*difx+dify*dify);
	}


	public static void main(String[] args) {
		Point p1=new Point(3,4);
		Point p2=new Point(3,4);
		PointArithmeticImpl p=new PointArithmeticImpl();
		System.out.println(p.add(p1, p2));
		System.out.println(p.sub(p2,p1));
		System.out.println(p.dis(p1, p2));

	}

	

}
