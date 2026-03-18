package week3.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {
    public static void main(String[] args) throws InterruptedException {
       //Instantiate the browser
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

        // Click on Leads tab
        driver.findElement(By.linkText("Leads")).click();

        // Click on Create Lead
        driver.findElement(By.linkText("Create Lead")).click();

        // Enter the CompanyName Field Using Xpath.
        driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Test Leaf");

        // Enter the first name Using Xpath.
        driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Test");

        // Enter the LastName Using Xpath.
        driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Lead");

        // Enter the FirstName (Local) Field Using Xpath.
        driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("TestL");

        // Enter the Department Field
        driver.findElement(By.name("departmentName")).sendKeys("Testing");

        // Enter the Description Field
        driver.findElement(By.id("createLeadForm_description")).sendKeys("for testing purpose");

        // Enter email address
        driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("test12345@gmail.com");

        // Select State/Province as NewYork Using Visible Text
        WebElement spObj = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
        Select spD = new Select(spObj);
        spD.selectByVisibleText("New York");

        // Click on the Create Button
        driver.findElement(By.name("submitButton")).click();

        // Click on Edit
        driver.findElement(By.xpath("//a[text()='Edit']")).click();

        // Clear the Description Field
        driver.findElement(By.id("updateLeadForm_description")).clear();

        // Fill the imp note field
        driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Testing notes");

        // Click on update
        driver.findElement(By.name("submitButton")).click();

        // Get the title
        String title = driver.getTitle();
        System.out.println("Title is: " + title);

        Thread.sleep(3000);
        // Close the browser
        driver.close();

    }

}
