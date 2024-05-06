package tests;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTestLogin {
    protected WebDriver driver;
    @BeforeEach
    void setup (){
        driver = new ChromeDriver();
        driver. get("http://localhost:3000/login");
        driver.manage().window().maximize();
    }
}
