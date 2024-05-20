package homework3;

import org.openqa.selenium.By;

public class Locators {
    static final By googleSearchPlaceholder = By.xpath("//textarea[@class='gLFyf']");
    static final By createAccountPage = By.xpath("(//h3[contains(text(),'Create account')])[1]");
    static final By alertsDemoPage = By.xpath("//h3[contains(text(),'AlertsDemo')]");
    static final By firstName = By.id("fname");
    static final By lastName = By.id("lname");
    static final By submitButton = By.xpath("//input[@value='Submit']");
    static final By firstNameGuinness = By.id("FirstName");
    static final By lastNameGuinness = By.id("LastName");
    static final By dateOfBirthDay = By.id("DateOfBirthDay");
    static final By dateOfBirthMonth = By.id("DateOfBirthMonth");
    static final By dateOfBirthYear = By.id("DateOfBirthYear");
    static final By country = By.id("Country");
    static final By selectCountry = By.xpath("//select[@class='input-large create-application-name']");
    static final By city = By.id("State");
    static final By email = By.id("EmailAddress");
    static final By confirmEmail = By.id("ConfirmEmailAddress");
    static final By password = By.id("Password");
    static final By confirmPassword = By.id("ConfirmPassword");
    static final By resultOfPasswords = By.xpath("//span[contains(text(),'do not match')]");
    static final By firstAllertButton = By.xpath("//button[@onclick='alertFunction()']");
    static final By secondAllertButton = By.xpath("//button[@onclick='confirmFunction()']");
    static final By thirdAllertButton = By.xpath("//button[@onclick='promptFunction()']");
    static final By resultPopupbox = By.id("output");
}