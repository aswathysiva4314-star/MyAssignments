package steps;

//import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

//import hooks.HooksImp;
//import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeadStepsDynamic extends BaseClass {
    //RemoteWebDriver driver;
    String companyName;
 //  Launch Browser
   /*  @Given("I launch the browser")
    public void i_launch_the_browser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    // Load URL
    @Given("I load the application url")
    public void i_load_the_application_url() {
        driver.get("http://leaftaps.com/opentaps/control/login");
    }
        */

    //  Username
    @Given("I enter the username as {string}")
    public void i_enter_the_username_as(String userName) {
        System.out.println("Driver value near steps is: " + driver);
        driver.findElement(By.id("username")).sendKeys(userName);
    }

    //  Password
    @Given("I enter the password as {string}")
    public void i_enter_the_password_as(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    //  Click Login
    @When("I click login button")
    public void i_click_login_button() {
        driver.findElement(By.className("decorativeSubmit")).click();
    }

    //  Validate Home Page
    @Then("I should be redirected to the home page")
    public void i_should_be_redirected_to_the_home_page() {
        String expectedTitle = "Leaftaps - TestLeaf Automation Platform";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    //  Click Link
    @When("I click {string} link")
    public void i_click_link(String anchorText) {
        driver.findElement(By.linkText(anchorText)).click();
    }

    // @When("I click Leads link")
    // public void i_click_leads_link(){
    //     driver.findElement(By.linkText("Leads")).click();
    // }

    // @When("I click Create Lead link")
    // public void i_click_create_lead_link(){
    //     driver.findElement(By.linkText("Create Lead")).click();
    // }
 

    //  Company Name
    @Given("I enter Company Name as {string}")
    public void i_enter_company_name_as(String cname) {
        companyName = cname;
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
    }

    //  First Name
    @Given("I enter First name as {string}")
    public void i_enter_first_name_as(String fname) {
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
    }

    //  Last Name
    @Given("I enter Last name as {string}")
    public void i_enter_last_name_as(String lname) {
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
    }

    //  Click Create Lead
    @When("I click Create Lead button")
    public void i_click_create_lead_button() {
        driver.findElement(By.name("submitButton")).click();
    }

    //  Validate Lead Creation
    @Then("I should view The Lead created with the Company")
    public void i_should_view_the_lead_created_with_the_company() {
        String expectedValue = companyName;
        String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
        String[] actualValue = text.split(" ");
        Assert.assertEquals(actualValue[0], expectedValue,"Lead is not created");
        System.out.println("Lead is created successfully");
    }

    @Given("I enter Phone Number as {string}")
    public void enterPhnNo(String phnNo)
    {
        driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phnNo);
    }
    @Then("I should view parameter is missing")
    public void verifyTheErrorMessage()
    {
        String expectedValue = "The Following Errors Occurred:";
       String actualValue = driver.findElement(By.className("errorMessageHeader")).getText();
       Assert.assertEquals(actualValue, expectedValue,"Expected and Actual message is not same");
       System.out.println("Error message validated successfully");
    }
}
