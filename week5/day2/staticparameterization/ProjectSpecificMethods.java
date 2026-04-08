package com.testng.week5.day2.staticparameterization;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

//Static Parameterization
public class ProjectSpecificMethods {
    public ChromeDriver driver;
@Parameters({"profile", "url", "username", "password"})//value should be call using the same name which is provided in the xml file
    @BeforeMethod
    public void preConditions(String profile, String url, String username, String password) //parameterization principle 
    //local variable name can be changed but sequential order should not be changed. 
    {
        System.out.println("Browser profile opted for the execution is: " + profile);
        System.out.println("Application url is: "+ url);
        System.out.println("Valid username to access the application is: " + username);
        System.out.println("Valid password to access the application is: " + password);

        ChromeOptions opt = new ChromeOptions();
		opt.addArguments(profile);
		
		driver = new ChromeDriver(opt);

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

}

