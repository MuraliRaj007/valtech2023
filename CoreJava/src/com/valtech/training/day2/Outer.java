package com.valtech.training.day2;

public class Outer {
	
	private int x=10;
	
	public Inner createInner() {
		return new Inner();
	}
	
	public static interface abcd{
		static void display() {
			System.out.println("static method in Interface");
		}
	}
	
	public abstract static  class StaticInner implements abcd{
		
		public void jumpBy10(Outer o) {
			o.x=o.x+10;
			System.out.println(o.x);
		}
		
		abstract void jumpBy100(Outer o);
	}
	
	
	private class Inner{
		
		public void printx() {
			System.out.println("X="+x);	
		}
		
		public void increment() {
			x++;
		}
		
		
	}
	

	public static void main(String[] args) {
		Outer o1=new Outer();
		Inner i=new Outer().createInner();
		Inner i1=new Outer().createInner();
//		Inner i=new Outer().new Inner();
		i.increment();
		i.printx();
		i1.printx();
		
		StaticInner si=new StaticInner() {
			
			@Override
			void jumpBy100(Outer o) {
				
				o.x=o.x+100;
				System.out.println(o.x);
			}
		};
		si.jumpBy10(o1);
		si.jumpBy100(o1);
		abcd.display();
		
	}

}
