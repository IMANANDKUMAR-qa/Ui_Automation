package testRunner;

import org.checkerframework.checker.units.qual.g;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import framework.Lmt;
import framework.ReadJsonFile;
import framework.Base;
import framework.Globalvariables;
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
//			System.setProperty("cucumber.options", "--tags " + tags);
//			System.setProperty("cucumber.tags", tags);			
			System.setProperty("cucumber.filter.tags", tags);
			Globalvariables.data = Lmt.getData(Env,Tenant);
			String env1= System.getProperty("Env");
			String tenant1=System.getProperty("Tenant");
			System.out.println((env1 + "ANAND KUMAR ENV"+ tenant1));
      		ReadJsonFile.getData("batters.batter[0].id");
			
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
