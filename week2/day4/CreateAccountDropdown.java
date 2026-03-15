package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountDropdown {
    public static void main(String[] args) {
        // Launch the browser
        FirefoxDriver driver = new FirefoxDriver();

        // Load the URL
        String url = "http://leaftaps.com/opentaps/";
        driver.get(url);

        // maximize the window
        driver.manage().window().maximize();

        // Enter username
        driver.findElement(By.id("username")).sendKeys("demosalesmanager");

        // Enter password
        driver.findElement(By.id("password")).sendKeys("crmsfa");

        // Click on the Login button
        driver.findElement(By.className("decorativeSubmit")).click();

        // Click on the "CRM/SFA" link
        driver.findElement(By.partialLinkText("CRM/SFA")).click();

        // click on Accounts tab
        driver.findElement(By.linkText("Accounts")).click();

        // click on create account
        driver.findElement(By.linkText("Create Account")).click();
        // Enter account name
        driver.findElement(By.id("accountName")).sendKeys("TestLeaf Account 7");

        // Enter description
        driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");

        // Select "ComputerSoftware" as the industry.
        WebElement selectDD1 = driver.findElement(By.name("industryEnumId"));
        Select selectObj1 = new Select(selectDD1);
        selectObj1.selectByIndex(3);

        // Select "S-Corporation" as ownership
        WebElement selectDD2 = driver.findElement(By.name("ownershipEnumId"));
        Select selectObj2 = new Select(selectDD2);
        selectObj2.selectByVisibleText("S-Corporation");

        // Select "Employee" as the source
        WebElement selectDD3 = driver.findElement(By.id("dataSourceId"));
        Select selectObj3 = new Select(selectDD3);
        selectObj3.selectByValue("LEAD_EMPLOYEE");

        // Select "eCommerce Site Internal Campaign" as the marketing campaign
        WebElement selectDD4 = driver.findElement(By.id("marketingCampaignId"));
        Select selectObj4 = new Select(selectDD4);
        selectObj4.selectByIndex(6);

        // Select "Texas" as the state/province
        WebElement selectDD5 = driver.findElement(By.id("generalStateProvinceGeoId"));
        Select selectObj5 = new Select(selectDD5);
        selectObj5.selectByValue("TX");

        // Click on create button
        driver.findElement(By.className("smallSubmit")).click();

        //Verify that the account name is displayed correctly.
        String accountName = driver.findElement(By.xpath("//span[text()='Account Name']/following::span[1]")).getText();
        System.out.println("Account name is: " + accountName);
        if(accountName.contains("TestLeaf Account"))
        {
            System.out.println("Account name verification Successful");
        }
        else{
            System.out.println("Account name verification failed");
        }

        //Close the browser
        driver.close();

    }
}
