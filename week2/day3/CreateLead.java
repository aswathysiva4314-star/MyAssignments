package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateLead {
    public static void main(String[] args) {
        // ChromeDriver driver = new ChromeDriver();
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

        // Enter first name
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Testing");

        // Enter last name
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Lead1234");

        // Enter company name
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Leaf");

        // Enter title
        driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Automation Test Lead");

        // Click on create Lead button
        driver.findElement(By.name("submitButton")).click();

        // To get the title
        String title = driver.getTitle();
        System.out.println("Title is: " + title);

        // Verify the title
        if (title.contains("View Lead")) {
            System.out.println("Title Verification Successful");
        } else {
            System.out.println("Title Verification Failed");
        }

        // Close the browser
        driver.close();
    }
}
