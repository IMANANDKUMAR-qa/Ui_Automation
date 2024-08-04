package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import framework.Base;
import framework.Globalvariables;
import framework.Lmt;
import framework.Z;
import io.cucumber.java.en.Given;

public class LoginStepImpl extends Base{

	@Given("I am google page")
	public void i_am_google_page() {
		String url = Lmt.getData("URL").toString();
		System.out.println("ANAND Kumar " +url+ "_____________________________");
		driver.get(url);
		  Lmt.getData("topping");
		 System.out.println(Lmt.getData("topping"));
//		Z.click("//*[@id=\"content\"]/div/div[1]/div/ul/li[1]/a/div");
//		Z.click("//*[@id=\"content\"]/div/div[1]/div/ul/li[1]/a/div");  
		WebElement elemement = driver.findElement(By.xpath("ASDFGH"));
		 Actions act = new Actions(driver);
		 act.moveToElement(elemement).build().perform();
		 act.clickAndHold(elemement).moveToElement(elemement).release();		
		 act.keyDown("A");
	}

}
