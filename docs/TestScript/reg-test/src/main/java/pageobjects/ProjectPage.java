package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class ProjectPage extends BasePage{

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[type='submit']")
    private WebElement successfullyLogin;
    @FindBy(xpath = "//button[@type='button'][contains(text(),'New Project')]")
    private WebElement clickNewProject;
    @FindBy(xpath = "//input[@name='projectName']")
    private static WebElement projectName;
    @FindBy(xpath = "//textarea[@name='description']")
    private static WebElement projectDescription;
    @FindBy(css = "select[name='projectStatus']")
    private static WebElement projectStatus;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private static WebElement projectSave;
    @FindBy(css = "div[class='project-name-description-container'] h2")
    private static WebElement successfullyCreated;
    @FindBy(css = ".btn.btn-link")
    private static WebElement clickEdit;
    @FindBy(css = ".submit-button.edit-project-button.btn.btn-primary")
    private static WebElement clickSaveEdit;
    @FindBy(css = "button[class='submit-button btn btn-primary']")
    private static WebElement confirmEdit;
    @FindBy(css = "div[class='project-name-description-container'] h2")
    private static WebElement successfullyEdited;
    @FindBy(xpath = "//body/div[@id='root']/section[@class='sidebar-projects-container']/div[@class='project-list']/div[@class='project-cards-container']/div[1]/div[1]/img[1]")
    private static WebElement clickDeleteProject;
    @FindBy(xpath = "//button[normalize-space()='Delete']")
    private static WebElement clickConfirmDelete;
    @FindBy(css = "div[class='modal-body'] p")
    private static WebElement confirmDeletion;
    @FindBy(css = ".project-list")
    private static WebElement successfullyDeleted;
    @FindBy(xpath = "//p[contains(text(),'You are not authorized to delete this project. Ple')]")
    private static WebElement successfullyCanNotDelete;
    @FindBy(xpath = "button[fdprocessedid='mnfwj']")
    private static WebElement clickClose;

    public String setSuccessfullyLogin () {
        return successfullyLogin.getText();}
    public void createProject() {
        clickNewProject.click();}
    public static void inputProjectName(String name) {
        projectName.sendKeys(name);
    }
    public static void inputProjectDescription(String name) {
        projectDescription.sendKeys(name);
    }
    public static void projectStatus(String ToDo) {
        Select dropdown = new Select(projectStatus);
        dropdown.selectByVisibleText(ToDo);}
    public static void clickSave() {
        projectSave.click();}
    public String projectCreated () {
        return successfullyCreated.getText();}
    public void editProject() {
        clickEdit.click();}
    public static void clickEdit() {
        clickSaveEdit.click();}
    public static void saveEdit() {
        confirmEdit.click();}
    public String editedProject () {
        return successfullyEdited.getText();}
    public static void clickDelete() {
        clickDeleteProject.click();}
    public static void confirmDelete() {
        clickConfirmDelete.click();}
    public String confirmProjectDelete () {
        return confirmDeletion.getText();}
    public String confirmProjectDeleted () {
        return successfullyDeleted.getText();}
    public String userCanNotDelete () {
        return successfullyCanNotDelete.getText();}
    public static void closeDelete() {
       clickClose.click();}
    }




