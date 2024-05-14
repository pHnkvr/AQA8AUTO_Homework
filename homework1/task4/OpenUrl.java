package homework1.task4;

import homework1.task1.DriverInit;
import homework1.task1.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OpenUrl {
    private static class Locators{

        private static final By placeholder = By.id("search_query_top");
        private static final By searchButton = By.name("submit_search");
        private static final By recordsFirst = By.xpath("(//div[@class='right-block'])[1]");
        private static final By modelSize = By.id("group_1");
        private static final By addToCart = By.xpath("//span[contains(text(), 'Add to cart')]");
        private static final By continueShopping = By.xpath("//i[@class='icon-chevron-left left']");
        private static final By categoryWomen = By.xpath("(//a[@class='sf-with-ul'])[1]");
        private static final By recordsSecond = By.xpath("//a[@class='product-name'][@title='Faded Short Sleeve T-shirts']");
        private static final By shoppingCart = By.xpath("//a[@href='http://www.automationpractice.pl/index.php?controller=order'][@title='View my shopping cart']");
    }
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.shopSite);
        Thread.sleep(3000);

        driver.findElement(Locators.placeholder).sendKeys("Printed Chiffon Dress");
        driver.findElement(Locators.searchButton).click();
        Thread.sleep(3000);

        Actions actions = new Actions(driver);
        WebElement moveCursor = driver.findElement(Locators.recordsFirst);
        actions.moveToElement(moveCursor).perform();
        moveCursor.click();
        Thread.sleep(3000);

        Select size = new Select(driver.findElement(Locators.modelSize));
        size.selectByValue("2");
        Thread.sleep(3000);

        driver.findElement(Locators.addToCart).click();
        Thread.sleep(3000);

        driver.findElement(Locators.continueShopping).click();
        Thread.sleep(3000);

        driver.findElement(Locators.categoryWomen).click();
        Thread.sleep(3000);

        driver.findElement(Locators.placeholder).sendKeys("Faded Short");
        driver.findElement(Locators.searchButton).click();
        Thread.sleep(3000);

        WebElement moveCursor2 = driver.findElement(Locators.recordsSecond);
        actions.moveToElement(moveCursor2).perform();
        moveCursor2.click();
        Thread.sleep(3000);

        Select sizeSecond = new Select(driver.findElement(Locators.modelSize)); //т.к. этих шорт нет на складе - создал этот метод
        sizeSecond.selectByValue("2");
        Thread.sleep(3000);

        driver.findElement(Locators.shoppingCart).click();
        Thread.sleep(3000);

        driver.quit();
        
    }
}
