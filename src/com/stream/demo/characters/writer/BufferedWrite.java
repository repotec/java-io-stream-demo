package com.stream.demo.characters.writer;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class BufferedWrite {
	public static void main(String[] args) {
		bufferedWriterUsingWriter();
		bufferedWriterUsingWriterTryBlock();
		bufferedWriterUsingFileWriterTryBlock();
	}

	/**
	 * does need to call close or flush method
	 * When using BufferedWriter (or BufferedReader) we don't have to worry about flush() - the BufferedWriter flushes internally while "write()" whenever the buffer is full.
	 */
	private static void bufferedWriterUsingWriter() {
		Writer w = null;
		BufferedWriter out = null;
		
		try {
			w = new FileWriter("note.txt");
			out = new BufferedWriter(w);
			out.write("hello world");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * does not need to call close or flush method
	 */
	private static void bufferedWriterUsingWriterTryBlock() {
		try(Writer w = new FileWriter("note-declareInSideTryBlock.txt");
			BufferedWriter out = new BufferedWriter(w)) {
			out.write("hello world declareInSideTryBlock");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * does not need to call close or flush method
	 */
	private static void bufferedWriterUsingFileWriterTryBlock() {
		try(FileWriter w = new FileWriter("note-declareInSideTryBlock.txt");
			BufferedWriter out = new BufferedWriter(w)) {
			out.write("hello world declareInSideTryBlock");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//wrap high level outputStream with a low level   outputStream
	private static void wrapHighLevelStreamWithLowLevelStreamr() {
		OutputStream outputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			outputStream = new FileOutputStream("note1.txt");
			outputStreamWriter = new OutputStreamWriter(outputStream);
			bufferedWriter = new BufferedWriter(outputStreamWriter);
			
			bufferedWriter.write("hello world declareInSideTryBlock");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				outputStream.close();
				outputStreamWriter.close();
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//wrap high level outputStream with a low level   outputStream
	private static void wrapHighLevelStreamWithLowLevelStreamTryBLockAndVar() {
		try (var out	   = new FileOutputStream("note1.txt");
			 var outWriter = new OutputStreamWriter(out);
			 var buffer    = new BufferedWriter(outWriter);){

			buffer.write("hello world declareInSideTryBlock");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
