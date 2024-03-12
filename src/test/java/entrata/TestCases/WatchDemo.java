package entrata.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import entrata.base.BaseClass;

public class WatchDemo extends BaseClass {

    @Test(priority = 1)
    // Decline cookies
    public void declineCookies() throws InterruptedException {
        // Set implicit wait for better performance
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement cookiesDecline = driver.findElement(By.xpath("//*[@id='rcc-decline-button']"));
        cookiesDecline.click();
    }

    @Test(priority = 2)
    //  Navigating to the demo video and back to the home page
    public void testNavigateToDemoVideoAndBack() throws InterruptedException {
        //"Watch Demo" button
        WebElement watchDemoButton = driver.findElement(By.linkText("Watch Demo"));
        watchDemoButton.click();
        // Wait for page load
        Thread.sleep(2000);
        // Verify the current URL matches the expected URL
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://go.entrata.com/watch-demo.html";
        Assert.assertEquals(actualUrl, expectedUrl, "URLs don't match");
    }

    @Test(priority = 3)
    // Verifying and testing the page title
    public void testPageTitle() {
        // Navigating to the demo video page
        driver.get("https://go.entrata.com/watch-demo.html");
        // Page title verified by its text 
        WebElement element = driver.findElement(By.xpath("//h1[normalize-space()='Optimize Property Management with One Platform']"));
        String actualText = element.getText();
        String expectedText = "Optimize Property Management with One Platform";
        Assert.assertEquals(actualText, expectedText, "Texts don't match");
    }

    @Test(priority = 4)
    //automating watch demo page and enter data in every field
    public void testPageElements() throws InterruptedException {
        // Navigate to the demo video page
    	Thread.sleep(2000);
        driver.get("https://go.entrata.com/watch-demo.html");
        
        // Enter first name

        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Priyanka");
    
        Thread.sleep(2000);
        // Enter last name
        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Dhok");

        Thread.sleep(2000);
        // Enter email name
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("priyankadhok7020@gmail.com");
        
        Thread.sleep(2000);
        // Enter company name
        WebElement companyName = driver.findElement(By.id("Company"));
        companyName.sendKeys("Rabbit and tortoise technology solutions");
        
        Thread.sleep(2000);
        // Enter phone no.
        WebElement phoneNumber = driver.findElement(By.id("Phone"));
        phoneNumber.sendKeys("7020926211");
        
        Thread.sleep(2000);
        //select value from dropdown
        WebElement count = driver.findElement(By.xpath("//select[@id='Unit_Count__c']"));
        Select unitCount = new Select (count);
        unitCount.selectByVisibleText("1 - 10");
        
        Thread.sleep(2000);
        //enter job titile
        WebElement jobTitle = driver.findElement(By.id("Title"));
        jobTitle.sendKeys("Software Test Engineer");
        
        Thread.sleep(2000);
        //select value from dropdown
        WebElement iAm = driver.findElement(By.xpath("//select[@id='demoRequest']"));
        Select roleIam =new Select(iAm);
        roleIam.selectByValue("an Owner/Operator or Property Manager");
        
     //   Avoiding Form submission
     //   driver.findElement(By.xpath("//button[normalize-space()='WATCH DEMO']")).click();
        
        Thread.sleep(2000);
      //  after entering data and avoiding submission user navigate back to the home page
        driver.navigate().to("https://www.entrata.com/");
    }
}
