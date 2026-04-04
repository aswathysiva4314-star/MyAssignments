package week5.marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNow {
    public static void main(String[] args) throws InterruptedException, IOException {
         //Preconditions
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://dev373211.service-now.com/login.do?");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Enter valid credentials and click on Login button
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("user_password")).sendKeys("dT-Pn-63FOhv");
        driver.findElement(By.id("sysverb_login")).click();

        //Click-All
        Shadow shadow = new Shadow(driver);
        shadow.setImplicitWait(10);
        shadow.findElementByXPath("//div[text()='All']").click();

        //Enter Service catalog in filter navigator  and  Click the ServiceCatalog 
        shadow.findElementByXPath("//a[contains(@aria-label,'Service Catalog')]").sendKeys(Keys.ENTER);

        //click on mobiles
       WebElement frameElement = shadow.findElementByXPath("//iframe[@id='gsft_main']");
       driver.switchTo().frame(frameElement);
       driver.findElement(By.linkText("Mobiles")).click();
       
       //Select Apple iphone13pro 
       driver.findElement(By.partialLinkText("iPhone 13 pro")).click();

        //Choose yes option in lost or broken iPhone
        driver.findElement(By.xpath("//input[contains(@class,'cat_item_option')]/following-sibling::label")).click();

        // Enter phonenumber as 99 in original phonenumber field
        driver.findElement(By.xpath("//input[contains(@class,'sc-content-pad')]")).sendKeys("99");

        // Select Unlimited from the dropdown in Monthly data allowance
        WebElement selectAllowance = driver.findElement(By.xpath("//select[contains(@class,'cat_item_option')]"));
        Select seleObj = new Select(selectAllowance);
        seleObj.selectByIndex(2);

        //Update color field to SierraBlue and storage field to 512GB
        driver.findElement(By.xpath("//input[@value='sierra_blue']/following-sibling::label")).click();
        driver.findElement(By.xpath("//input[@value='512']/following-sibling::label")).click();

        //click on order now button
        driver.findElement(By.id("oi_order_now_button")).click();

        //Verify order is placed and copy the request number
        String reqNum = driver.findElement(By.id("requesturl")).getText();
        System.out.println("Request number is: " + reqNum);
        if(reqNum.contains("REQ"))
        {
            System.out.println("Order is placed successfully");
        }
        else{
            System.out.println("Order failed");
        }

        //Take a Snapshot of order placed page
        TakesScreenshot ts = (TakesScreenshot)driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File target = new File("./servicenowscreenshot/servicenow.png");
        FileUtils.copyFile(src, target);

        //close the browser
        driver.close();

    }

}
