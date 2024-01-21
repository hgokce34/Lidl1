package Lidl.US105.DeletingMyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class createAccount {
    public static void main(String[] args) {

        //Navigete website
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.lidl.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //Accept cookies
        WebElement acceptCookies= driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        acceptCookies.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //click white information
        WebElement clickX=driver.findElement(By.xpath("//img[@alt='close-white description']"));
        clickX.click();

        //click join Mylidl account to registering

        WebElement joinMylidl=driver.findElement(By.xpath("(//a[@class='clickable link clickable--theme-primary clickable--size-auto clickable--color-blue clickable--bold-weight'])[2]"));
        joinMylidl.click();

        //Write fistname
        WebElement firsName=driver.findElement(By.xpath("//input[@name='firstName']"));
        firsName.sendKeys("Hamza");

        //writelastname
        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastName']"));
        lastName.sendKeys("Gökçe");

        //writeEmailAdress
        WebElement emailAdress=driver.findElement(By.xpath("//input[@name='email']"));
        emailAdress.sendKeys("gokcehamza2934@gmail.com");

        //confirmEmailAdress
        WebElement confirmEmail=driver.findElement(By.xpath("//input[@name='confirm_email']"));
        confirmEmail.sendKeys("gokcehamza2934@gmail.com");

        //Write password to be account
        WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("123456qWerty");

        //show your password to be check

        WebElement showPassword=driver.findElement(By.xpath("//button[@class='show']"));
        showPassword.click();

        //write your phone number
        WebElement writephoneNumber=driver.findElement(By.xpath("//input[@name='phone']"));
        writephoneNumber.sendKeys("5451994540");

        //write zip code your location
        WebElement zipCode=driver.findElement(By.xpath("//input[@name='zip']"));
        zipCode.sendKeys("10000");

        //write your birthday

        WebElement birthDay=driver.findElement(By.xpath("//input[@placeholder='mm/dd/yyyy']"));
        birthDay.sendKeys("02/20/1994");

        //sumbit your account
        WebElement submitAccount=driver.findElement(By.xpath("//button[@type='submit']"));
        submitAccount.click();
        //driver.quit();
















        



    }
}
