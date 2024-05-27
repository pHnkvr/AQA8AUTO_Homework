package homework4.grouping;

import homework1.task1.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Groups {
    static WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = DriverInit.setUpDriver();
    }
    @AfterMethod
    public void stop(){
        driver.quit();
    }
    @Test(groups = "first", priority = 1)
    public void one(){
        Assert.assertTrue(true);
    }
    @Test(groups = "second", priority = 1)
    public void two(){
        Assert.assertTrue(true);
    }
    @Test(groups = "first", priority = 2)
    public void three(){
        Assert.assertTrue(true);
    }
    @Test(groups = "second", priority = 2)
    public void four(){
        Assert.assertTrue(true);
    }
    @Test(groups = "first", priority = 3)
    public void five(){
        Assert.assertTrue(true);
    }
    @Test(groups = "second", priority = 3)
    public void six(){
        Assert.assertTrue(true);
    }
    @Test(groups = "first", priority = 4)
    public void seven(){
        Assert.assertTrue(true);
    }
    @Test(groups = "second", priority = 4)
    public void eight(){
        Assert.assertTrue(true);
    }
}
