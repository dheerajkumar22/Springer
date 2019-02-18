import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Springer.search.Pages.HomePage;
import com.Springer.search.Pages.SearchPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchSteps {
	WebDriver driver = null;

	@Given("^user is  on homepage$")
	public void user_is_on_homepage() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		if(driver==null){
			driver = new ChromeDriver();
		}
		
		driver.get("https://link.springer.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@And("^close the browser$")
	public void user_close_browser() throws Exception {
		driver.quit();
	}
	
	@When("^user search for \"([^\"]*)\"$")
	public void user_search_for(String searchText) throws Exception {
	    HomePage homePage  = new HomePage(driver);
	    homePage.enter_query(searchText);
	}

	@SuppressWarnings("deprecation")
	@Then("^auto suggest results should contain text \"([^\"]*)\"$")
	public void results_should_contain_text(String queryText) throws Exception {
		HomePage homePage  = new HomePage(driver);
	    homePage.verify_query_result(queryText, queryText);
	}
	
	@And("^user click on seach button$")
	public void user_click_on_search_button() throws Exception {
		HomePage homePage  = new HomePage(driver);
	    homePage.click_search_button();
	}
	
	@Then("^searched results should contain text \"([^\"]*)\"$")
	public void searched_results_should_contain_text(String query) throws Exception {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.verify_query_result(query, query);
	}
	

}
