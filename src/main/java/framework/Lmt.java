package framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.json.JSONObject;

import com.jayway.jsonpath.JsonPath;

public class Lmt {

	public static LinkedHashMap<String, Object> getData(String env, String tenant) {
		LinkedHashMap<String, Object> envData = new LinkedHashMap<String, Object>();
		String file = env + "_" + tenant;
		String userDir = System.getProperty("user.dir");
		String filePath = userDir + "/src/test/java/testData/AUSUAT_QMSSANITY.json";
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
				envData.put(key.toString(), jsonObject.get(key));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return envData;
	}

	public static Object getData(String key) {
		String env = System.getProperty("Env");
		String tenant = System.getProperty("Tenant");
		Object value = null;
		String file = env + "_" + tenant;
		String userDir = System.getProperty("user.dir");
		String filePath = userDir + "/src/test/java/testData/file.json".replace("file", file);
		try {
			// Load JSON file
			File jsonFile = new File(filePath);

			// Read a value from the JSON file using JSONPath
			value = JsonPath.read(jsonFile, "$." + key);
//			System.out.println("Key: "+ key +" Value: "+ value);

			// Read a list of values
//			List<String> titles = JsonPath.read(jsonFile, "$.batters.batter[2].id");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
