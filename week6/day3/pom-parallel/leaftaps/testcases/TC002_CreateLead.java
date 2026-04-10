package com.leaftaps.testcases;

import org.testng.annotations.Test;

import com.leaftaps.base.ProjectSpecifcMethods;
import com.leaftaps.pages.LoginPage;

public class TC002_CreateLead  extends ProjectSpecifcMethods{

    @Test
    public void runCreateLead(){
        //singleton design pattern
        LoginPage user = new LoginPage(driver); //parameterized constructor
        user.enterUserName()
            .enterPassword()
            .clickLoginButton()
            .clickCRMSFAlink()
            .clickLeads()
            .clickCreateLead()
            .enterCmpName()
            .enterFirstName()
            .enterLastName()
            .clickCreateLeadButton()
            .verifyLeadCreation();
    }

}
