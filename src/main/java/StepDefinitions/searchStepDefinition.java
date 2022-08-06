package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import java.util.List;


public class searchStepDefinition{

	 WebDriver driver;

	 @Given("user is already on search page")
	 public void user_is_already_on_search_page() {
		 System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.nsw.gov.au/media-releases");
		 driver.manage().window().maximize();
	 }
	  
	 @When("title of search page is Ministerial media releases")
	 public void title_of_search_page_is_ministerial_media_releases() {
		 String title = driver.getTitle();
		 assertEquals("Ministerial media releases | NSW Government",title);	
	 }
	 
	 @Then("ministername accordion is expanded")
	 public void ministername_accordion_is_expanded() {
		 driver.findElement(By.xpath("//fieldset[@id='edit-fieldset-type']//button[@type='button']")).click();
	 }
	 @Then("user selects {string} and click search")
	 public void user_selects_and_click_search(String ministername) throws InterruptedException { //  minister name from search.feature file is passed
		 WebElement wb1 = driver.findElement(By.xpath(("//label[contains(text()"+",'"+ministername+"')]")));
		 boolean isministernamedisplayed = wb1.isDisplayed();
		// System.out.println("displayed======"+isministernamedisplayed);
		 assertTrue(isministernamedisplayed);	 	 
		 wb1.click();
		 WebElement searbutton = driver.findElement(By.xpath("//input[@id='edit-submit-media-release']"));
		 searbutton.click();
		 Thread.sleep(10000); 
	 }
		 
	 @Then("relavant medicacards are displayed with {string}") //  texttoverify in cards from search.feature file is passed
	 public void relavant_medicacards_are_displayed(String texttoverify) throws InterruptedException {
		 List<WebElement> allSelectedOptions =  driver.findElements(By.className("nsw-card__tag"));
		 for (int i=0; i<allSelectedOptions.size();i++){
		  //  System.out.println("values are:" + allSelectedOptions.get(i).getText());
			String verifycontent = allSelectedOptions.get(i).getText();
			assertTrue(verifycontent.contains(texttoverify));		      
		 }		
	 }
	 
	 @Then("user clicks Reset button and filters are removed")
	 public void user_clicks_Reset_button_and_filters_are_removed() {
		 driver.findElement(By.xpath("//input[@value='Reset']")).click();
		 Boolean filterreset = driver.findElement(By.xpath("//div[@class='form-checkboxes']")).isSelected();
		// System.out.println("filterreset======"+filterreset);
		 assertFalse(filterreset);
	 }
	 
	 
	 @Then("Close the browser")
	 public void close_the_browser() {
	    driver.quit();
	 }






}