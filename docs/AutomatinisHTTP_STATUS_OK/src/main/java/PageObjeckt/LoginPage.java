package PageObjeckt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    private WebElement searchUsernameField;

    @FindBy(css = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(2) > div:nth-child(2) > input:nth-child(1)")
    private  WebElement searchPasswordField;

    @FindBy(css = "#custom-button")
    private WebElement buttonLogin;

    @FindBy(css = "a[href='http://localhost:3000/register']")
    private WebElement buttonRegister;
    @FindBy (css = "div[class='Allready-member']")
    private WebElement allreadyMemberText;
    @FindBy(css = ".text-start.fs-1.fw-bold.m-2.px-3.py-2")
    private WebElement loginNowText;
    public String getLoginNowText(){
        return loginNowText.getText();
    }

    public String getAllreadyMemberText() { return allreadyMemberText.getText();}
    public String generateRandomUsername() {return "Violeta" + UUID.randomUUID().toString().substring(0, 8);
    }
    public void typeUsername(String username) {
        searchUsernameField.sendKeys(username);
    }

    public void typePassword(String text) {searchPasswordField.sendKeys(text); }

    public void clickButtonLogin(){buttonLogin.click();}
    public void clickRegisterPage(){buttonRegister.click();}

}
