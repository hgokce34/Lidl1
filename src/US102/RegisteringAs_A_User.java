package US102;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisteringAs_A_User {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        //Navigate to the Lidl homepage
        driver.get("https://www.lidl.com");
        driver.manage().window().maximize();
        //Step 1 : Click on the "Sign In " button
        WebElement signInButton = driver.findElement(By.xpath("(//button[@id='onetrust-reject-all-handler'])"));
        signInButton.click();
        //Step 2 : By clicking on the "join MyLidl" button
        WebElement joinButton = driver.findElement(By.xpath("(//a[@class='clickable link clickable--theme-primary clickable--size-auto clickable--color-blue clickable--bold-weight'])[2]"));
        joinButton.click();
        //Step 3 : verify tha URL of the Registration page is "https://www.lild.com.register"
        String expectedURL = "https://www.lidl.com/register";
        String actualURL = driver.getCurrentUrl();
        if (actualURL.equals(expectedURL)){
            System.out.println("Registration page URL is correct");
        }else {
            System.out.println("Registration page URL is incorrect");
        }
        //Step 4 : Provide the user information
        WebElement firstNameInput = driver.findElement(By.xpath("(//label[@class='MuiFormLabel-root MuiInputLabel-root MuiInputLabel-formControl MuiInputLabel-animated'])"));
        firstNameInput.sendKeys("Khalid");

        WebElement secondNameInput = driver.findElement(By.xpath("(//input[@name='lastName'])"));
        secondNameInput.sendKeys("Hassan");

        //Step 5 : Case 1. when entering a Valid Email address
        WebElement AvalidEmialAddress = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiInput-input'])[1]"));
        AvalidEmialAddress.sendKeys("KhalidbiinAhmed9@gmail.com");

        //Step 6 : Case 2. when entering an already registerd email address
        AvalidEmialAddress.clear();

        AvalidEmialAddress.sendKeys("KhalidbinAhmed25@Gmail.com");


        //Step 7:  Case 3: Valid email address and matching confirmation email
        AvalidEmialAddress.clear();
        AvalidEmialAddress.sendKeys("KhalidbinAhmed25@Gmail.com");
        WebElement confirmEmailAddress = driver.findElement(By.name("(//input[@name='confirm_email'])"));
        confirmEmailAddress.clear();
        confirmEmailAddress.sendKeys("KhalidbinAhmed25@Gmail.com");

//
//        //Step 8: Case 4: Valid phone number
//        WebElement phoneNumber = driver.findElement(By.id("(//input[@id='input14'])"));
//        phoneNumber.sendKeys("1234567890");
//
//        // Step 9 : Case 5: Already registered phone number
//        phoneNumber.clear();
//        phoneNumber.sendKeys("1111111111");
//
//
//        //Step 10: Case 6: Valid zip code
//        WebElement zipCodeField = driver.findElement(By.id("(//input[@class='MuiInputBase-input MuiInput-input'])[1]"));
//        zipCodeField.sendKeys("12345");
//
//        // Step 11: Case 7: Zip code with fewer than five digits
//        zipCodeField.clear();
//        zipCodeField.sendKeys("1234");
//
//        //Step 12  Case 8: Valid birthday
//        WebElement birthdayField = driver.findElement(By.id("(//input[@id='date-picker-dialog'])"));
//        birthdayField.sendKeys("01/01/1995");
//
//        // Step 13 : Case 9: Birthday over 100 years old
//        birthdayField.clear();
//        birthdayField.sendKeys("01/01/1900");
//
//        // Step 14: Case 10: Birthday under 13 years old
//        birthdayField.clear();
//        birthdayField.sendKeys("01/01/2015");
//
//        // Step 15: Case 11: Valid address, city, and state
//        WebElement addressLine = driver.findElement(By.id("(//input[@class='MuiInputBase-input MuiInput-input'])[1]"));
//        addressLine.sendKeys("123 Main St");
//
//        WebElement city = driver.findElement(By.id("(//input[@name='mailingCity'])[1]"));
//        city.sendKeys("New York");
//
//        WebElement stateField = driver.findElement(By.id("(//select[@class='MuiNativeSelect-root MuiNativeSelect-select MuiInputBase-input MuiInput-input'])"));
//        stateField.sendKeys("NY");
//
//        // Submit the registration form
//        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
//        submitButton.click();
//
//        // Wait for the registration process to complete (add an explicit wait if needed)
//
//        // Handle success and error messages
//        if (driver.getCurrentUrl().equals("https://www.lidl.com/registration-success")) {
//            System.out.println("Registration successful!");
//        } else {
//            WebElement errorMessage = driver.findElement(By.className("error-message"));
//            String errorText = errorMessage.getText();
//            System.out.println("Registration failed. Error message: " + errorText);
//        }
//        driver.quit();
    }
}






