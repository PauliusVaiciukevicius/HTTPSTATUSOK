package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Nested
class RegisterTest extends BaseTest {
    MainPage mainPage;
    RegisterPage registerPage;
    LoginPage loginPage;
    ProjectPage projectPage;
@Test
    void userCanRegister (){
    mainPage = new MainPage(driver);
    registerPage = new RegisterPage(driver);
    loginPage = new LoginPage(driver);
    registerPage.inputName("Emilija");
    projectPage = new ProjectPage(driver);

    Random randomGeneratorU = new Random();
    String userName = randomGeneratorU.nextInt(1000) + "useris";
    registerPage.inputUsername(userName);
    Random randomGenerator = new Random();
    String mail = randomGenerator.nextInt(1000) + "cern@gmail.com";
    registerPage.inputEmail(mail);
    Random randomGeneratorP = new Random();
    String password = randomGeneratorP.nextInt(1000) + "password";
    registerPage.inpuPassword(password);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    registerPage.inpuPasswordR(password);
    registerPage.clickCreateAnAccount();
//tikrinu login`a su registravimosi duomenim
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    loginPage.inputUsernameL(userName);
    loginPage.inpuPasswordL(password);
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    loginPage.clicL();

    String expectedMessage2 = "Hi, Welcome back";
    String actualMessage2 = projectPage.setSuccessfullyLogin();
    Assertions.assertEquals(expectedMessage2, actualMessage2, "Login dont work");
}

    @Test
    void invalidUsername1 (){
//        Enter username minimum length 4 characters.
        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);

