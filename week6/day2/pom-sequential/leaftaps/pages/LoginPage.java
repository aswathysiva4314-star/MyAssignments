package com.leaftaps.pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.base.ProjectSpecifcMethods;

public class LoginPage extends ProjectSpecifcMethods {

    // public LoginPage(RemoteWebDriver driver) {
    //     this.driver = driver;
    // }

    public LoginPage enterUserName() {
        driver.findElement(By.id("username")).sendKeys("DemoCsr");
        return this;
    }

    public LoginPage enterPassword() {
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        return this;
    }

    public HomePage clickLoginButton() {
        driver.findElement(By.className("decorativeSubmit")).click();
        return new HomePage();
    }
}