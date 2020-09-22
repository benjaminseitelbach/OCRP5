package com.safetynet.safetynetalerts.init;

import com.safetynet.safetynetalerts.dao.DatasDaoImpl;
import com.safetynet.safetynetalerts.json.ParsingJson;
import com.safetynet.safetynetalerts.json.ReadingJson;

public class Initialization {
	
	public static DatasDaoImpl init() {
		System.out.println("Init");
		String json = ReadingJson.read();
		//System.out.println(json);
		DatasDaoImpl datasDaoImpl = ParsingJson.parse(json);
		datasDaoImpl.setDatas();
		return datasDaoImpl;
	}
}
