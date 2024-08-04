package framework;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Z extends Base {
	
	public  Wait<WebDriver> waitForWebelement() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(2))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class)
				.ignoring(ElementNotInteractableException.class);
		return wait;
	}
	
	public  WebElement waitForWebelement(String xpath) {
		Wait<WebDriver> wait = waitForWebelement();
		WebElement element =wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(By.xpath(xpath));
			}
		});
		return element;
		
	}
	
	public  void click(String xpath) {
		waitForWebelement(xpath).click();
		
	}


}
