package homework1.task2;

import homework1.task1.DriverInit;
import homework1.task1.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class WebElementInfo {
    public static void printElementsInfo(WebElement element1, WebElement element2) {

        int x1 = element1.getLocation().getX();
        int y1 = element1.getLocation().getY();
        int width1 = element1.getSize().getWidth();
        int height1 = element1.getSize().getHeight();


        int x2 = element2.getLocation().getX();
        int y2 = element2.getLocation().getY();
        int width2 = element2.getSize().getWidth();
        int height2 = element2.getSize().getHeight();


        String above = (y1 < y2) ? element1.getTagName() : element2.getTagName();

        String left = (x1 < x2) ? element1.getTagName() : element2.getTagName();

        String bigger = (width1 * height1 > width2 * height2) ? element1.getTagName() : element2.getTagName();


        System.out.println("Елемент, який знаходиться вище на сторінці: " + above);
        System.out.println("Елемент, який знаходиться лівіше на сторінці: " + left);
        System.out.println("Елемент, який має більшу площу: " + bigger);
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.w3schools);
        WebElement element1 = driver.findElement(By.id("learntocode_searchicon"));
        WebElement element2 = driver.findElement(By.xpath("//p[contains(text(),'anguage for stylin')]"));

        WebElementInfo.printElementsInfo(element1, element2);
        Thread.sleep(3000);
        driver.quit();

    }
}
