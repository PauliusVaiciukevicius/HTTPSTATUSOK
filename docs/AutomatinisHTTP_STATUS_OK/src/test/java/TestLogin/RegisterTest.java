package TestLogin;

import PageObjeckt.LoginPage;
import PageObjeckt.ProjectPage;
import PageObjeckt.RegisterPage;
import Util.RandomGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Util.RandomGenerator;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest extends BaseTest {
    LoginPage loginPage;
    ProjectPage projectPage;
    RegisterPage registerPage;

    @Test
    void userRegisterValidDetails() {
        registerPage = new RegisterPage(driver);
        projectPage = new ProjectPage(driver);
        loginPage = new LoginPage(driver);
        registerPage.typeNewFirstName("Violeta");
        String username = RandomGenerator.generateRandomUsername();
        registerPage.typeNewUsername(username);
        String mail = RandomGenerator.generateRandomEmail();
        registerPage.typeNewEmail(mail);
        registerPage.typeNewPassword("Violeta1");
        registerPage.typeRepeatPassword("Violeta1");
        registerPage.clickButtonCreateAccount();

        String expectedMessage = "Hi, Welcome back";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String actualMessage = driver.findElement(By.cssSelector(".m-4.text-start")).getText();
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void userRegisterInvalidEmail() {
        registerPage = new RegisterPage(driver);
        projectPage = new ProjectPage(driver);
        loginPage = new LoginPage(driver);
        registerPage.typeNewFirstName("Violeta");
        String username = RandomGenerator.generateRandomUsername();
        registerPage.typeNewUsername(username);
        registerPage.typeNewEmail("mail.com");
        registerPage.typeNewPassword("Violeta1");
        registerPage.typeRepeatPassword("Violeta1");
        registerPage.clickButtonCreateAccount();
        String expectedMessage = "Email address must be unique and formatted correctly.";
        String actualMessage = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(3) > div:nth-child(2) > p:nth-child(2)")).getText();
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void userRegisterInvalidUsername() {
        registerPage = new RegisterPage(driver);
        projectPage = new ProjectPage(driver);
        loginPage = new LoginPage(driver);
        registerPage.typeNewFirstName("Violeta");
        registerPage.typeNewUsername("Violeta");
        String mail = RandomGenerator.generateRandomEmail();
        registerPage.typeNewEmail(mail);
        registerPage.typeNewPassword("Violeta1");
        registerPage.typeRepeatPassword("Violeta1");
        registerPage.clickButtonCreateAccount();
        String expectedMessage = "Required 5-30 characters, letters and numbers.";
        String actualMessage = driver.findElement(By.cssSelector("div[class='col-md-'] p[class='text-danger']")).getText();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void userRegisterInvalidPassword() {
        registerPage = new RegisterPage(driver);
        projectPage = new ProjectPage(driver);
        loginPage = new LoginPage(driver);
        registerPage.typeNewFirstName("Violeta");
        String username = RandomGenerator.generateRandomUsername();
        registerPage.typeNewUsername(username);
        String mail = RandomGenerator.generateRandomEmail();
        registerPage.typeNewEmail(mail);
        registerPage.typeNewPassword("Violeta");
        registerPage.typeRepeatPassword("Violeta");
        registerPage.clickButtonCreateAccount();
        String expectedMessage = "Required 8-20 characters with letters and numbers";
        String actualMessage = driver.findElement(By.cssSelector("p[class='text-danger ']")).getText();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void userRegisterDifferentPasswords() {
        registerPage = new RegisterPage(driver);
        projectPage = new ProjectPage(driver);
        loginPage = new LoginPage(driver);
        registerPage.typeNewFirstName("Violeta");
        String username = RandomGenerator.generateRandomUsername();
        registerPage.typeNewUsername(username);
        String mail = RandomGenerator.generateRandomEmail();
        registerPage.typeNewEmail(mail);
        registerPage.typeNewPassword("Violeta1");
        registerPage.typeRepeatPassword("Violeta2");
        registerPage.clickButtonCreateAccount();
        String expectedMessage = "Passwords do not match.";
        String actualMessage = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(5) > div:nth-child(2) > p:nth-child(2)")).getText();
        assertEquals(expectedMessage, actualMessage);
    }
}