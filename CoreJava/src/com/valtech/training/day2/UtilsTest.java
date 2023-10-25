package com.valtech.training.day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import com.valtech.training.day1.Point;

public class UtilsTest {
	
	public static void testQueue(Queue<Point> points) {
		points.add(new Point(2,3));
		points.add(new Point(2,4));
		points.add(new Point(2,5));
		points.add(new Point(2,6));
		System.out.println("size="+points.size());
	}
	
	public static void testStack(Stack<Point> points) {
		points.push(new Point(2,3));
		points.push(new Point(2,4));
		points.push(new Point(2,5));
		points.push(new Point(2,3));
		System.out.println("size="+points.size());
		System.out.println(points.pop());
		System.out.println("size="+points.size());
		System.out.println(points.peek());
	}
	
	public static void testMap(Map<String, Point> points) {
		points.put("a",new Point(2,3));
		points.put("2,3",new Point(3,2));
		points.put("3,2",new Point(2,3));
		points.put("3,4",new Point(3,4));
		System.out.println("size="+points.size());
		System.out.println(points);
		
	}
	
	public static void testList(List<Point> points) {
		Point p=new Point(2,3);
		Point p1=new Point(2,3);
		points.add(p);
		points.add(p1);
		points.add(new Point(5,6));
		System.out.println("size="+points.size());
		System.out.println(points);
		
	}
	
	public static void testSet(Set<Point> points) {
		Point p=new Point(2,3);
		Point p1=new Point(2,3);
//		Set<Point> points=new HashSet<>();
		points.add(p);
		points.add(p1);
		points.add(new Point(5,6));
		System.out.println("size="+points.size());
		System.out.println(points);

	}

	public static void main(String[] args) {
		testSet(new HashSet<Point>());
		testSet(new TreeSet<Point>());
		testList(new ArrayList<Point>());
		testList(new LinkedList<Point>());
		testMap(new HashMap<String, Point>());
		testMap(new TreeMap<String, Point>());
		testStack(new Stack<Point>());
		
	}

}
