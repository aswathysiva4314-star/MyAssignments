package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookRegisterationForm {
    public static void main(String[] args) {
        // Launch the browser
        FirefoxDriver driver = new FirefoxDriver();

        // Load the URL
        driver.navigate().to("https://en-gb.facebook.com/");

        // maximize the window
        driver.manage().window().maximize();

        // Click on Create new account
        driver.findElement(By.linkText("Create new account")).click();

        // Enter first name
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("John");

        // Enter surname
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("David");

        // Enter the mobile no or email address
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("9065473218");

        // Enter the new password
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("john@david123");

        // Day
        // driver.findElement(By.xpath("//span[text()='Day']/ancestor::div[@aria-label='Select
        // day']")).click();
        driver.findElement(By.xpath("(//div[@role='combobox'])[1]")).click();
        driver.findElement(By.xpath("//div[text()='3']")).click();

        // Month
        driver.findElement(By.xpath("(//div[@role='combobox'])[2]")).click();
        driver.findElement(By.xpath("//div[text()='February']")).click();

        // Year
        driver.findElement(By.xpath("(//div[@role='combobox'])[3]")).click();
        driver.findElement(By.xpath("//div[text()='2020']")).click();

        // Select gender
        driver.findElement(By.xpath("(//div[@role='combobox'])[4]")).click();
        driver.findElement(By.xpath("//div[text()='Male']")).click();

        // close the browser
        driver.close();

    }
}
