package framework;

import java.io.File;

import com.jayway.jsonpath.JsonPath;

public class ReadJsonFile {

	public static String getData(String key) {
		String env = System.getProperty("Env");
		String tenant = System.getProperty("Tenant");
		String value = null;
		String file = env + "_" + tenant;
		String userDir = System.getProperty("user.dir");
		String filePath = userDir + "/src/test/java/testData/file.json".replace("file", file);
		try {
			// Load JSON file
			File jsonFile = new File(filePath);

			// Read a value from the JSON file using JSONPath
			value = JsonPath.read(jsonFile, "$." + key);
			System.out.println("Author of the first book: " + value);
			// Read a list of values
			// List<String> titles = JsonPath.read(jsonFile, "$.batters.batter[2].id");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
