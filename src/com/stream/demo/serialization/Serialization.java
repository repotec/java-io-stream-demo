package com.stream.demo.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {
	public static void main(String[] args) {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("car1"))){
			out.writeObject(getNewCar());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Car getNewCar() {
		return new Car("R-334", 300, "red", 100000.500);
	}
}