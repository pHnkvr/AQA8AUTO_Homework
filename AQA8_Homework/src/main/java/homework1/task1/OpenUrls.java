package homework1.task1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.HashSet;
import java.util.Set;

public class OpenUrls {

    public static String openLinkInNewTabAndReturnNewWindowHandle(WebDriver driver, String url){
        Set<String> winHan1 = driver.getWindowHandles();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> winHan2 = driver.getWindowHandles();
        winHan2.removeAll(winHan1);
        String windowHandle2 = winHan2.iterator().next();
        driver.switchTo().window(windowHandle2);
        driver.get(url);
        return windowHandle2;
    }

    public static void printAllNamesOfTabs(WebDriver driver, Set<String> windowHandles){
        for (String handle: windowHandles){
            driver.switchTo().window(handle);
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
        }
    }
public static void closeZooPage(WebDriver driver, Set<String> windowHandles){
        for (String handle: windowHandles){
            driver.switchTo().window(handle);
            String pageTitle = driver.getTitle();
            if (pageTitle.toLowerCase().contains("зоопарк")){
                driver.close();
                windowHandles.remove(handle);
                break;
            }
        }
}

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverInit.setUpDriver();
        driver.get(Urls.zooKiev);
        String windowHandle1 = driver.getWindowHandle();
        String windowHandle2 = openLinkInNewTabAndReturnNewWindowHandle(driver, Urls.w3schools);
        String windowHandle3 = openLinkInNewTabAndReturnNewWindowHandle(driver, Urls.taxi838);
        String windowHandle4 = openLinkInNewTabAndReturnNewWindowHandle(driver, Urls.klopotenko);
        Set<String> windowHandles = new HashSet<>();
        windowHandles.add(windowHandle1);
        windowHandles.add(windowHandle2);
        windowHandles.add(windowHandle3);
        windowHandles.add(windowHandle4);
        printAllNamesOfTabs(driver, windowHandles);
        closeZooPage(driver, windowHandles);
        Thread.sleep(3000);
        driver.quit();

    }
}
