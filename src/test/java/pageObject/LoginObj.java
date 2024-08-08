package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.Base;

public class LoginObj extends Base {
//	public static By uName = By.id("userName");
	@FindBy(xpath = "//*[@id=\"input\']")
	public static WebElement userName;

	public LoginObj() {
		PageFactory.initElements(getDriver(), this);
	}

}
