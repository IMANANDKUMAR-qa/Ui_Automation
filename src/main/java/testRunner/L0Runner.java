package testRunner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import framework.Base;
import framework.Lmt;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class L0Runner {

	@CucumberOptions(features = { "src/test/java/features" }, glue = { "stepDefination" }, plugin = { "pretty",
			"html:target/htmlreport.html", "json:target/htmlreport.json",
			"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, monochrome = true, dryRun = false)

	@Listeners(framework.Listners.class)
	public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

		@BeforeSuite
		@Parameters({"Tags","Env","Tenant"})
		public void beforeSuite(String tags,String Env,String Tenant) {
			System.out.println(tags + "------------------------------");
			System.setProperty("cucumber.options", "--tags " + tags);
			System.setProperty("cucumber.tags", tags);			
			System.setProperty("cucumber.filter.tags", tags);
			Lmt.getData(Env,Tenant);
		}

		@Parameters("browser")
		@BeforeMethod
		public void beforeMrthod(String browser) {

			Base.browserSetup(browser);

		}

		@AfterMethod
		public void afterMrthod() {
			Base.tearDownAll();
		}

		@AfterSuite
		public void afterSuite() {

		}
	}

}
