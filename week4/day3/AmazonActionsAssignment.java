package week4.day3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonActionsAssignment {
    // ANSI Escape Codes for Colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) throws InterruptedException, IOException {

        // Precondition
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Initialize Action class
        Actions action = new Actions(driver);

        // Search for "oneplus 9 pro"
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        action.moveToElement(searchBox).click().sendKeys("oneplus 9 pro").perform();

        // click on search button
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

        // Get price of first product
        String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
        System.out.println(YELLOW + "Price of the first product: " + price + RESET);

        // Print the number of customer ratings for the first displayed product.
        String rawRating = driver.findElement(By.xpath("//a[contains(@class,'s-underline-link-text')]")).getText();
        String cleanRating = rawRating.replace("(", "").replace(")", "");
        System.out.println(YELLOW + "Rating count: " + cleanRating + RESET);

        // Click first text link of first image
        driver.findElement(By.xpath("//a/h2")).click();

        // switch to new window
        Set<String> windows = driver.getWindowHandles();
        String parent = driver.getWindowHandle();
        for (String win : windows) {
            if (!win.equals(parent)) {
                driver.switchTo().window(win);
            }
        }
        //Explicit Wait
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productTitle")));
        // take screenshot of product
        File src = driver.getScreenshotAs(OutputType.FILE);
        File dest = new File("./amazonscreenshot/product.png");
        dest.getParentFile().mkdirs();
        FileUtils.copyFile(src, dest);

        // click add to cart button
        driver.findElement(By.xpath("(//span[text()='Add to cart']/preceding-sibling::input)[2]")).click();
        // get cart subtotal and verify it
        String subTotal = driver
                .findElement(By.xpath("//div[@id='sw-subtotal']//span[contains(@class,'a-price-whole')]")).getText();
        System.out.println(YELLOW + "Subtotal : " + subTotal + RESET);
        if (subTotal.equals(price)) {
            System.out.println(GREEN + "STATUS:  MATCHED (Verification Sucessful)" + RESET);
        } else {
            System.out.println(RED + "STATUS:  FAILED (Price Mismatch!)" + RESET);
        }

        Thread.sleep(2000);
        driver.quit();

    }

}
