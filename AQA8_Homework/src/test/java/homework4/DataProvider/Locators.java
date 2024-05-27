package homework4.DataProvider;

import org.openqa.selenium.By;

public class Locators {
    public static final By foxtrotSearchPlaceholder = By.xpath("//input[@type='search']");
    public static final By findButton = By.xpath("//input[@class='header-search__button evinent-search-button']");
    public static final By findResult = By.xpath("//div[@class='page__title']//h1");
    public static final By closePopUpWrap = By.xpath("(//i[@class='icon icon-close'])[3]");
}
