package com.testng.week5.day4.excelintegration;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLead extends ProjectSpecificMethods{
	//data-driven testing
 @BeforeTest //2nd
    public void runBeforeTest(){
        fileName = "CreateLead";
		System.out.println("Excel filepath is chosen as: " +fileName+".xlsx");

    }

    @Test(dataProvider = "fetchData")
	public void runCreateLead(String cmpName, String firstName, String lastName, String phnNo) { //parameterization principle 
    //local variable name can be changed but sequential order should not be changed. 
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cmpName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phnNo);
		driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains(cmpName)) {
			System.out.println("Lead created successfully");
		}
		else {
			System.out.println("Lead is not created");
			
			
		}
	

	}


}