package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.ProjectPage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

//import static pageobjects.ProjectPage.projectName;

public class manageAdminTest extends BaseTestLogin {
    MainPage mainPage;
    LoginPage loginPage;
    ProjectPage projectPage;

    @Test
    void createProject() {
        //add new projects to the system, insert essential information such as project name, description, start date, status:TO DO, IN PROGRESS” or “DONE
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        projectPage = new ProjectPage(driver);

        loginPage.inputUsernameL("admin");
        loginPage.inpuPasswordL("admin");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.clicL();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        projectPage.createProject();
        Random randomGeneratorPN = new Random();
        String projectName = randomGeneratorPN.nextInt(1000) + "projektas";
        ProjectPage.inputProjectName(projectName);
        Random randomGeneratorPD = new Random();
        String projectDescription = randomGeneratorPD.nextInt(1000) + "projektas";
        ProjectPage.inputProjectDescription(projectName);
        ProjectPage.projectStatus("TO DO");
        ProjectPage.clickSave();
        String expectedMessage = projectName;
        String actualMessage = projectPage.projectCreated();
        Assertions.assertEquals(expectedMessage, actualMessage, "Project do not created");
    }
    @Test
    void adminEditProject() {
        //edit project details such as name, description, status, start date, tasks.
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        projectPage = new ProjectPage(driver);

        loginPage.inputUsernameL("admin");
        loginPage.inpuPasswordL("admin");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.clicL();
        projectPage.editProject();
        Random randomGeneratorPN = new Random();
        String projectName2 = randomGeneratorPN.nextInt(1000) + "projektas";
        ProjectPage.inputProjectName(projectName2);
        Random randomGeneratorPD = new Random();
        String projectDescription2 = randomGeneratorPD.nextInt(1000) + "projektas";
        ProjectPage.inputProjectDescription(projectName2);
        ProjectPage.projectStatus("DONE");
        ProjectPage.clickEdit();
        ProjectPage.saveEdit();
//        String expectedMessage = projectName2;
//        String actualMessage = projectPage.editedProject();
//        Assertions.assertEquals(expectedMessage, actualMessage, "Project do not created");
    }
    @Test
    void confirmDeletemessage() {
        // user should see new message “Are you sure you want to delete?” and the buttons “Yes” and “No”.
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        projectPage = new ProjectPage(driver);

        loginPage.inputUsernameL("admin");
        loginPage.inpuPasswordL("admin");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.clicL();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        projectPage.clickDelete();
        String expectedMessage = "Are you sure you want to delete this project?";
        String actualMessage = projectPage.confirmProjectDelete();
        Assertions.assertEquals(expectedMessage, actualMessage, "Project do not deleted");
    }
    @Test
    void deleteProject() {
        // user can delete project.
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        projectPage = new ProjectPage(driver);

        loginPage.inputUsernameL("admin");
        loginPage.inpuPasswordL("admin");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.clicL();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        projectPage.clickDelete();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        projectPage.confirmDelete();

//        String expectedMessage = "Project";
//        String actualMessage = projectPage.confirmProjectDeleted();
//        Assertions.assertEquals(expectedMessage, actualMessage, "Project deleted");
    }

    }
