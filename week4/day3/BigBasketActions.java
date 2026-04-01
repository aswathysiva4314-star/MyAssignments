package week4.day3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigBasketActions {

    public static void main(String[] args) throws InterruptedException, IOException {
        // Precondition
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.bigbasket.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Click on Shop by Category
        driver.findElement(By.xpath("(//span[text()='Shop by'])[2]")).click();

        //Mouse over Foodgrains, Oil & Masala
        Actions action = new Actions(driver);
        // Thread.sleep(2000);
        // action  
        //        .moveToElement(driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]")))
        //        .pause(1000)
        //        .moveToElement(driver.findElement(By.xpath("//a[text()='Rice & Rice Products']")))
        //        .pause(1000)
        //        .click(driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']")))
        //        .perform();

        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"))).pause(2000).perform();
        action.moveToElement(driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"))).pause(2000).perform();
        action.moveToElement(driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']"))).click().perform();

        //Filter the results by selecting the brand "bb Royal
        driver.findElement(By.xpath("//input[@id='i-bbRoyal']")).click();
        
        //Click on "Tamil Ponni Boiled Rice
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
WebElement productImg = wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("//img[contains(@title, 'Tamil Ponni Boiled Rice')]")));
productImg.click();

//Select the 5 Kg bag
Thread.sleep(2000);
Set<String> windows = driver.getWindowHandles();
 String parent = driver.getWindowHandle();
for (String window : windows) {
    if(!window.equals(parent))
    {
        driver.switchTo().window(window);
    }
    
}
 driver.findElement(By.xpath("//span[text()='5 kg']/ancestor::div[contains(@class, 'justify-start')]")).click();

 //Check and note the price of the rice
 String rawPrice = driver.findElement(By.xpath("//table//td")).getText();
 String cleanPrice = rawPrice.replaceAll("[^0-9]", "");
 System.out.println("Price of rice: Rs." + cleanPrice);

 //Click "Add" to add the bag to your cart.
 driver.findElement(By.xpath("//button[contains(text(),'Add to basket')]")).click();

 //Verify the success message that confirms the item was added to your cart.
 Thread.sleep(2000);
 String expectedMsg = "An item has been added to your basket successfully";
 String actualMsg = driver.findElement(By.id("toast")).getText();
 System.out.println("Message: " + actualMsg);
 if(expectedMsg.equals(actualMsg))
 {
    System.out.println("SUCCESS ! Item has been added to cart");
 }
 else
 {
    System.out.println("FAIL ! Item has not been added");
 }
 //Take screenshot
 File src = driver.getScreenshotAs(OutputType.FILE);
        File dest = new File("./bigbasket/product.png");
        dest.getParentFile().mkdirs();
        FileUtils.copyFile(src, dest);

        Thread.sleep(2000);
        driver.quit();

    }
}
