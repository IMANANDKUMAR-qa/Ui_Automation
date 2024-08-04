package framework;

import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class ReadFilefromJsonREsponse {

	 public static void main(String[] args) {
	        // Sample JSON response as a string
		    String jsonResponse = "{"
		            + "\"store\": {"
		            +     "\"book\": ["
		            +         "{ \"category\": \"fiction\", \"title\": \"Book 1\", \"author\": \"Author A\" },"
		            +         "{ \"category\": \"non-fiction\", \"title\": \"Book 2\", \"author\": \"Author B\" }"
		            +     "],"
		            +     "\"bicycle\": {"
		            +         "\"color\": \"red\","
		            +         "\"price\": 19.95"
		            +     "}"
		            + "}"
		            + "}";

	        // Extracting data using JSONPath
	        try {
	            // Extract a single value
	            String author = JsonPath.read(jsonResponse, "$.store.book[0].author");
	            System.out.println("Author of the first book: " + author);

	            // Extract a list of values
	            List<String> titles = JsonPath.read(jsonResponse, "$.store.book[*].title");
	            System.out.println("Titles of all books: " + titles);

	            // Extract a nested value
	            double bicyclePrice = JsonPath.read(jsonResponse, "$.store.bicycle.price");
	            System.out.println("Price of the bicycle: " + bicyclePrice);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
