import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdateMyAccount {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Going to the main page
            driver.navigate().to("https://www.lidl.com/");
            // Maximizing window and setting implicit wait
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // Handling cookies
            WebElement cookiesButton = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
            cookiesButton.click();

            // Logging in
            WebElement signInBtn = driver.findElement(By.xpath("//a[text()='sign in']"));
            signInBtn.click();

            // Entering credentials
            WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
            emailInput.sendKeys("polya3hus@gmail.com");
            WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
            passwordInput.click();
            passwordInput.sendKeys("LidlPassword123");

            WebElement signInButtonAfterInput = driver.findElement(By.xpath("//button[@class='clickable button sign-in clickable--theme-primary clickable--size-base clickable--color-blue clickable--bold-weight clickable--regular-font']"));
            signInButtonAfterInput.click();

            /*------------------------------ACCEPTANCE CRITERIA-------------------------------

            1. I should be able to access the account page by clicking on the "My
            Account" link in the top right corner of the page.
            */

            WebElement myAccountLinkDropDownList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='profile-dropdown-button-label']")));
            myAccountLinkDropDownList.click();

            WebElement myAccountLink = driver.findElement(By.xpath("//article[@class='profile-img-detail']"));
            myAccountLink.click();

            /*
            2. I should verify that the URL of the account page is
            "https://www.lidl.com/profile/general"
            */

            String expectedURL = "https://www.lidl.com/profile/general";
            String actualURL = driver.getCurrentUrl();
            if (expectedURL.equals(actualURL)) {
                System.out.println("TEST PASSED, the URL is right.");
            } else {
                System.out.println("TEST FAILED, the URL is wrong.");
            }

            /*
            3. I should be able to update my first and last name by clicking the
            "Edit Account" button.
            Updated first and last name are correctly displayed in my account.
            */

            WebElement firstName = driver.findElement(By.xpath("//input[@value='Polina']"));
            firstName.sendKeys("i");
            if (firstName.isDisplayed()) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED");
            }

            WebElement lastName = driver.findElement(By.xpath("//input[@value='Khusnutdinova']"));
            lastName.sendKeys("i");
            if (lastName.isDisplayed()) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED");
            }

            /*
            4. I should be able to save the updates by clicking the "Save" button,
            I should receive the message "Profile updated successfully".
            */

            WebElement saveButton = driver.findElement(By.xpath("//div[@class='row row-reverse profile-save']"));
            saveButton.click();

            WebElement profileUpdateMessage = driver.findElement(By.xpath("//p[@aria-live='assertive']"));
            if (profileUpdateMessage.isDisplayed()) {
                System.out.println("TEST PASSED [PROFILE UPDATED SUCCESSFULLY]");
            } else {
                System.out.println("TEST FAILED [PROFILE HAS NOT BEEN UPDATED]");
            }

            /*
            5. I should be able to see my updated username in the
            top right corner of the page.
            */

            WebElement updatedUsername = driver.findElement(By.xpath("//h3[@class='title-3']"));
            if (updatedUsername.isDisplayed()) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}


