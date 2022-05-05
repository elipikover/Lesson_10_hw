import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SynchronazitiuonPage extends BasePage{
    private WebDriver driver;

    public SynchronazitiuonPage(WebDriver driver){
        this.driver = driver;
    }

    public void pressRemove(){
        clickElement(By.id("btn"));
    }
    public void pressHidden(){
        clickElement(By.id("hidden"));
    }

    public void pressRendered(){
        clickElement(By.id("rendered"));
    }
}
