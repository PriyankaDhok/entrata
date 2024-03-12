package entrata.base;

import java.time.Duration;

import org.apache.log4j.BasicConfigurator; // Import Log4j BasicConfigurator for simple logging configuration
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager; // Import WebDriverManager for managing WebDriver binaries

public class BaseClass {

    public WebDriver driver;

    @BeforeClass
    public void loginTest() {
        // Configure basic logging using Log4j
        BasicConfigurator.configure();
        
        // Print current thread ID for debugging purposes
        System.out.println("Thread Id :" + Thread.currentThread().getId());
        
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        // Initialize ChromeDriver instance
        driver = new ChromeDriver();
        
        // Set implicit wait for WebDriver to wait for elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Maximize the browser window for consistent testing environment
        driver.manage().window().maximize();
        
        // Navigate to the target URL
        driver.get("https://www.entrata.com/");
    }

    public void testScrollDown() {
        // Scroll down to the bottom of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @AfterClass
    public void teardown() {
        // Perform any necessary cleanup
        
        // If WebDriver instance exists, quit the browser session
        if (driver != null) {
            driver.close();
        }
    }
}
