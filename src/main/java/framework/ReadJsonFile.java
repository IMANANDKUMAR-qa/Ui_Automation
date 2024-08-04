	package framework;
	import java.io.File;
	import java.util.List;
	
	
	import com.jayway.jsonpath.JsonPath;
	
	public class ReadJsonFile {
	
		public static void main(String[] args) {
			String userDir=System.getProperty("user.dir");
			String file = userDir+"/src/test/java/testData/AUSUAT_QMSSANITY.json";
			try {
				// Load JSON file
				File jsonFile = new File(file);
	
				// Read a value from the JSON file using JSONPath
				String author = JsonPath.read(jsonFile, "$.batters.batter[1].type");
				System.out.println("Author of the first book: " + author);
	
				// Read a list of values
	//			List<String> titles = JsonPath.read(jsonFile, "$.batters.batter[2].id");
	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}