        registerPage.inputName("Emilija");
        registerPage.inputUsername("Emi");
        Random randomGenerator = new Random();
        String mail = randomGenerator.nextInt(1000) + "cern@gmail.com";
        registerPage.inputEmail(mail);
        Random randomGeneratorP = new Random();
        String password = randomGeneratorP.nextInt(1000) + "password";
        registerPage.inpuPassword(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        registerPage.inpuPasswordR(password);
        registerPage.clickCreateAnAccount();

        String expectedMessage = "Required 5-30 characters, letters and numbers.";
        String actualMessage = driver.findElement(By.cssSelector("div[class='col-md-'] p[class='text-danger']")).getText();
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    void invalidUsername2 (){
//        Enter username more than length 30 characters and combinated of letters and numbers.
        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);

        registerPage.inputName("Emilija");
        registerPage.inputUsername("Emilijaemilijaemilijaemilija123");
        Random randomGenerator = new Random();
        String mail = randomGenerator.nextInt(1000) + "cern@gmail.com";
        registerPage.inputEmail(mail);
        Random randomGeneratorP = new Random();
        String password = randomGeneratorP.nextInt(1000) + "password";
        registerPage.inpuPassword(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        registerPage.inpuPasswordR(password);
        registerPage.clickCreateAnAccount();

        String expectedMessage = "Required 5-30 characters, letters and numbers.";
        String actualMessage = driver.findElement(By.cssSelector("div[class='col-md-'] p[class='text-danger']")).getText();
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    void invalidUsername3 (){
//        Enter unique username minimum length 5 and maximum length 30 characters and only of letters.
        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);

        registerPage.inputName("Emilija");
        registerPage.inputUsername("Emilijacerniauskaite");
        Random randomGenerator = new Random();
        String mail = randomGenerator.nextInt(1000) + "cern@gmail.com";
        registerPage.inputEmail(mail);
        Random randomGeneratorP = new Random();
        String password = randomGeneratorP.nextInt(1000) + "password";
        registerPage.inpuPassword(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        registerPage.inpuPasswordR(password);
        registerPage.clickCreateAnAccount();

        String expectedMessage = "Required 5-30 characters, letters and numbers.";
        String actualMessage = driver.findElement(By.cssSelector("div[class='col-md-'] p[class='text-danger']")).getText();
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    void invalidUsername4 (){
//        Enter unique username minimum length 5 and maximum length 30 characters and only of letters.
        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);

        registerPage.inputName("Emilija");
        registerPage.inputUsername("123456");
        Random randomGenerator = new Random();
        String mail = randomGenerator.nextInt(1000) + "cern@gmail.com";
        registerPage.inputEmail(mail);
        Random randomGeneratorP = new Random();
        String password = randomGeneratorP.nextInt(1000) + "password";
        registerPage.inpuPassword(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        registerPage.inpuPasswordR(password);
        registerPage.clickCreateAnAccount();

        String expectedMessage = "Required 5-30 characters, letters and numbers.";
        String actualMessage = driver.findElement(By.cssSelector("div[class='col-md-'] p[class='text-danger']")).getText();
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    void registereddUsername (){
//        Try to register registered username
        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);

        registerPage.inputName("Emilija");
        registerPage.inputUsername("admin");
        Random randomGenerator = new Random();
        String mail = randomGenerator.nextInt(1000) + "cern@gmail.com";
        registerPage.inputEmail(mail);
        Random randomGeneratorP = new Random();
        String password = randomGeneratorP.nextInt(1000) + "password";
        registerPage.inpuPassword(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        registerPage.inpuPasswordR(password);
        registerPage.clickCreateAnAccount();

        String expectedMessage = "Required 5-30 characters, letters and numbers.";
        String actualMessage = driver.findElement(By.cssSelector("div[class='col-md-'] p[class='text-danger']")).getText();
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    void invalidEmail (){
        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);

        registerPage.inputName("Emilija");
        Random randomGeneratorU = new Random();
        String userName = randomGeneratorU.nextInt(1000) + "useris";
        registerPage.inputUsername(userName);
        Random randomGenerator = new Random();
        String mail = randomGenerator.nextInt(1000) + "cern@@gmail.com";
        registerPage.inputEmail(mail);
        Random randomGeneratorP = new Random();
        String password = randomGeneratorP.nextInt(1000) + "password";
        registerPage.inpuPassword(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        registerPage.inpuPasswordR(password);
        registerPage.clickCreateAnAccount();

        String expectedMessage = "Required 5-30 characters, letters and numbers.";
        String actualMessage = driver.findElement(By.cssSelector("div[class='col-md-'] p[class='text-danger']")).getText();
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    void invalidPassword1 (){
//    Enter password with length of 7 characters and a combinated of letters and numbers.
        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);

        registerPage.inputName("Emilija");
        Random randomGeneratorU = new Random();
        String userName = randomGeneratorU.nextInt(1000) + "useris";
        registerPage.inputUsername(userName);
        Random randomGenerator = new Random();
        String mail = randomGenerator.nextInt(1000) + "cern@gmail.com";
        registerPage.inputEmail(mail);
        registerPage.inpuPassword("Emi123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        registerPage.inpuPasswordR("Emi123");
        registerPage.clickCreateAnAccount();

        String expectedMessage = "Required 8-20 characters with letters and numbers.";
        String actualMessage = driver.findElement(By.cssSelector("div[class='col-md-'] p[class='text-danger']")).getText();
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    void invalidPassword2 (){
//    Enter password with length more than of 20 characters and a combination of letters and numbers.
        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);

        registerPage.inputName("Emilija");
        Random randomGeneratorU = new Random();
        String userName = randomGeneratorU.nextInt(1000) + "useris";
        registerPage.inputUsername(userName);
        Random randomGenerator = new Random();
        String mail = randomGenerator.nextInt(1000) + "cern@gmail.com";
        registerPage.inputEmail(mail);
        registerPage.inpuPassword("Emilijaemilijacern123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        registerPage.inpuPasswordR("Emilijaemilijacern123");
        registerPage.clickCreateAnAccount();

        String expectedMessage = "Required 8-20 characters with letters and numbers.";
        String actualMessage = driver.findElement(By.cssSelector("div[class='col-md-'] p[class='text-danger']")).getText();
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    void invalidPassword3 (){
//   Enter not the same password like in password field in a “repeat password” field.
        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);

        registerPage.inputName("Emilija");
        Random randomGeneratorU = new Random();
        String userName = randomGeneratorU.nextInt(1000) + "useris";
        registerPage.inputUsername(userName);
        Random randomGenerator = new Random();
        String mail = randomGenerator.nextInt(1000) + "cern@gmail.com";
        registerPage.inputEmail(mail);
        Random randomGeneratorP = new Random();
        String password = randomGeneratorP.nextInt(1000) + "password";
        registerPage.inpuPassword(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        registerPage.inpuPasswordR("Emilija123");
        registerPage.clickCreateAnAccount();

        String expectedMessage = "Passwords do not match.";
        String actualMessage = driver.findElement(By.cssSelector("div[class='col-md-'] p[class='text-danger']")).getText();
        assertEquals(expectedMessage, actualMessage);
    }
}

