package lesson2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestForWeb {
    public static void main(String[] args)  {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        chromeOptions.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.postman.com/eu6grp15/workspace/simple-books-api-glitch-me/documentation/18551292-ab5af4da-41cd-4fa3-a443-f0f6b38ec6b6");

    }

}
