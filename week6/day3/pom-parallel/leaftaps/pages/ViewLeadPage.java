package com.leaftaps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.leaftaps.base.ProjectSpecifcMethods;

public class ViewLeadPage extends ProjectSpecifcMethods {

    public ViewLeadPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public ViewLeadPage verifyLeadCreation() {
        String expectedValue = "TestLeaf";

        String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
        String[] actualValue = text.split(" ");

        Assert.assertEquals(actualValue[0], expectedValue, "Lead is not created");
        System.out.println("Lead is created successfully");

        return this;
    }
}