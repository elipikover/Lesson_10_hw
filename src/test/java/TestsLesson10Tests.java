import com.paulhammant.ngwebdriver.ByAngular;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestsLesson10Tests {
    public WebDriver driver = ChromeInstance.getdriverInstance();

    @BeforeClass
    public void runBeforeTests(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void SynchronizationTest() throws InterruptedException {
        driver.get("https://dgotlieb.github.io/Selenium/synchronization.html");
        SynchronazitiuonPage syncPage = new SynchronazitiuonPage(driver);
        syncPage.pressRemove();
        syncPage.getWebElement(By.id("message"));
        syncPage.pressHidden();
        Thread.sleep(5000);
        syncPage.getWebElement(By.id("finish1"));
        syncPage.pressRendered();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish2")));

    }

    @Test(priority = 2)
    public void ngWebdriverTest() {
        driver.navigate().to("https://dgotlieb.github.io/AngularJS/main.html");
        WebElement firstName = driver.findElement(ByAngular.model("firstName"));
        firstName.clear();
        firstName.sendKeys("Eli");
        Assert.assertEquals(firstName.getAttribute("value"),"Eli");
    }

// 3
//        the amount of time that Selenium will wait for a page to load.
//        By default, it is set to 0 (which equates to an infinite time out).
//        If you want to ensure that an error is thrown if your page takes longer than expected to load, you can modify it

    @Test(priority = 3)
    public void calculatorWebdriverTest() {
        driver.get("https://dgotlieb.github.io/WebCalculator/");
        calculatorPage calc = new calculatorPage(driver);
        calc.getWebElement(By.id(Constants.SEVEN)).getSize();
        calc.isElementVisible(By.id("six"));
        String result = "18";
        calc.pressThree();
        calc.pressMultiply();
        calc.pressSix();
        calc.pressEqual();
        Assert.assertEquals(calc.getTextFromElement(By.id("screen")), result);
    }
    @Test(priority = 4)
    public void NewTabTest() {
        driver.get("https://www.google.com/");
        String originalWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com/");
        String secondWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://translate.google.co.il/?hl=iw");
        driver.switchTo().window(originalWindow);
        driver.switchTo().window(secondWindow);


    }
    @AfterClass
    public void runAfterTests() throws InterruptedException {
                Thread.sleep(5000);
        driver.quit();
    }
}
