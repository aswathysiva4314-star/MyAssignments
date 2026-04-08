package com.testng.week5.day4.excelintegration;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

//Static Parameterization
public class ProjectSpecificMethods {
     WebDriver driver; //global declaration //superclass
     public static String fileName;
@Parameters({"profile", "url", "username", "password", "browserName"})//value should be call using the same name which is provided in the xml file
    @BeforeMethod
    public void preConditions(String profile, String url, String username, String password, String browser) //parameterization principle 
    //local variable name can be changed but sequential order should not be changed. 
    {
        System.out.println("Browser opted for the execution is: " + browser);
        System.out.println("Browser profile opted for the execution is: " + profile);
        System.out.println("Application url is: "+ url);
        System.out.println("Valid username to access the application is: " + username);
        System.out.println("Valid password to access the application is: " + password);

       switch (browser) {
        case "chrome":
             ChromeOptions chromeOption = new ChromeOptions();
		chromeOption.addArguments(profile);
		driver = new ChromeDriver(chromeOption);  //child class
             break;

        case "firefox":
            FirefoxOptions firefoxOption = new FirefoxOptions();
            firefoxOption.addArguments(profile);
            driver = new FirefoxDriver(firefoxOption);
            break;

        default:
            ChromeOptions defaulOption = new ChromeOptions();
		    defaulOption.addArguments(profile);
		    driver = new ChromeDriver(defaulOption);
            break;
       }

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
    }

    @AfterMethod
    public void postConditions()
    {
        driver.close();
    }
     @BeforeSuite// 1st 
    public void runBeforeSuite(){
    System.out.println("BeforeSuite executed here");
    }
    @AfterSuite
      public void runAfterSuite(){
        System.out.println("AfterSuite executed here");
    }

    @AfterTest
      public void runAfterTest(){
        System.out.println("AfterTest executed here");

    }
    // @BeforeTest //2nd
    // public void runBeforeTest(){
    //     System.out.println("BeforeTest executed here");

    // }
    @AfterClass
    public void runAfterClass(){
        System.out.println("AfterClass executed here");

    }
    @BeforeClass//3rd
    public void runBeforeClass(){
        System.out.println("BeforeClass executed here");

}

@DataProvider(name="fetchData")
public String[][] getTestData() throws IOException
{
	return DataLibrary.readDataFromExcel(fileName);

}
}


