package com.stream.demo.characters.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

	public static void main(String[] args) {
		write("note1.txt");
		write(new File("note1.txt"));
		
		writeAppend("note1.txt", true);
		writeAppend(new File("note1.txt"), true);
	}
	
	public static void write(String file) {
		try(FileWriter fileWriter = new FileWriter(file)){
			fileWriter.write("hello world!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeAppend(String file, boolean append) {
		try(FileWriter fileWriter = new FileWriter(file, append)){
			
			fileWriter.write(10);
			fileWriter.write("hello world!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void write(File file) {
		try(FileWriter fileWriter = new FileWriter(file)){
			fileWriter.write("hello world!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeAppend(File file, boolean append) {
		try(FileWriter fileWriter = new FileWriter(file, append)){
			fileWriter.write(10);
			fileWriter.write("hello world!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
