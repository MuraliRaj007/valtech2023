package com.valtech.training.day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;


public class IOTest {

	public static void main(String[] args) throws IOException {

		writeToFile();
		readFromFile();
		rotateAndWrite();
		rotateAndRead();
	}

	private static void rotateAndRead() throws IOException {
		Reader r=new Rot13Reader(new FileReader(new File("hello.txt")));
		char [] buf=new char[1024];
		int bytesRead=r.read(buf); 
		r.close();
		System.out.println(bytesRead);
		System.out.println(new String(buf,0,bytesRead));
		
	}

	private static void rotateAndWrite() throws IOException {
		Writer out=new Rot13Writer(new FileWriter(new File("hello.txt")));
		out.write("hello world");
		out.flush();
		out.close();
	}

	private static void readFromFile() throws IOException {
		
		FileInputStream fis=new FileInputStream(new File("hello.txt"));
		byte [] buf=new byte[1024];
		int bytesRead=fis.read(buf);
		System.out.println(bytesRead);
		System.out.println(new String(buf,0,bytesRead));
	}

	private static void writeToFile() throws IOException {

		String msg="Hello World";
		FileOutputStream fos=new FileOutputStream(new File("hello.txt"));
		fos.write(msg.getBytes());
		fos.flush();// write the contents of buffer to underlying file
		fos.close();
		
	}

}
