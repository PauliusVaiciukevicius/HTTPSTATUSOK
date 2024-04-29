package TestLogin;

import PageObjeckt.LoginPage;
import PageObjeckt.ProjectPage;
import PageObjeckt.RegisterPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    ProjectPage projectPage;
    RegisterPage registerPage;

        @Test
        void userCanLogin () {
            loginPage = new LoginPage(driver);
            projectPage = new ProjectPage(driver);
            registerPage = new RegisterPage(driver);
            registerPage.clickLoginAfterRegister();
            loginPage.typeUsername("user");
            loginPage.typePassword("user");
            loginPage.clickButtonLogin();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
            String expectedMessage = "Search";
            String actualMessage = projectPage.setSuccessfullyLogin();
            Assertions.assertEquals(expectedMessage, actualMessage, "Login dont work");
        }
        @Test
        void userCantLogin () {
            loginPage = new LoginPage(driver);
            String randomUsername = loginPage.generateRandomUsername();
            loginPage.typeUsername(randomUsername);
            loginPage.typePassword("Violeta");
            loginPage.clickButtonLogin();
            String expectedMessage = "Login now";
            String actualMessage = loginPage.getLoginNowText();
            Assertions.assertEquals(expectedMessage, actualMessage, "Login work with incorrect details");
        }

        @Test
        void userCanEnterRegisterPage(){
            loginPage = new LoginPage(driver);
            registerPage = new RegisterPage(driver);
            loginPage.clickRegisterPage();
            String expectedMessage = "Allready a member ?";
            String actualMessage = loginPage.getAllreadyMemberText();
            Assertions.assertEquals(expectedMessage, actualMessage, "link dont work");
        }
    }



