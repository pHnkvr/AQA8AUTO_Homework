package homework4.priority;
import homework1.task1.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Priority1 {
    static WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = DriverInit.setUpDriver();

    }
    @AfterMethod
    public void stop(){
        driver.quit();
    }
    @Test(priority = 7)
    public void a(){
        Assert.assertTrue(true);
    }
    @Test(priority = 6)
    public void b(){
        Assert.assertTrue(true);
    }
    @Test(priority = 5)
    public void c(){
        Assert.assertTrue(true);
    }
    @Test(priority = 4)
    public void d(){
        Assert.assertTrue(true);
    }
    @Test(priority = 3)
    public void e(){
        Assert.assertTrue(true);
    }
    @Test(priority = 2)
    public void f(){
        Assert.assertTrue(true);
    }
    @Test(priority = 1)
    public void g(){
        Assert.assertTrue(true);
    }


}
