package com.stream.demo.stream.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamDemo {
	public static void main(String[] args) {
		writeOutputStream("hello world!", "note1.txt");
		writeFileOutputStream("hello world!", new File("note2.txt"));
		writeAppendFileOutputStream("hello world again appended!", "note1.txt", true);
	}
	
	public static void writeOutputStream(String data, String filePath) {
		try(OutputStream fos = new FileOutputStream(filePath)) {
			byte[] content = data.getBytes();
			fos.write(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeAppendFileOutputStream(String data, String filePath, boolean append) {
		try(OutputStream fos = new FileOutputStream(filePath, append)) {
			fos.write(10); //new line
			byte[] content = data.getBytes();
			fos.write(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeFileOutputStream(String data, String filePath) {
		try(FileOutputStream fos = new FileOutputStream(filePath)) {
			byte[] content = data.getBytes();
			fos.write(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeFileOutputStream(String data, File filePath) {
		try(FileOutputStream fos = new FileOutputStream(filePath)) {
			byte[] content = data.getBytes();
			fos.write(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
