package com.leaftaps.testcases;

//import static com.leaftaps.base.ProjectSpecifcMethods.driver;

import org.testng.annotations.Test;

import com.leaftaps.base.ProjectSpecifcMethods;
import com.leaftaps.pages.LoginPage;

public class TC001_LoginTest extends ProjectSpecifcMethods {

    @Test
    public void runLoginTest(){
        // Builder Pattern
        // LoginPage user = new LoginPage();
        // user.enterUserName();
        // user.enterPassword();
        // user.clickLoginButton();
        // HomePage user1 = new HomePage();
        // user1.clickCRMSFAlink();
System.out.println("Driver instance value IN TCOO1"+getDriver());//INSTANCE NO 1
        //singleton design pattern
        LoginPage user = new LoginPage();// Parameterized constructor
        user.enterUserName()
            .enterPassword()
            .clickLoginButton()
            .clickCRMSFAlink();
    }
}
