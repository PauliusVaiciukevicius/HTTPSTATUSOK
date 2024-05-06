package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.ProjectPage;
import pageobjects.LoginPage;
import pageobjects.MainPage;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTestLogin {
    MainPage mainPage;
    LoginPage loginPage;
    ProjectPage projectPage;

    @Test
    void userCanLogin() {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        projectPage = new ProjectPage(driver);

        loginPage.inputUsernameL("admin");
        loginPage.inpuPasswordL("admin");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.clicL();

        String expectedMessage = "Search";
        String actualMessage = projectPage.setSuccessfullyLogin();
        Assertions.assertEquals(expectedMessage, actualMessage, "Login dont work");
    }

}