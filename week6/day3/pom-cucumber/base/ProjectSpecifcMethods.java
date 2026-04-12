package com.leaftaps.base;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class ProjectSpecifcMethods extends AbstractTestNGCucumberTests{
    //public static RemoteWebDriver driver;
    //public RemoteWebDriver driver; //NULL
    private static final ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>(); // driver

    //setter
    public void setDriver(RemoteWebDriver IDriver)
    {
        driver.set(IDriver);
    }

    //getter
    public RemoteWebDriver getDriver()
    {
        return driver.get();
    }

@BeforeMethod
public void preCondition(){
ChromeOptions chromeOption = new ChromeOptions();
      chromeOption.addArguments("--guest");
     setDriver(new ChromeDriver(chromeOption));
      System.out.println("driver value near [PSM]] is "+driver);
      getDriver().manage().window().maximize();
      getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       getDriver().get("http://leaftaps.com/opentaps/control/login");
    }

@AfterMethod
public void postCondition(){
        getDriver().close();
    }


}