import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class calculatorPage extends BasePage{
    private WebDriver driver;

        public calculatorPage(WebDriver driver){
            this.driver = driver;
        }
    public void pressSix(){
        clickElement(By.id("six"));
    }
    public void pressMultiply(){
        clickElement(By.id("multiply"));
    }
    public void pressThree(){
        clickElement(By.id("three"));
    }
    public void pressEqual(){
        clickElement(By.id("equal"));
    }
}


