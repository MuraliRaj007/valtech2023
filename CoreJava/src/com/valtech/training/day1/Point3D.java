package com.valtech.training.day1;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Point3D extends Point implements Serializable {
	int z;
	
	public static final Point3D ORIGIN = new Point3D();
	
	public Point3D() {
		System.out.println("Point3D Method");
	}
	
	public Point3D(int x, int y,int z) {
		super(x, y);
		this.z=z;
	}
	
//	public double distance() {
//		return Math.sqrt(x*x+y*y+z*z);
//	}
	
	@Override
	public boolean equals(Object obj) {
		Point3D p=(Point3D) obj;
		return p.x==x && p.y==y && p.z==z ;	
	}
	
	@Override
	public int hashCode() {
		
		return toString().hashCode();
	}
	
	@Override
	public String toString() {
		
		return "x="+x+"y="+y+"z="+z;
	}
	
	public double distance(Point3D p) {
		return distance(p.x,p.y,p.z);
	}
	
	
	public double distance(int x,int y,int z) {
		int diffx=this.x-x;
		int diffy=this.y-y;
		int diffz=this.z-z;
		return Math.sqrt(diffz*diffz+diffx*diffx+diffy*diffy);
	}
	
	@Override
	public double distance() {
		// TODO Auto-generated method stub
		return Math.sqrt(x*x+y*y+z*z);
	}

	public static void main(String[] args) {
		ORIGIN.x=0;
		ORIGIN.y=0;
		Point p=new Point(3,4);
//		Point3D p=new Point3D(3,4,5);
		
		double d=p.distance(new Point(3,4));
		System.out.println(d);

	}

}
