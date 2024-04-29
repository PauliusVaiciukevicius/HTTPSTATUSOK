package PageObjeckt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends BasePage{
    public ProjectPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "button[type='submit']")
    private WebElement successfullyLogin;
    public String setSuccessfullyLogin () {return successfullyLogin.getText();}

}
