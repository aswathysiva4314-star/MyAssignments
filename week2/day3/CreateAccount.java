package week2.day3;

import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateAccount {
    public static void main(String[] args) {

        // Launch the browser
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

        // click on Accounts tab
        driver.findElement(By.linkText("Accounts")).click();

        // click on create account
        driver.findElement(By.linkText("Create Account")).click();

        // Enter account name
        driver.findElement(By.id("accountName")).sendKeys("Aswathy1 TestLeaf Account");

        // Enter description
        driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");

        // Enter no.of employees
        driver.findElement(By.id("numberEmployees")).sendKeys("50");

        // Enter site name
        driver.findElement(By.id("officeSiteName")).sendKeys("LeafTaps");

        // Click on create button
        driver.findElement(By.className("smallSubmit")).click();

        // To get the title
        String title = driver.getTitle();
        System.out.println("Title is: " + title);

        // To verify the title is displayed correctly
        if (title.contains("Account Details")) {
            System.out.println("Title Verified Successfully");
        } else {
            System.out.println("Title verification Failed");
        }

        // Close browser
        driver.close();
    }

}
