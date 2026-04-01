package week4.day3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonActionsClassroom {
    public static void main(String[] args) throws IOException {
         // Precondition
        ChromeDriver driver = new ChromeDriver();
         driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Locate "Conditions of Use and Sale"
        WebElement conditionLink = driver.findElement(By.xpath("//a[contains(text(),'Conditions of Use')]"));
        Actions action = new Actions(driver);
        // Scroll to the element
        action.scrollToElement(conditionLink).perform();
        // Get text
        String text = conditionLink.getText();
        System.out.println("Text is " + text);
        // Take screenshot
          File src = driver.getScreenshotAs(OutputType.FILE);
          File target = new File("./snap/amazon.png");
          FileUtils.copyFile(src, target);
        driver.close();




    }

}
