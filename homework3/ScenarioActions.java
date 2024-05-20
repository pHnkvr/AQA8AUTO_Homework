package homework3;

import homework1.task1.Urls;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class ScenarioActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public ScenarioActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void executeScenario() {
        navigateToGoogleSearch();
        openFirstSearchResult();
        searchSecondUrl();
        fillForm();
        switchToFirstTab();
        guinnessPage();
        switchToSecondTab();
        handleAlerts();
        driver.quit();
    }

    private void navigateToGoogleSearch() {
        driver.get(Urls.googleSearchPage);
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.googleSearchPlaceholder));
        search.sendKeys(Urls.guinnessWorldRegister);
        search.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.createAccountPage));
    }

    private void openFirstSearchResult() {
        WebElement firstResult = driver.findElement(Locators.createAccountPage);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(firstResult).keyUp(Keys.CONTROL).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.googleSearchPlaceholder));
    }

    private void searchSecondUrl() {
        WebElement search = driver.findElement(Locators.googleSearchPlaceholder);
        search.clear();
        search.sendKeys(Urls.secondSearchFind);
        search.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.alertsDemoPage));
        WebElement secondResult = driver.findElement(Locators.alertsDemoPage);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(secondResult).keyUp(Keys.CONTROL).build().perform();
    }


    private void fillForm() {
        driver.get(Urls.W3schoolPage);
        wait.until(ExpectedConditions.titleIs("W3Schools Tryit Editor"));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
        driver.findElement(Locators.firstName).clear();
        driver.findElement(Locators.firstName).sendKeys("Ilya");
        driver.findElement(Locators.lastName).clear();
        driver.findElement(Locators.lastName).sendKeys("Travin");
        driver.findElement(Locators.submitButton).click();

    }
    private void switchToFirstTab(){
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='w3-container w3-large w3-border']"),"fname=Ilya&lname=Travin "));
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            driver.switchTo().window(tab);
            String title = driver.getTitle();
            if (title.equals("Create account | Guinness World Records")) {
                break;
            }
        }
    }


    private void guinnessPage(){
        driver.findElement(Locators.firstNameGuinness).sendKeys("Ilya");
        wait.until(ExpectedConditions.textToBePresentInElementValue(Locators.firstNameGuinness, "Ilya"));
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
        new Actions(driver).sendKeys(Keys.ENTER).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.resultOfPasswords));
        System.out.println(driver.findElement(Locators.resultOfPasswords).getText());
    }

    private void switchToSecondTab() {
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            driver.switchTo().window(tab);
            String title = driver.getTitle();
            if (title.equals("AlertsDemo - H Y R Tutorials")) {
                break;
            }
        }
    }

    private void handleAlerts() {
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
    }
}