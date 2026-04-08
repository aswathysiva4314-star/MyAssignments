package hooks;

// import java.time.Duration;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;


// import io.cucumber.java.After;
// import io.cucumber.java.AfterStep;
// import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import steps.BaseClass;

public class HooksImp extends BaseClass {
   
    // @Before
    // public void preCondition()
    // {
    //      ChromeOptions options = new ChromeOptions();
    //     options.addArguments("--guest");
    //     driver = new ChromeDriver(options);
    //     System.out.println("Driver value near hooks is: " + driver);
    //     driver.manage().window().maximize();
    //     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    //     driver.get("http://leaftaps.com/opentaps/control/login");
    // }

    // @After
    // public void postCondition()
    // {
    //     driver.close();
    // }

    @BeforeStep
    // public void reloadTheContent()
    // {
    //     driver.navigate().refresh();
    // }

    // @AfterStep
    public void slowMo() throws InterruptedException
    {
        Thread.sleep(500);
    }

}
