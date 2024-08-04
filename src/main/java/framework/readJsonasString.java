package framework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.jayway.jsonpath.JsonPath;

public class readJsonasString {
	
	public static void main(String[] args) {
        try {
            // Read the JSON file into a String
        	String userDir=System.getProperty("user.dir");
            String json = new String(Files.readAllBytes(Paths.get(userDir +"/src/test/java/testData/AUSUAT_QMSSANITY.json")));
            
            // Extract specific fields using JSONPath
            String author = JsonPath.read(json, "$.batters.batter[1].type");
            System.out.println("Author: " + author);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
