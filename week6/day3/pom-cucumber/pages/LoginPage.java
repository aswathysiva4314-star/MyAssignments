package com.leaftaps.pages;

import org.openqa.selenium.By;
import com.leaftaps.base.ProjectSpecifcMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginPage  extends  ProjectSpecifcMethods{

    @Given("I enter the username as")
    public LoginPage enterUserName(){ 
     System.out.println("driver value From [Login Page] is "+getDriver()); 
    getDriver().findElement(By.id("username")).sendKeys("DemoCsr");
    return this;
    }
    @Given("I enter the password as")
    public LoginPage enterPassword(){
    getDriver().findElement(By.id("password")).sendKeys("crmsfa");
     return this;
    }
    @When("I click login button")
    public HomePage clickLoginButton(){
    getDriver().findElement(By.className("decorativeSubmit")).click();
     return new HomePage();
    }
}
