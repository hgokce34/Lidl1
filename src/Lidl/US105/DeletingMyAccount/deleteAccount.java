package Lidl.US105.DeletingMyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class deleteAccount {
    public static void main(String[] args) {

        //navigate lidl website

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lidl.com");
        driver.manage().window().maximize();

        //Accept cookies
        WebElement acceptCookies= driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        acceptCookies.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //click white information
        WebElement clickX=driver.findElement(By.xpath("//img[@alt='close-white description']"));
        clickX.click();

        //click sing button in the website
        WebElement clickSingButton=driver.findElement(By.xpath("(//a[@class='clickable link clickable--theme-primary clickable--size-auto clickable--color-blue clickable--bold-weight'])[1]"));
        clickSingButton.click();

        //Write your email address
        WebElement singAccount = driver.findElement(By.xpath("//input[@type='email']"));
        singAccount.sendKeys("gokcehamza2934@gmail.com");

        //write your password
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("123456qWerty");

        //clickSıngButton
        WebElement clickButton=driver.findElement(By.xpath("//button[@type='submit']"));
        clickButton.click();

        //click accountDropdown for deleted your account
        WebElement accountDropdown=driver.findElement(By.xpath("//span[@class='profile-dropdown-button-label ']"));
        accountDropdown.click();

        //clickMyAccount
        WebElement clickAccount=driver.findElement(By.xpath("//div[@class='info']"));
        clickAccount.click();

        //clickAccountManagement
        WebElement accountManagement=driver.findElement(By.xpath("(//li[@class='tab'])[5]"));
        accountManagement.click();

        //deleteAccount
        WebElement deleteAccount=driver.findElement(By.xpath("//button[@type='submit']"));
        deleteAccount.click();

        //confirmationButton

        WebElement confirmationButton=driver.findElement(By.xpath("//button[@data-test='confirmation-button']"));
        confirmationButton.click();

        driver.quit();







    }
}
