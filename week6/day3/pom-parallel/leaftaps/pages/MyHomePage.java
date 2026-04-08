package com.leaftaps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.base.ProjectSpecifcMethods;

public class MyHomePage extends ProjectSpecifcMethods {

    public MyHomePage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public MyLeadPage clickLeads() {
        driver.findElement(By.linkText("Leads")).click();
        return new MyLeadPage(driver);
    }
}