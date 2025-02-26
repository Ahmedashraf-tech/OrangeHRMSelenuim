package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static drivers.DriverHolder.getDriver;

public class P06_SearchForAdminUser extends PageBase {

    Actions actions = new Actions(getDriver());


    public P06_SearchForAdminUser(WebDriver driver)
    {
        this.driver=driver;
    }

    // private final By AdminLink =By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    private final By Collapse = By.xpath("//button[@class='oxd-icon-button' and @type='button'][1]");
    private final By Username = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2] | (//input[@class='oxd-input oxd-input--focus'])[2]");
    private final By UserRole = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'][1] or @class='oxd-select-text oxd-select-text--focus'][1]");
    private final By EmployeeName = By.xpath(("//input[@placeholder='Type for hints...'])"));
    private final By Status = By.xpath("(//div[@class='oxd-select-text-input'][2]");
    private final By SearchButton = By.xpath("//button[@type='submit']");
    private final By RecordFound = By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]");
    private final By Record = By.xpath("//span[normalize-space(text())='(1) Record Found']");

    public P06_SearchForAdminUser OpenCollapse ()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.Collapse));
        driver.findElement(Collapse).click();
        return this;
    }

    public P06_SearchForAdminUser FilterByUserName (String username)
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.Username));
        driver.findElement(Username).sendKeys(username);
        return this;
    }

    public P06_SearchForAdminUser OpenDDLOfUserRole_Filter ()
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.UserRole));
        driver.findElement(UserRole).click();
        return this;
    }

    public P06_SearchForAdminUser FilterByUserRole()
    {

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        return this;
    }

    public P06_SearchForAdminUser FilterByEmployeeName (String employeename)
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.EmployeeName));
        driver.findElement(EmployeeName).sendKeys(employeename);
        return this;
    }

    public P06_SearchForAdminUser SelectEmployeeNameOption_Filter ()
    {
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        return this;
    }

    public P06_SearchForAdminUser OpenDDLOfStatus_Filter ()
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.Status));
        driver.findElement(Status).click();
        return this;
    }

    public P06_SearchForAdminUser FilterByStatus ()
    {
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        return this;
    }

    public P06_SearchForAdminUser ClickOnSearch ()
    {
        longWait(driver).until(ExpectedConditions.elementToBeClickable(this.SearchButton));
        driver.findElement(SearchButton).click();
        return this;
    }

    public String GetRecordFoundText ()
    {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.Record));
        String GetRecordText = driver.findElement(Record).getText();
        return GetRecordText;
    }

}
