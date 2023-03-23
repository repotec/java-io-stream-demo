package com.stream.demo.characters.reader;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class InputStreamReaderDemo {
	public static void main(String[] args) {
		read("test.properties");
	}
	
	
	
	public static void read(String filePath) {
		Properties props = new Properties();
		
		try(InputStream in = new FileInputStream(filePath);
			InputStreamReader reader = new InputStreamReader(in, Charset.forName("UTF-16"));
			FileReader file = new FileReader(filePath)){
			
			props.load(file);
			
			props.entrySet().stream().forEach(e -> {
				System.out.println(e.getKey() + "|" + e.getValue());	
			});
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
