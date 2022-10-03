package com.stream.demo.characters.reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
	public static void main(String[] args) {
		readFileReader("note1.txt");
		System.out.println();
		readFileReader(new File("note1.txt"));
		System.out.println();
		//readFileReaderUsingInputStream(new File("note1.txt"));
	}
	
	
	private static void readFileReader(String file) {
		try(FileReader fileReader = new FileReader(file)){			
			int i;
			while((i = fileReader.read()) != -1) {
				System.out.print((char)i);
			}
		}catch(IOException e) {
			
		}
	}
	
	private static void readFileReader(File file) {
		try(FileReader fileReader = new FileReader(file)){
			int i;
			
			while((i = fileReader.read()) != -1) {
				System.out.print((char)i);
			}
		}catch(IOException e) {
			
		}
	}

}
