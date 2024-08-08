package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

    // ThreadLocal to ensure each thread has its own WebDriver instance
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Method to get the driver for the current thread
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Browser setup method
    public static void browserSetup(String browser) {
        WebDriver webDriver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            webDriver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            webDriver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {
            webDriver = new EdgeDriver();
        }

        driver.set(webDriver); // Set the WebDriver instance for the current thread
    }

    // Teardown method to quit the browser for the current thread
    public static void tearDownAll() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove(); // Remove the WebDriver instance after quitting
        }
    }
}
