package com.valtech.training.day1;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Point implements Comparable<Point>,Serializable{
	
	
	 
	public static final Point ORIGIN = new Point();
	
	static {
		ORIGIN.x=0;
		ORIGIN.y=0;
	}
	
	public int x;
	public transient int y;
	
	public Point() {
		System.out.println("Point Method");
	}
	
	public Point(int x,int y) {
		super();
		this.x=x;
		this.y=y;
	}
	
	@Override
	public boolean equals(Object obj) {
		Point p=(Point) obj;
		return p.x==x && p.y==y;
	}
	
	@Override
	public int hashCode() {
		
		return  toString().hashCode();
	}
	@Override
	public String toString() {
		
		return "X="+x+"Y="+y;
	}
	
	public double distance(Point other) {
		System.out.println("Distance with another point");
		return distance(other.x,other.y);
	}
	
	public double distance(int x,int y) {
		int difx=this.x-x;
		int dify=this.y-y;
		return Math.sqrt(difx*difx+dify*dify);
	}
	
	public double distance() {
		int difx=x-ORIGIN.x;
		int dify=y-ORIGIN.y;
		return Math.sqrt(difx*difx+dify*dify);
	}
	

	public static void main(String[] args) {
		Point p=new Point();
		p.x=3;
		p.y=4;
		
		System.out.println(p.distance());

	}

	@Override
	public int compareTo(Point o) {
		
		return (x-o.x)==0 ? (y-o.y):(x-o.x);
	}

}
