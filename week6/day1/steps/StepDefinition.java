package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
    RemoteWebDriver driver;
    //every feature step should be mapped here, as an individual java methods // 6

 @Given("User launch the browser")
public void user_launch_the_browser() {
   ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--guest");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
@Given("User load the application url")
public void user_load_the_application_url() {
    driver.get("http://leaftaps.com/opentaps/control/login");
}
    
@Given("user enter the username as demosalesmanager")
public void user_enter_the_username_as_demosalesmanager() {
   	driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

}
@Given("User enter the password as crmsfa")
public void user_enter_the_password_as_crmsfa() {
   	driver.findElement(By.id("password")).sendKeys("crmsfa");

}
@When("User click on the login button")
public void user_click_on_the_login_button() {
   	driver.findElement(By.className("decorativeSubmit")).click();
}
@Then("User should be redirected to the home page")
public void user_should_be_redirected_to_the_home_page() {
   String expectedTitle = "Leaftaps - TestLeaf Automation Platform";
   String actualTitle = driver.getTitle();
   Assert.assertEquals(actualTitle, expectedTitle);
}
}
