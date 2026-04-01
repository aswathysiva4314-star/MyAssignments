package week4.day3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnapDealActions {
     public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static void main(String[] args) throws InterruptedException, IOException {
         // Precondition
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.snapdeal.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Go to "Men's Fashion" and then Go to "Sports Shoes".
        Actions action = new Actions(driver);
        action.moveToElement( driver.findElement(By.xpath("//div[@id='tab-category-0']/div"))).perform();
        action.moveToElement(driver.findElement(By.xpath("//div[text()='Sports Shoes']"))).click().perform();

        //Get the count of sports shoes
        String rawSportsShoesTotalCount = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
        String cleanSportsShoesCount = rawSportsShoesTotalCount.replace("(","").replace(")","");
        System.out.println("Total count of sports shoes: " + YELLOW + cleanSportsShoesCount + RESET);

        //Click on "Training Shoes"
        driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

        //Sort the products by "Low to High".
        driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
        driver.findElement(By.xpath("//li[@data-sorttype=\"plth\"]")).click();
        
        //Verify sorting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading']")));
         wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='lfloat product-price']")));
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));

        //Thread.sleep(3000);
       // List<WebElement> prices = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
        List<Integer> priceList = new ArrayList<>();
        for (WebElement price : prices) { 
            String text = price.getText().replace("Rs. " , "").replace("," , "");
            priceList.add(Integer.parseInt(text));
        }
        boolean sorted = true;
        for(int i= 0; i< priceList.size() - 1; i++)
        {
            //System.out.println(priceList.get(i));
            if(priceList.get(i) > priceList.get(i+1))
            {
                sorted = false;
                break;
            }
    }
    if(sorted == true)
    {
        System.out.println(GREEN + "SUCCESS ! : items sorted correctly" + RESET);
    }
    else
    {
        System.out.println(RED + "FAIL ! : items sorted incorrectly" + RESET);
    }

    //Select any price range ex:(500-700)
    WebElement from = driver.findElement(By.name("fromVal"));
    from.clear();
    from.sendKeys("500");
    WebElement to = driver.findElement(By.name("toVal"));
    to.clear();
    to.sendKeys("700");
    driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();

    //Filter by any colour
    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement color = wait1.until( ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' White & Blue']/parent::label")));
    color.click();

    //verify all applied filters
    Thread.sleep(2000);
    WebElement appliedFilters =  driver.findElement(By.xpath("//div[@class='filters']"));
    String text = appliedFilters.getText();
    String[] parts = text.split("Color");
    System.out.println("Applied filters: ");
    System.out.println(YELLOW + parts[0].trim() + RESET); // Price part
    System.out.println(YELLOW + "Color" + parts[1].trim() + RESET); // Color part

    if(appliedFilters.getText().contains("Rs.") && 
    appliedFilters.getText().contains("Color"))
    {
        System.out.println(GREEN + "SUCCESS ! Filters applied correctly" + RESET);
    }
    else{
        System.out.println(RED + "FAIL ! Filters applied incorrectly" + RESET);
    }
//Mouse hover on the first resulting "Training Shoes
action.moveToElement(driver.findElement(By.xpath("//img[@class='product-image wooble']"))).perform();
//Click the "Quick View" button
driver.findElement(By.xpath("//div[contains(text(),'Quick ')]")).click();

//Print the cost and the discount percentage
Set<String> windows = driver.getWindowHandles();
String parent = driver.getWindowHandle();
for (String window : windows) {
    if(!window.equals(parent))
    {
        driver.switchTo().window(window);
    }
    
}
WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement costElement = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='payBlkBig']")));
String cost = costElement.getText();
System.out.println(YELLOW + "Cost is: " + cost + RESET);
String discount = driver.findElement(By.xpath("//span[contains(@class,'percent-desc')]")).getText();
System.out.println(YELLOW + "Discount percentage: " + discount + RESET);

//Take a snapshot of the shoes
TakesScreenshot ts = (TakesScreenshot) driver;
File src = ts.getScreenshotAs(OutputType.FILE);
File target = new File("./snapdealscreenshot/snapdeal.png");
FileUtils.copyFile(src, target);

//Close current window (Quick View popup)
driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
//Close browser
driver.quit();

}

}
