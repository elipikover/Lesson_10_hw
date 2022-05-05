import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private WebDriver driver;

    public void clickElement(By locator){
    driver.findElement(locator).click();
    }
    public void SendKeysToElement(By locator,String Keyz){
        driver.findElement(locator).sendKeys(Keyz);
    }
    public String getTextFromElement(By locator){
        return driver.findElement(locator).getText();
    }
}
