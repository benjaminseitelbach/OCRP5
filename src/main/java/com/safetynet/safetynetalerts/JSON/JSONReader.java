package com.safetynet.safetynetalerts.JSON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.safetynet.safetynetalerts.config.Config;

public class JSONReader {

	public String read() {
		BufferedReader reader = null;
		String result = "";
		
		try {
			reader = new BufferedReader(new FileReader(Config.DATAFILENAME));

			try {
				String line = reader.readLine();

				// Loop on all file
				while (line != null) {
					//System.out.println("line:" + line);
					result += (line + "\n");

					line = reader.readLine();
				}

				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("result:" + result);
		return result;
		
	}
}
