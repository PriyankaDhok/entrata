package entrata.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import entrata.base.BaseClass;

public class SignIn extends BaseClass {
	
	@Test(priority = 1)
	// Decline cookies
    public void declineCookies() throws InterruptedException {
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Find and click on the decline cookies button
        WebElement cookiesDecline = driver.findElement(By.xpath("//*[@id='rcc-decline-button']"));
        cookiesDecline.click();
	}
  
	@Test(priority = 2)
	// Sign in
    public void signIn() throws InterruptedException {
        // Find and click on the sign-in button
        WebElement signInButton = driver.findElement(By.xpath("(//*[@href='/sign-in'])[1]"));
        signInButton.click();
        // Verify current URL matches the expected URL
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.entrata.com/sign-in";
        Assert.assertEquals(actualUrl, expectedUrl, "URLs don't match");

        // Perform additional steps here (if any)
        
        // Navigate back to the home page
        driver.navigate().to("https://www.entrata.com/");
    }
}
