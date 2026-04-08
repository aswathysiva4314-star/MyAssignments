package com.testng.week5.day2.dynamicparameterization;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends ProjectSpecificMethods{
	//data-driven testing
@DataProvider(name="fetchData")
public String[][] getTestData()
{
	String [][] data = new String[3][4];

	//first set of data
	data[0][0] = "Testleaf";
	data[0][1] = "John";
	data[0][2] = "Abraham";
	data[0][3] = "98127";

	//second set of data
	data[1][0] = "TCS";
	data[1][1] = "Nadasha";
	data[1][2] = "Mathew";
	data[1][3] = "97634";

	//third set of data
	data[2][0] = "Infosys";
	data[2][1] = "Aswathy";
	data[2][2] = "Sivan";
	data[2][3] = "97621";

	return data;

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