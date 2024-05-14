package homework1.task3;

import homework1.task1.DriverInit;
import homework1.task1.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class printInfoAboutIDOfElement {
    public static void printInfoAbout(WebElement element){
        String elementId = element.getAttribute("id");
        String tagName = element.getTagName();
        String className = element.getAttribute("class");
        String name = element.getAttribute("name");
        String text = element.getText();

        int x = element.getLocation().getX();
        int y = element.getLocation().getY();

        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        int centerX = x + width / 2;
        int centerY = y + height / 2;


        System.out.println("ID элемента: " + elementId);
        System.out.println("Значение тега элемента: " + tagName);
        System.out.println("Значение класса элемента: " + className);
        System.out.println("Значение атрибута name элемента: " + name);
        System.out.println("Текст элемента: " + text);
        System.out.println("Координаты центра контейнера элемента: (" + centerX + ", " + centerY + ")");
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.zooKiev);
        WebElement element1 = driver.findElement(By.xpath("//b[contains(text(), 'КУПИТИ')]"));
        printInfoAbout(element1);
        Thread.sleep(2000);
        driver.quit();
    }
}
