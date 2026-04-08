package com.leaftaps.pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.base.ProjectSpecifcMethods;

public class MyLeadPage extends ProjectSpecifcMethods {

    // public MyLeadPage(RemoteWebDriver driver) {
    //     this.driver = driver;
    // }

    public CreateLeadPage clickCreateLead() {
        driver.findElement(By.linkText("Create Lead")).click();
        return new CreateLeadPage();
    }
}