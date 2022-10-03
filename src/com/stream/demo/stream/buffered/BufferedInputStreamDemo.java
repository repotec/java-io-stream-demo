package com.stream.demo.stream.buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {
	public static void main(String[] args) {
		write("note1.txt"); 
		writeFromFileWithBuffer("note1.txt", 16384); //16384 (16384 bytes = 16 KB) --> 1024 * 16
		writeFromFileWithBufferPartialData("note1.txt", 16384, 0, 5);
		writeFromFileWithBufferTryBlock("note1.txt", 16384);
	}
	
	public static void write(String fileName) {
		FileOutputStream out = null;
		BufferedOutputStream b = null;
		
		try{
			out = new FileOutputStream(fileName);
			b = new BufferedOutputStream(out);
			
			String text = "hello world buffered!";
			
			byte[] bytes = text.getBytes("UTF-8");
			b.write(bytes);
			b.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
				b.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void writeFromFileWithBuffer(String fileName, int bufferSize) {
		FileOutputStream out = null;
		BufferedOutputStream b = null;
		
		try{
			out = new FileOutputStream(fileName);
			b = new BufferedOutputStream(out, bufferSize);
			
			String text = "hello world buffered size!";
			
			byte[] bytes = text.getBytes("UTF-8");
			b.write(bytes);
			b.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
				b.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void writeFromFileWithBufferPartialData(String fileName, int bufferSize, int offset, int length) {
		FileOutputStream out = null;
		BufferedOutputStream b = null;
		
		try{
			out = new FileOutputStream(fileName);
			b = new BufferedOutputStream(out, bufferSize);
			
			String text = "hello world buffered size!";
			
			byte[] bytes = text.getBytes("UTF-8");
			b.write(bytes, offset, length);
			b.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
				b.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void writeFromFileWithBufferTryBlock(String fileName, int bufferSize) {
		try(FileOutputStream out = new FileOutputStream(fileName);
			BufferedOutputStream b = new BufferedOutputStream(out, bufferSize);	){

			String text = "hello world buffered size!";
			
			byte[] bytes = text.getBytes("UTF-8");
			b.write(bytes);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}