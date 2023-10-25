package com.valtech.training.day2;

public class AssignPoints {
	
	public int x;
	public int y;
	

	
	public AssignPoints(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	
	AssignPoints add(AssignPoints p) {
		int X=x+p.x;
		int Y=y+p.y;
		return new AssignPoints(X,Y);
	}
	
	AssignPoints sub(AssignPoints P) {
		x=x-P.x;
		y=y-P.y;
		return new AssignPoints(x,y);
	}
	
	public double distance(AssignPoints other) {
		System.out.println("Distance with another point");
		return distance(other.x,other.y);
	}
	
	public double distance(int x,int y) {
		int difx=this.x-x;
		int dify=this.y-y;
		return Math.sqrt(difx*difx+dify*dify);
	}
	
	
	public static void main(String[] args) {
		AssignPoints p1=new AssignPoints(3,4);
		AssignPoints p2=new AssignPoints(6,8);
		AssignPoints p= p1.add(p2);
		System.out.println(p1.distance(p2));
		System.out.println("x="+p.x+"y="+p.y);
	}

}
