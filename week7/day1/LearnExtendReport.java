package week7.day1;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnExtendReport {
public static void main(String[] args) throws IOException {

        //  Step 1: Create unique file name using timestamp
        String fileName = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("EEE_dd_MMM_HH_mm_ss_a"));

        // Step 2: Set report path
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/" + fileName + "_result.html");
        reporter.setAppendExisting(false);

        //  Step 3: Create ExtentReports object
        ExtentReports extent = new ExtentReports();

        //  Step 4: Attach reporter
        extent.attachReporter(reporter);

        //  Step 5: Create Test
        ExtentTest test = extent.createTest("Login Test", "Verify login functionality");

        // Add details
        test.assignAuthor("Aswathy");
        test.assignCategory("Smoke Testing");

        // Logs
        test.pass("Browser launched successfully");
        test.pass("Username entered successfully");
        test.pass("Password entered successfully");
        test.fail("Login button not clickable");

        // Add screenshot
        test.fail("Screenshot",
                MediaEntityBuilder.createScreenCaptureFromPath("../snap/amazon.png").build());

        //Step 6: Flush report
        extent.flush();

        System.out.println("Report generated successfully!");
    }
}
