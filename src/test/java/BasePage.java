import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    public void clickElement(By locator){
        getWebElement(locator).click();
    }
    public void SendKeysToElement(By locator,String Keyz){
        getWebElement(locator).sendKeys(Keyz);
    }
    public String getTextFromElement(By locator){
        return getWebElement(locator).getText();
    }
    public boolean isElementVisible(By locator){
        return getWebElement(locator).isDisplayed();
    }
    public WebElement getWebElement(By locator){
        return ChromeInstance.getdriverInstance().findElement(locator);
    }
}
