package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='col-md-']//input[@id='custom-input']")
    public WebElement enterUsernameL;
    @FindBy(xpath = "//div[@class='card-body']//div[2]//div[1]//input[1]")
    public WebElement enterPasswordL;
    @FindBy(xpath = "//button[@id='custom-button']")
    private WebElement clickLogin;

    public void inputUsernameL(String name) {
        enterUsernameL.sendKeys(name);
    }

    public void inpuPasswordL(String name) {
        enterPasswordL.sendKeys(name);
    }

    public void clicL() {
        clickLogin.click();
    }
}

