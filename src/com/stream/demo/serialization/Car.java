package com.stream.demo.serialization;

public class Car extends Vehicle{
	private String model;
	private int speed;
	private String color;
	private transient double price;
	
	public Car() {
	}
	
	public Car(String model, int speed, String color, double price) {
		this.model = model;
		this.speed = speed;
		this.color = color;
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", speed=" + speed + ", color=" + color + ", price=" + price + "]";
	}
}