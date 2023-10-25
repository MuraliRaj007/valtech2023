package com.valtech.training.day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.valtech.training.day1.Point;
import com.valtech.training.day1.Point3D;

public class SerialTest {

	public static void main(String[] args) throws Exception {
//		Point p=new Point(2,3);
		Point3D p=new Point3D(2, 3, 4);
		System.out.println(p);
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("objects.txt")));
		oos.writeObject(p);
		oos.flush();
		oos.close();
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("objects.txt")));
		Point p1=(Point) ois.readObject();
		System.out.println(p1);
		System.out.println(p==p1);
	}

}
