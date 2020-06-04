package com.safetynet.safetynetalerts.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JSONParser {

	public Map<String, Map<String, Object>> parse(String jsonString) {
		
		JSONObject obj = new JSONObject(jsonString);
		
		Map<String, Map<String, Object>> result = new HashMap<>();
		for (String mainKey: obj.keySet()){

		    JSONArray mainKeyArray = obj.getJSONArray(mainKey);
		    
		    for(int line = 0; line < mainKeyArray.length(); line ++) {
		    	JSONObject JSONLine = mainKeyArray.getJSONObject(line);
			    
			    for(String secondaryKey: JSONLine.keySet()) {

			    	Object value = JSONLine.get(secondaryKey);
			    	System.out.println(secondaryKey + " : " + value);
			    	Map<String, Object> keyValue = new HashMap<>();
			    	result.put(mainKey, keyValue);
			    	
			    }		    	
		    	
		    }

		}
		
		return result;

	}
}