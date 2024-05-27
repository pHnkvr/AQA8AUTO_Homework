package homework2.task2;

import homework1.task1.DriverInit;
import homework1.task1.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragNDropActions {
    private class Locators{
        private static final By debitAmount = By.xpath("(//a[@class='button button-orange'])[2]");
        private static final By creditAmount = By.xpath("(//li[@id='fourth'])[2]");
        private static final By chooseBank = By.xpath("(//a[@class='button button-orange'])[5]");
        private static final By chooseSales = By.xpath("(//a[@class='button button-orange'])[6]");
        private static final By perfectButton = By.xpath("//a[@class='button button-green'][contains(text(),'Perfect!')]");
        private static final By debitAmountPlaceholder = By.id("amt7");
        private static final By creditAmountPlaceholder = By.id("amt8");
        private static final By accountDebitPlaceholder = By.id("bank");
        private static final By accountCreditPlaceholder = By.id("loan");

    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.siteForDragNDrop);
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        //actions.clickAndHold(driver.findElement(Locators.debitAmount)).moveToElement(driver.findElement(Locators.debitAmountPlaceholder)).release().build().perform();
      // actions.clickAndHold(driver.findElement(Locators.creditAmount)).moveToElement(driver.findElement(Locators.creditAmountPlaceholder)).release().build().perform();
        actions.dragAndDrop(driver.findElement(Locators.debitAmount), driver.findElement(Locators.debitAmountPlaceholder)).perform();
        actions.dragAndDrop(driver.findElement(Locators.creditAmount), driver.findElement(Locators.creditAmountPlaceholder)).perform();
        actions.dragAndDrop(driver.findElement(Locators.chooseBank),driver.findElement(Locators.accountDebitPlaceholder)).perform();
        actions.dragAndDrop(driver.findElement(Locators.chooseSales),driver.findElement(Locators.accountCreditPlaceholder)).perform();
        actions.click(driver.findElement(Locators.perfectButton));
        if (driver.findElement(Locators.perfectButton).isDisplayed()){
            System.out.println("Perfect!");
        }
        driver.quit();
    }

}
