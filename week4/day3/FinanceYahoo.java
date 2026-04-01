package week4.day3;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FinanceYahoo {
public static final String YELLOW = "\u001B[33m";
public static final String RESET = "\u001B[0m";
    public static void main(String[] args) throws InterruptedException {

        // Precondition
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://finance.yahoo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Hover Action
        WebElement marketsTab = (driver.findElement(By.xpath("//div[text()='Markets']/parent::a")));
        Actions action = new Actions(driver);
                action
                .moveToElement(marketsTab).pause(Duration.ofSeconds(2))
                .moveToElement(driver.findElement(By.xpath("(//span[text()='Crypto']/parent::a)[2]"))).pause(2000)
                .click(driver.findElement(By.xpath("(//span[text()='Most active']/parent::a)[2]")))
                .perform();

        // print the crypto currency names from the table using specific row and column
        System.out.println(YELLOW + "Crypto currency names: " + RESET);
        // identify table
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement table = driver.findElement(By.xpath("//table"));
        wait.until(ExpectedConditions.visibilityOf(table));

        // identify rows
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

        //print the crypto currency names
        for (int i = 1; i <= rows.size(); i++) {
            String name = driver
                    .findElement(By.xpath("//tbody/tr[" + i + "]/td[@data-testid-cell='companyshortname.raw']/div"))
                    .getText();
            System.out.println(name);
        }

        // Print the crypto currency names using List
        // List<WebElement> cryptoNames = driver.findElements(By.xpath("//td[@data-testid-cell='companyshortname.raw']/div"));
        // for (WebElement name : cryptoNames) {

        // System.out.println(name.getText());
        // }

        Thread.sleep(2000);
        driver.close();
    }
}
