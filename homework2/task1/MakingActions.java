package homework2.task1;

import homework1.task1.DriverInit;
import homework1.task1.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MakingActions {
    private static class Locators{
        private static final By carList = By.id("Carlist");
        private static final By leftTable = By.xpath("//select[@name='FromLB']");
        private static final By rightTable = By.xpath("//select[@name='ToLB']");
        private static final By selectCountries = By.xpath("//input[@value='->']");
    }
    public static void chooseCars(WebDriver driver){
        WebElement elementCarList = driver.findElement(Locators.carList);
        Select cars = new Select(elementCarList);
        cars.selectByValue("Renault Car");
        List<WebElement> allCars = cars.getOptions();
        System.out.println("Автомобили в продаже:");
        int lastIndexForCars = allCars.size() - 1;
        int currentIndexForCars = 0;
        for (WebElement element : allCars) {
            System.out.print(element.getText());
            if (currentIndexForCars < lastIndexForCars) {
                System.out.print(", ");
            } else {
                System.out.print(".");
            }
            currentIndexForCars++;
        }
    }
    public static void addCountriesFromLeftToRight(WebDriver driver){
        WebElement countriesFromLeft = driver.findElement(Locators.leftTable);

        Select leftcountry = new Select(countriesFromLeft);

        leftcountry.selectByVisibleText("France");
        leftcountry.selectByVisibleText("India");
        leftcountry.deselectByVisibleText("India");
        leftcountry.selectByVisibleText("Germany");
        leftcountry.selectByVisibleText("Italy");
        leftcountry.selectByVisibleText("Malaysia");
        leftcountry.deselectByVisibleText("Malaysia");
        leftcountry.selectByVisibleText("Spain");
        driver.findElement(Locators.selectCountries).click();

    }
    public static void printAllInfo(WebDriver driver){
        WebElement elementCarList = driver.findElement(Locators.carList);
        Select cars = new Select(elementCarList);
        List<WebElement> allCars = cars.getOptions();
        System.out.println("Автомобили в продаже:");
        int lastIndexForCars = allCars.size() - 1;
        int currentIndexForCars = 0;
        for (WebElement element : allCars) {
            System.out.print(element.getText());
            if (currentIndexForCars < lastIndexForCars) {
                System.out.print(", ");
            } else {
                System.out.print(".");
            }
            currentIndexForCars++;
        }
        WebElement countriesFromLeft = driver.findElement(Locators.leftTable);

        Select leftcountry = new Select(countriesFromLeft);
        List<WebElement> leftCountries = leftcountry.getOptions();
        System.out.println("\nСтраны с левой таблицы: ");
        int lastIndexForLeftTable = leftCountries.size() - 1;
        int currentIndexForLeftTable = 0;
        for (WebElement element : leftCountries) {
            System.out.print(element.getText());
            if (currentIndexForLeftTable < lastIndexForLeftTable) {
                System.out.print(", ");
            } else {
                System.out.print(".");
            }
            currentIndexForLeftTable++;
        }
        WebElement countriesFromRight = driver.findElement(Locators.rightTable);
        Select rightcountry = new Select(countriesFromRight);
        List<WebElement> rightCountries = rightcountry.getOptions();
        System.out.println("\nСтраны с правой таблицы: ");
        int lastIndexForRightTable = rightCountries.size() - 1;
        int currentIndexForRightTable = 0;
        for (WebElement element : rightCountries) {
            System.out.print(element.getText());
            if (currentIndexForRightTable < lastIndexForRightTable) {
                System.out.print(", ");
            } else {
                System.out.print(".");
            }
            currentIndexForRightTable++;
        }

    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.TextBox);
        chooseCars(driver);
        addCountriesFromLeftToRight(driver);
        printAllInfo(driver);
        driver.quit();
    }
}
