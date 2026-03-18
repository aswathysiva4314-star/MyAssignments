package week3.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

import net.bytebuddy.asm.Advice.Enter;

public class DeleteLead {
    public static void main(String[] args) throws InterruptedException {
        // Instantiate the browser
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

        // Click the "Leads" link
        driver.findElement(By.linkText("Leads")).click();

        // Click Find leads
        driver.findElement(By.partialLinkText("Find")).click();

        // Click on phone tab
        driver.findElement(By.xpath("//span[text()='Phone']")).click();

        // Enter the phone no
        driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("1234567890");

        // Click on Find Leads button
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

        Thread.sleep(3000);

        // Capture the lead ID of the first reulting lead
        String id = driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-col-partyId')]/a)[1]")).getText();
        System.out.println("ID is: " + id);

        // Click the first result
        driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-col-partyId')]/a)[1]")).click();

        // Click on the delete button
        driver.findElement(By.xpath("//a[text()='Delete']")).click();

        // Click on Find Leads button again
        driver.findElement(By.partialLinkText("Find")).click();

        // Enter the captured lead ID
        driver.findElement(By.name("id")).sendKeys(id);

        // Click the "Find leads" button.
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

        // Message after deletion
        String msg = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
        System.out.println("Message after deletion: " + msg);

        // Verify the presence of the message
        if (msg.equals("No records to display")) {
            System.out.println("Lead deleted successfully");
        } else {
            System.out.println("Lead deletion failed");
        }

        Thread.sleep(3000);

        // close the browser
        driver.close();

    }

}
