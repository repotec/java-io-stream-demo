package com.stream.demo.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {
	public static void main(String[] args) {
		
		try(var in = new ObjectInputStream(new FileInputStream("car1"))){
			try {
				Car c = (Car)in.readObject();
				System.out.println(c.toString()); 
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
