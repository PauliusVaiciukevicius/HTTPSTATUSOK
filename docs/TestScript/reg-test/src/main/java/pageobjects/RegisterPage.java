package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage{

    @FindBy (xpath = "//div[@class='card']//div[1]//div[1]//input[1]")
    public WebElement enterName;

    @FindBy (xpath = "//div[@class='col-md-']//input[@id='custom-input']")
    public WebElement enterUsername;

    @FindBy (xpath = "//div[3]//div[1]//input[1]")
    public WebElement enterEmail;

    @FindBy (xpath = "//div[@class='row']//div[4]//div[1]//input[1]")
    public WebElement enterPassword;

    @FindBy (xpath = "//div[5]//div[1]//input[1]")
    public WebElement enterPasswordR;

    @FindBy (css = "#custom-button")
    private WebElement clickButton;
//tikrinu logina su Registruotu accauntu
    @FindBy(xpath = "//div[@class='col-md-']//input[@id='custom-input']")
    public WebElement enterUsernameL;
    @FindBy(xpath = "//div[@class='card-body']//div[2]//div[1]//input[1]")
    public WebElement enterPasswordL;
    @FindBy(xpath = "//button[@id='custom-button']")
    private WebElement clickLogin;

    public RegisterPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void inputName(String name){
        enterName.sendKeys(name);
    }
    public void inputUsername(String name){
        enterUsername.sendKeys(name);
    }
    public void inputEmail(String name){
        enterEmail.sendKeys(name);
    }
    public void inpuPassword(String name){
        enterPassword.sendKeys(name);
    }
    public void inpuPasswordR(String name){
        enterPasswordR.sendKeys(name);

    }
    public void clickCreateAnAccount() {
        clickButton.click();
    }
//tikrinu logina su Registruotu accauntu
        public void inputUsernameL(String name) {
            enterUsernameL.sendKeys();
        }
        public void inpuPasswordL(String name) {
            enterPasswordL.sendKeys();
        }
        public void clicL() {
            clickLogin.click(); }


}
