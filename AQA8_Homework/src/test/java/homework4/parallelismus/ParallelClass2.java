package homework4.parallelismus;

import homework1.task1.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class ParallelClass2 {
    static WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = DriverInit.setUpDriver();
    }
    @AfterMethod
    public void stop(){
        driver.quit();
    }
    @Test
    public void parallel6() throws InterruptedException{
        Thread.sleep(2000);
        Assert.assertTrue(true);
    }

    @Test
    public void parallel7() throws InterruptedException{
        Thread.sleep(2000);
        Assert.assertTrue(true);
    }

    @Test
    public void parallel8() throws InterruptedException{
        Thread.sleep(2000);
        Assert.assertTrue(true);
    }

    @Test
    public void parallel9() throws InterruptedException{
        Thread.sleep(2000);
        Assert.assertTrue(true);
    }

    @Test
    public void parallel10() throws InterruptedException{
        Thread.sleep(2000);
        Assert.assertTrue(true);
    }

}
