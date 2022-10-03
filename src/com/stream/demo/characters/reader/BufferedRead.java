package com.stream.demo.characters.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedRead {
	public static void main(String[] args) {
		bufferedReaderUsingReaderCharByChar();
		bufferedReaderUsingReader_lineByLine();
		
		bufferedReaderUsingFileReader_CharByChar();
		bufferedReaderUsingFileReader_lineByLine();
		
		wrapHighLevelStreamWithLowLevelStream();
		wrapHighLevelStreamWithLowLevelStreamTryBLock();
		
		bufferedReaderUsingFileReader_readLine_TryBlock();
	}

	private static void bufferedReaderUsingReaderCharByChar() {
		Reader r = null;
		BufferedReader br = null;
		
		try {
			r = new FileReader("note.txt");
			br = new BufferedReader(r);
			
			int i;
			
			while((i = br.read()) != -1) {
				System.out.println((char)i);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				r.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void bufferedReaderUsingReader_lineByLine() {
		Reader r = null;
		BufferedReader br = null;
		
		try {
			r = new FileReader("note.txt");
			br = new BufferedReader(r);
			
			String line;
			
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				r.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void bufferedReaderUsingFileReader_CharByChar() {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("note.txt");
			br = new BufferedReader(fr);
			
			int i;
			
			while((i = br.read()) != -1) {
				System.out.println((char)i);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void bufferedReaderUsingFileReader_lineByLine() {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("note.txt");
			br = new BufferedReader(fr);
			
			String line;
			
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void bufferedReaderUsingFileReader_readLine_TryBlock() {
		try (FileInputStream fileInputStream = new FileInputStream("note.txt");
				InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void wrapHighLevelStreamWithLowLevelStream() {
		FileInputStream fileInputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileInputStream = new FileInputStream("note.txt");
			inputStreamReader = new InputStreamReader(fileInputStream);
			bufferedReader = new BufferedReader(inputStreamReader);

			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
				inputStreamReader.close();
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void wrapHighLevelStreamWithLowLevelStreamTryBLock() {
		try (var in = new FileInputStream("note.txt");
			 var inr = new InputStreamReader(in);
		 	 var br = new BufferedReader(inr)) {

			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
