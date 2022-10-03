package com.stream.demo.stream.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileIntputStreamDemo {
	public static void main(String[] args) {
		readInputStream("note1.txt");
		System.out.println();
		readInputStreamLineByLine("note1.txt");
		readFileInputStreamUsing("note1.txt");
	}
	
	public static void readInputStream(String filePath) {
		try(InputStream fis = new FileInputStream(filePath)) {
			int i;
			char c;
			
			while((i = fis.read()) != -1) {
	            c = (char)i;
	            System.out.print(c);
	         }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readInputStreamLineByLine(String filePath) {
		try(InputStream is = new FileInputStream(filePath)) {
	        System.out.print((char)is.read());
	        System.out.print((char)is.read());
	        System.out.print((char)is.read());
	        System.out.print((char)is.read());
	        System.out.print((char)is.read());
	        System.out.print((char)is.read());
	        System.out.print((char)is.read());
	        System.out.print((char)is.read());
	        System.out.print((char)is.read());
	        System.out.print((char)is.read());
	        System.out.print((char)is.read());
	        System.out.print((char)is.read());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readFileInputStream(String filePath) {
		try(FileInputStream fis = new FileInputStream(filePath)) {
			int i;
			char c;
			
			while((i = fis.read()) != -1) {
	            c = (char)i;
	            System.out.print(c);
	         }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readFileInputStreamUsing(String filePath) {
		try(FileInputStream fis = new FileInputStream(filePath)) {
			char character;
			
			while(fis.available() > 0) {
				character = (char)fis.read();
		        System.out.print(character);
	         }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
