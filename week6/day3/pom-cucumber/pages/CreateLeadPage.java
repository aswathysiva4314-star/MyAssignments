package com.leaftaps.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.leaftaps.base.ProjectSpecifcMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class CreateLeadPage extends  ProjectSpecifcMethods {

    @Given("I enter Company Name as")
    public CreateLeadPage enterCompanyName(){
        getDriver().findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
        return this;
    }
    @Given("I enter First name as")
    public CreateLeadPage enterFirstName(){
        getDriver().findElement(By.id("createLeadForm_firstName")).sendKeys("Aswathy");
		return this;
        
    }
    @Given("I enter Last name as")
    public CreateLeadPage enterLastName(){
        getDriver().findElement(By.id("createLeadForm_lastName")).sendKeys("S");
        return this;
    }

    @Given("I enter Phone Number as")
public CreateLeadPage i_enter_phone_number_as() {
    getDriver().findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("7654");	
     return this;
}

@When("I should view error message as parameter is missing")
public CreateLeadPage i_should_view_error_message_as_parameter_is_missing() {
    String expectedValue="The Following Errors Occurred:";
   String actualValue = getDriver().findElement(By.className("errorMessageHeader")).getText();
   Assert.assertEquals(actualValue, expectedValue);
    return this;
}
@When("I click Create Lead button")
    public ViewLeadPage clickCreateLeadButton(){
        getDriver().findElement(By.name("submitButton")).click();
        return new ViewLeadPage();
        
    }

}
