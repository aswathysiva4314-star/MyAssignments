package com.leaftaps.pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.base.ProjectSpecifcMethods;

public class CreateLeadPage extends ProjectSpecifcMethods {

    // public CreateLeadPage(RemoteWebDriver driver) {
    //     this.driver = driver;
    // }

    public CreateLeadPage enterCmpName() {
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
        return this;
    }

    public CreateLeadPage enterFirstName() {
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Aswathy");
        return this;
    }

    public CreateLeadPage enterLastName() {
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S");
        return this;
    }

    public ViewLeadPage clickCreateLeadButton() {
        driver.findElement(By.name("submitButton")).click();
        return new ViewLeadPage();
    }
}