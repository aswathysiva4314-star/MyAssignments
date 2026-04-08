package week3.marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;

import week1.day2.Firefox;

public class PVRBookingTest {
    public static void main(String[] args) throws InterruptedException {
        // ChromeOptions options = new ChromeOptions();
        // options.addArguments("--disable-notifications");
        // ChromeDriver driver = new ChromeDriver(options);

        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().to("https://www.pvrcinemas.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[text()='Cinema']")).click();
        driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Ulsoor ')]")).click();

        driver.findElement(By.xpath("//li[@class='p-dropdown-item']/span[contains(text(),'Tomorrow')]")).click();

        driver.findElement(By.xpath("(//span[text()='AADU 3'])[2]")).click();
        driver.findElement(By.xpath("(//span[text()='Malayalam'])[3]")).click();
        driver.findElement(By.xpath("//button[@aria-label='Submit']")).click();
        driver.findElement(By.xpath("//button[text()='Accept']")).click();
        driver.findElement(By.xpath("(//span[@class='seat-current-pvr' and text()='12'])[1]")).click();
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
        driver.findElement(By.xpath("//span[text()='Skip & Proceed']")).click();
        String seatInfo = driver.findElement(By.xpath("//div[@class='seat-number']")).getText();
        System.out.println("Seat Info: " + seatInfo);
        String total = driver.findElement(By.xpath("//div/h6[text()='Grand Total']/following-sibling::h6")).getText();
        System.out.println("Grand total: " + total);
        driver.findElement(By.xpath("//button[text()='Continue']")).click();
        driver.findElement(By.xpath("(//div[contains(@class,'cross-icon')])[2]")).click();
        // WebElement closeBtn =
        // driver.findElement(By.xpath("//div[contains(@class,'cross-icon')]"));

        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].click();", closeBtn);
        String title = driver.getTitle();
        System.out.println("Page Title is: " + title);
        driver.close();
    }
}
