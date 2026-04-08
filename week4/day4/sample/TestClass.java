package com.testng.sample;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestClass {
     @Test
    public void runChrome() {

        ChromeDriver driver = new ChromeDriver();

        driver.get("http://leaftaps.com/opentaps/control/main");

        System.out.println("TestNG Test Executed in chrome browser");

        driver.quit();
    }
    @Test
    public void runFireFox()
    {
        FirefoxDriver driver = new FirefoxDriver();

        driver.get("http://leaftaps.com/opentaps/control/main");

        System.out.println("TestNG Test Executed in firefox browser");

        driver.quit();
    }



}
