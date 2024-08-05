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

	public static Wait<WebDriver> conditionalWait() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(12))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class)
				.ignoring(ElementNotInteractableException.class);
		return wait;
	}

	public Wait<WebDriver> conditionalWait(int timeout, int Polling) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(timeout)).ignoring(NoSuchElementException.class)
				.ignoring(ElementNotInteractableException.class);
		return wait;
	}

	public static WebElement waitForWebelement(WebElement element) {
		Wait<WebDriver> wait = conditionalWait();
		WebElement element1 = wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return element;
			}
		});
		return element1;

	}

	public static void click(WebElement userName) {
		waitForWebelement(userName).click();

	}

}
