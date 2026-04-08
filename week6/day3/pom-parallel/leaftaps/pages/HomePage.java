package com.leaftaps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.base.ProjectSpecifcMethods;

public class HomePage extends ProjectSpecifcMethods {

    public HomePage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public MyHomePage clickCRMSFAlink() {
        driver.findElement(By.linkText("CRM/SFA")).click();
        return new MyHomePage(driver);
    }
}