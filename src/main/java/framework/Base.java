package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public static WebDriver driver;
	public String browser;


	public static void browserSetup(String browser) {
	
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		
	}

	public static void tearDownAll() {
		driver.quit();

	}
}
