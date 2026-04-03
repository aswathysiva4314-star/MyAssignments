package week5.marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tatacliq {
    public static void main(String[] args) throws InterruptedException, IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.navigate().to("https://www.tatacliq.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // MouseHover on 'Brands'
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//div[text()='Brands']")))
                .pause(1000).perform();
        // MouseHover on 'Watches & Accessories'
        action.moveToElement(driver.findElement(By.xpath("//div[text()='Watches & Accessories']"))).pause(1000)
                .perform();
        // Choose the first option from the'Featured brands'
        action.moveToElement(driver.findElement(By.xpath("//div[text()='Featured brands']/following-sibling::div[1]")))
                .click().perform();

        // Select sortby: New Arrivals
        Thread.sleep(2000);
        WebElement selNewArrival = driver.findElement(By.className("SelectBoxDesktop__hideSelect"));
        Select selectObj = new Select(selNewArrival);
        selectObj.selectByIndex(3);

        // choose men from catagories filter
        driver.findElement(By.xpath("//div[text()='Men']/preceding-sibling::div")).click();

        // print all price of watches
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading']")));
        wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ProductDescription__priceHolder']/h3")));
        List<WebElement> watchPrices = driver
                .findElements(By.xpath("//div[@class='ProductDescription__priceHolder']/h3"));
        String price1 = watchPrices.get(0).getText().replaceAll("[^0-9]", "");
        // print all price of watches
        System.out.println("Price of watches: ");
        for (WebElement price : watchPrices) {
            System.out.print(price.getText().replaceAll("[^0-9]", "") + " ");
        }

        // click on the first resulting watch
        driver.findElement(By.xpath("//div[contains(@class,'ProductModule__dummyDiv')]")).click();

        // compare two price are similar
        Set<String> windows = driver.getWindowHandles();
        String parent = driver.getWindowHandle();
        for (String window : windows) {

            if (!window.equals(parent)) {
                driver.switchTo().window(window);
                break;
            }
        }

        String price2 = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3")).getText()
                .replaceAll("[^0-9]", "");
        if (price1.equals(price2)) {
            System.out.println("\nPrices are same");
        } else {
            System.out.println("Prices are not same");
        }

        // click Add to cart and get count from the cart icon
        driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
        driver.findElement(By.xpath("//span[text()='GO TO BAG']")).click();

        String cartCount = driver.findElement(By.xpath("//div[text()='Qty']/following::span")).getText();
        System.out.println("Cart count is: " + cartCount);

        // Click on the cart
        driver.findElement(By.xpath("//div[@class='DesktopCheckout__button']")).click();

        // Take a snapshot of the resulting page.
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File target = new File("./tatacliqscreenshot/tatacliq.png");
        FileUtils.copyFile(src, target);

        // Close All the opened windows one by one.
        driver.findElement(By.xpath("//button[@title='Close']")).click();
        Set<String> fetchWindows = driver.getWindowHandles();

        for (String win : fetchWindows) {
            driver.switchTo().window(win);
            driver.close();
        }
    }

}
