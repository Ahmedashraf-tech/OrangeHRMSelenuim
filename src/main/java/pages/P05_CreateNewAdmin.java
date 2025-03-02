package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static drivers.DriverHolder.getDriver;

public class P05_CreateNewAdmin extends PageBase{

    public P05_CreateNewAdmin (WebDriver driver)
    {
        this.driver=driver;
    }

    Actions actions = new Actions(getDriver());


    private final By AdminLink =By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    private final By CreateNewAdminButton = By.xpath("(//button[@class='oxd-button oxd-button--medium oxd-button--secondary'])");
    private final By UserRole = By.xpath("(//div[text()='-- Select --'])[1]");
    private final By SelectUserRole = By.xpath("//div[@class='oxd-select-option']//span[contains(text(),'Admin')]");
    private final By EmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private final By Status = By.xpath("(//div[text()='-- Select --'])[1]");
    private final By Username = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2] | (//input[@class='oxd-input oxd-input--focus'])[2]");
    private final By Password = By.xpath("(//input[@type='password'])[1]");
    private final By ConfirmPassword = By.xpath("(//input[@type='password'])[2]");
    private final By SaveButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    private final By Record = By.xpath("//span[@class='oxd-text oxd-text--span' and contains(text(), 'Records Found')]");

    private final By EmployeeOptionEnabled = By.xpath("//div[@class='oxd-autocomplete-text-input--after']");

    public P05_CreateNewAdmin OpenAdminPage ()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.AdminLink));
        driver.findElement(AdminLink).click();
        return this;
    }

    public P05_CreateNewAdmin ClickOnCreateAdminUser ()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.CreateNewAdminButton));
        driver.findElement(CreateNewAdminButton).click();
        return this;
    }

    public P05_CreateNewAdmin OpenDDLofUserRole ()
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.UserRole));
        driver.findElement(UserRole).click();
        return this;
    }

    public P05_CreateNewAdmin SelectUserRole ()
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.SelectUserRole));
        driver.findElement(SelectUserRole).click();
        return this;
    }

    public P05_CreateNewAdmin EnterEmployeeName (String employeename)
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.EmployeeName));
        driver.findElement(EmployeeName).sendKeys(employeename);
        return this;
    }

    public P05_CreateNewAdmin SelectEmployeeName ()  {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.EmployeeName));
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();



        return this;
    }

    public P05_CreateNewAdmin OpenDDLofStatus ()
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.Status));
        driver.findElement(Status).click();
        return this;
    }

    public P05_CreateNewAdmin SelectStatus ()
    {
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        return this;
    }


    public P05_CreateNewAdmin EnterUserName (String username)
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.Username));
        driver.findElement(Username).sendKeys(username);
        return this;
    }


    public P05_CreateNewAdmin EnterPassword (String password)
    {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.Password));
        driver.findElement(ConfirmPassword).clear();

        if (password.length() > 8) {
            password = password.substring(0, 8);  // Trim to the first 8 characters
        }

        driver.findElement(Password).sendKeys(password);


        return this;
    }


    public P05_CreateNewAdmin EnterConfirmPassword (String confirmpassword)
    {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.ConfirmPassword));
        driver.findElement(ConfirmPassword).clear();
        driver.findElement(ConfirmPassword).sendKeys(confirmpassword);

        return this;
    }

    public P05_CreateNewAdmin ClickOnSave ()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.SaveButton));
        driver.findElement(SaveButton).click();
        return this;
    }

    /* public String VerifySuccessMessage()
    {
        String RecordFound = driver.findElement(Record).getText();
        return RecordFound;
    } */

}
