import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Update_My_Account_JUnit {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.lidl.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void updateAccountTest() {
        // Accept cookies
        WebElement cookiesButton = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookiesButton.click();

        // Log in
        WebElement signInBtn = driver.findElement(By.xpath("//a[text()='sign in']"));
        signInBtn.click();
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        emailInput.sendKeys("polya3hus@gmail.com");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.click();
        passwordInput.sendKeys("LidlPassword123");
        WebElement signInButtonAfterInput = driver.findElement(By.xpath("//button[@class='clickable button sign-in clickable--theme-primary clickable--size-base clickable--color-blue clickable--bold-weight clickable--regular-font']"));
        signInButtonAfterInput.click();

        // Access account page
        WebElement myAccountLinkDropDownList = driver.findElement(By.xpath("//span[text()='my account']"));
        myAccountLinkDropDownList.click();
        WebElement myAccountLink = driver.findElement(By.xpath("//article[@class='profile-img-detail']"));
        myAccountLink.click();

        // Verify URL
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String expectedURL = "https://www.lidl.com/profile/general";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals("URL did not match expected value", expectedURL, actualURL);

        // Update first and last name
        WebElement firstName = driver.findElement(By.xpath("//input[@value='Polina']"));
        firstName.sendKeys("i");
        WebElement lastName = driver.findElement(By.xpath("//input[@value='Khusnutdinova']"));
        lastName.sendKeys("i");

        // Save updates
        WebElement saveButton = driver.findElement(By.xpath("//div[@class='row row-reverse profile-save']"));
        saveButton.click();

        // Verify update message
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement profileUpdateMessage = driver.findElement(By.xpath("//p[@aria-live='assertive']"));
        Assert.assertFalse("Profile update message not displayed", profileUpdateMessage.isDisplayed());


        firstName.sendKeys("Polina");

        lastName.sendKeys("Khusnutdinova");

        // Save updates

        saveButton.click();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
