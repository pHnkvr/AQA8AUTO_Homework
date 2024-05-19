package homework3;

import homework1.task1.DriverInit;
import homework1.task1.Urls;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;


public class Scenario {
    private class Locators{
        private static final By googleSearchPlaceholder = By.xpath("//textarea[@class='gLFyf']");
        private static final By createAccountPage = By.xpath("(//h3[contains(text(),'Create account')])[1]");
        private static final By alertsDemoPage = By.xpath("//h3[contains(text(),'AlertsDemo')]");
        private static final By firstName = By.id("fname");
        private static final By lastName = By.id("lname");
        private static final By submitButton = By.xpath("//input[@value='Submit']");
        private static final By firstNameGuinness = By.id("FirstName");
        private static final By lastNameGuinness = By.id("LastName");
        private static final By dateOfBirthDay = By.id("DateOfBirthDay");
        private static final By dateOfBirthMonth = By.id("DateOfBirthMonth");
        private static final By dateOfBirthYear = By.id("DateOfBirthYear");
        private static final By country = By.id("Country");
        private static final By selectCountry = By.xpath("//select[@class='input-large create-application-name']");
        private static final By city = By.id("State");
        private static final By email = By.id("EmailAddress");
        private static final By confirmEmail = By.id("ConfirmEmailAddress");
        private static final By password = By.id("Password");
        private static final By confirmPassword = By.id("ConfirmPassword");
        private static final By resultOfPasswords = By.xpath("//span[contains(text(),'do not match')]");
        private static final By firstAllertButton = By.xpath("//button[@onclick='alertFunction()']");
        private static final By secondAllertButton = By.xpath("//button[@onclick='confirmFunction()']");
        private static final By thirdAllertButton = By.xpath("//button[@onclick='promptFunction()']");
        private static final By resultPopupbox = By.id("output");



    }
    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.googleSearchPage);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement search = driver.findElement(Locators.googleSearchPlaceholder);
        search.sendKeys(Urls.guinnessWorldRegister);
        search.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.createAccountPage));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.createAccountPage));
        WebElement firstResult = driver.findElement(Locators.createAccountPage);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(firstResult).keyUp(Keys.CONTROL).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.googleSearchPlaceholder));
        search = driver.findElement(Locators.googleSearchPlaceholder);
        search.clear();
        search.sendKeys(Urls.secondSearchFind);
        search.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.alertsDemoPage));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.alertsDemoPage));
        WebElement secondResult = driver.findElement(Locators.alertsDemoPage);
        new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(secondResult).keyUp(Keys.CONTROL).build().perform();

        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit" );
        wait.until(ExpectedConditions.titleIs("W3Schools Tryit Editor"));
        driver.switchTo().frame("iframeResult");
        driver.findElement(Locators.firstName).clear();
       driver.findElement(Locators.firstName).sendKeys("Ilya");
       driver.findElement(Locators.lastName).clear();
       driver.findElement(Locators.lastName).sendKeys("Travin");
       driver.findElement(Locators.submitButton).click();
       Set<String> tabs = driver.getWindowHandles();
       for(String tab:tabs){
           driver.switchTo().window(tab);
           String title = driver.getTitle();
           if (title.equals("Create account | Guinness World Records")){
           break;
           }

       }
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("ez-accept-all"))).click(); выписал на случай, если кукиз вылетят, у меня на браузере Brave не выскакивали
        driver.findElement(Locators.firstNameGuinness).sendKeys("Ilya");
        wait.until(ExpectedConditions.textToBePresentInElementValue(Locators.firstNameGuinness,"Ilya"));
        driver.findElement(Locators.lastNameGuinness).sendKeys("Travin");
        driver.findElement(Locators.dateOfBirthDay).sendKeys("09");
        driver.findElement(Locators.dateOfBirthMonth).sendKeys("12");
        driver.findElement(Locators.dateOfBirthYear).sendKeys("1998");
        WebElement element = driver.findElement(Locators.country);
        Select createAccountOnGuinnessPage = new Select(element);
        createAccountOnGuinnessPage.selectByVisibleText("Ukraine");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(Locators.selectCountry));
        driver.findElement(Locators.city).sendKeys("Kharkiv");
        driver.findElement(Locators.email).sendKeys("Ilya@mail.com");
        driver.findElement(Locators.confirmEmail).sendKeys("Ilya@mail.com");
        driver.findElement(Locators.password).sendKeys("password131211");
        driver.findElement(Locators.confirmPassword).sendKeys("password131210");
        new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.resultOfPasswords));
        System.out.println(driver.findElement(Locators.resultOfPasswords).getText());

        for(String tab:tabs){
            driver.switchTo().window(tab);
            String title = driver.getTitle();
            if (title.equals("AlertsDemo - H Y R Tutorials")){
                break;
            }
        }
        driver.findElement(Locators.firstAllertButton).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println(driver.findElement(Locators.resultPopupbox).getText());
        driver.findElement(Locators.secondAllertButton).click();
        alert.dismiss();
        System.out.println(driver.findElement(Locators.resultPopupbox).getText());
        driver.findElement(Locators.thirdAllertButton).click();
        String textToEnter = " Final step of this task";
        alert.sendKeys(textToEnter);
        alert.accept();
        System.out.println(driver.findElement(Locators.resultPopupbox).getText());
        driver.quit();
    }

}
