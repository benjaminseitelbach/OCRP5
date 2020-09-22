package com.safetynet.safetynetalerts.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DatasFile {
	private static final String DATASFILENAME = "datas.json";
	
	public static String read() {
		String result = "";
		
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(DATASFILENAME));
	    	
	    	try {
		    	String line = reader.readLine();
				
				//Loop on all file
				while (line != null) {
						
					result += line;
						
					line = reader.readLine();	
				}
					
				reader.close();
			
	    	} catch (IOException e) { //TODO LOGGER
	    		e.printStackTrace();
	    	}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static void write(String datas) {
		
		try {
			FileWriter writer = new FileWriter(DATASFILENAME);
			writer.write(datas);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
