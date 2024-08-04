package framework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.json.JSONObject;

public class Lmt {

	public static LinkedHashMap<Object, Object> getData(String env,String tenant) {
		LinkedHashMap<Object, Object> envData = new LinkedHashMap<Object, Object>();
		String file = env+"_"+tenant;
		String filePath = "C:\\Users\\ANAND KUMAR\\eclipse-workspace\\Ui_Automation\\src\\test\\java\\testData\\file.json"; 
		try {
			filePath = filePath.replace("file", file);
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			StringBuilder jsonContent = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				jsonContent.append(line);
			}
			reader.close();

			// Parse JSON content
			JSONObject jsonObject = new JSONObject(jsonContent.toString());

			// Print JSON values (example for a simple JSON object)
			for (String key : jsonObject.keySet()) {
				System.out.println(key + ": " + jsonObject.get(key));
				envData.put(key, jsonObject.get(key));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return envData;
	}

}
