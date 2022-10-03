package com.stream.demo.stream.buffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo {
	public static void main(String[] args) {
		readBufferedAvailable("not1.txt");
		readBuffered("note1.txt");
		readBuffered("note1.txt", 1024 * 8);
	}
	
	public static void readBufferedAvailable(String fileName) {
		FileInputStream in = null;
		BufferedInputStream b = null;
		
		try{
			in = new FileInputStream(fileName);
			b = new BufferedInputStream(in);
			
			char c;
			while (b.available() > 0) {
	            c = (char)b.read();
	            System.out.print(c);
	        }
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
				b.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void readBufferedAvailableTryBlock(String fileName) {
		try(FileInputStream in = new FileInputStream(fileName);
			BufferedInputStream buffInputStr = new BufferedInputStream(in)){
			char c;
			while (buffInputStr.available() > 0) {
	            c = (char)buffInputStr.read();
	            System.out.print(c);
	        }
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void readBuffered(String fileName) {
		try(FileInputStream in = new FileInputStream(fileName);
			BufferedInputStream buffInputStr = new BufferedInputStream(in)){
			int i;
			
			while ((i = buffInputStr.read()) != -1) {
	            System.out.print((char)i);
	        }
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readBuffered(String fileName, int bufferedSize) {
		try(FileInputStream in = new FileInputStream(fileName);
			BufferedInputStream buffInputStr = new BufferedInputStream(in, bufferedSize)){
			int i;
			
			while ((i = buffInputStr.read()) != -1) {
	            System.out.print((char)i);
	        }
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
