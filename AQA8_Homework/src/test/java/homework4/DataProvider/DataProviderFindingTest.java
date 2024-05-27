package homework4.DataProvider;

import homework1.task1.DriverInit;
import homework1.task1.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderFindingTest {
    static WebDriver driver;
    static WebDriverWait wait;
    @BeforeClass
    public void setUp(){
        driver = DriverInit.setUpDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(Urls.foxtrot);
        WebElement popUpWrap = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.closePopUpWrap));
        popUpWrap.click();
    }
    @AfterClass
    public void stop(){
        driver.quit();
    }
    @DataProvider(name = "searchWords")
    public Object[][] searchData(){
        return new Object[][]
                {
                        {"машина"},
                        {"input"},
                        {"розуміння"}
                };
    }
    @Test(dataProvider = "searchWords")
    public void findWordsOnFoxtrot(String inputValues){
        driver.get(Urls.foxtrot);
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.foxtrotSearchPlaceholder));
        searchInput.sendKeys(inputValues);
        WebElement searchButton = driver.findElement(Locators.findButton);
        searchButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.findResult));
        WebElement searchResultElement = driver.findElement(Locators.findResult);
        String searchResultText = searchResultElement.getText();
        if(searchResultText.contains("Знайдено по запиту\""+inputValues+"\"")){
            Assert.assertEquals(driver.findElement(Locators.findResult).getText(),"Знайдено по запиту\""+inputValues+"\"");
        }
        else if (searchResultText.contains("За запитом \""+inputValues+"\" нічого не знайдено"))
        Assert.assertEquals(driver.findElement(Locators.findResult).getText(),"За запитом \""+inputValues+"\" нічого не знайдено");

    }

}
