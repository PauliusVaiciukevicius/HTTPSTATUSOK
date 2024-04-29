package PageObjeckt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css ="input#custom-input[type='text'][name='name'][placeholder='Enter name']")
    private WebElement searchRegisterFirstNameField;

    @FindBy(css = "input#custom-input[name='username'][placeholder='Enter username']")
    private WebElement searchRegisterUsernameField;
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(3) > div:nth-child(2) > input:nth-child(1)")
    private WebElement searchRegisterEmailField;
    @FindBy(css = "input#custom-input[type='password'][name='password'][placeholder='Enter password']")
    private WebElement searchRegisterPasswordField;

    @FindBy(css = "input#custom-input[type='password'][name='repeatPassword'][placeholder='Repeat password']")
    private WebElement searchRepeatPasswordField;

    @FindBy(css = "#custom-button")
    private WebElement buttonCreateAccount;

    @FindBy(css = "a[href='http://localhost:3000/login']")
    private WebElement buttonAfterRegisterLogin;

    public void typeNewFirstName(String text) {searchRegisterFirstNameField.sendKeys(text); }
    public void typeNewUsername(String text) {searchRegisterUsernameField.sendKeys(text); }
    public void typeNewEmail(String text) {searchRegisterEmailField.sendKeys(text); }
    public void typeNewPassword(String text) {searchRegisterPasswordField.sendKeys(text); }
    public void typeRepeatPassword(String text) {searchRepeatPasswordField.sendKeys(text); }

    public void clickButtonCreateAccount(){buttonCreateAccount.click();}
    public void clickLoginAfterRegister(){buttonAfterRegisterLogin.click();}


}

