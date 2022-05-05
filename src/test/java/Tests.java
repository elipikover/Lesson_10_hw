import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tests {
    public WebDriver driver = ChromeInstance.getdriverInstance();

    @BeforeClass
    public void runBeforeTests(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void Test1(){
        driver.get("https://dgotlieb.github.io/Selenium/synchronization.html");
    }

    @AfterClass
    public void runAfterTests(){
        driver.close();
    }
}
