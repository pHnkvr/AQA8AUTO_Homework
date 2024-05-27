package homework4.priority;

import homework1.task1.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Priority2 {

    static WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = DriverInit.setUpDriver();
    }
    @AfterMethod
    public void stop(){
        driver.quit();
    }
    @Test(dependsOnMethods = "b")
    public void a(){
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "c")
    public void b(){
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "d")
    public void c(){
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "e")
    public void d(){
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "f")
    public void e(){
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "g")
    public void f(){
        Assert.assertTrue(true);
    }

    @Test
    public void g(){
        Assert.assertTrue(true);
    }
}
