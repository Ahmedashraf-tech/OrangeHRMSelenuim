package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static drivers.DriverHolder.getDriver;

public class P04_EmployeeSearch extends PageBase{
    Actions actions = new Actions(getDriver());

    public P04_EmployeeSearch (WebDriver driver) {
        this.driver=driver;
    }

    private final By EmployeesList = By.xpath("(//a[text()='Employee List'])");
    private final By EmployeeName = By.xpath("(//input['Type for hints...'])[2]");

    private final By EmployeeID_Search = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By SearchButton = By.xpath("(//button[@type='submit'])");
    private final By CollapseEmployeesButton = By.xpath("//div[@class='--toggle'][2]");
    private final By EmployeeRecord = By.xpath("/html/body//span[text()='(1) Record Found']");


    public P04_EmployeeSearch CollapseEmployeesList()
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.CollapseEmployeesButton));
        driver.findElement(CollapseEmployeesButton).click();
        return this;
    }

    public P04_EmployeeSearch OpenEmployeesList()
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.EmployeesList));
        driver.findElement(EmployeesList).click();
        return this;
    }

    public P04_EmployeeSearch SearchByEmployeesID(String ID)
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.EmployeeID_Search));
        driver.findElement(EmployeeID_Search).sendKeys(ID);
        return this;
    }


    /* public P04_EmployeeSearch EnterEmployeeName (String fullname)
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.EmployeeName));
        driver.findElement(EmployeeName).sendKeys(fullname);
        return this;
    }

    public P04_EmployeeSearch SelectEmployeeName ()
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.SelectEmployeeName));
        driver.findElement(SelectEmployeeName).click();
        return this;
    }*/

    public P04_EmployeeSearch ClickOnSearchButton ()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.SearchButton));
        driver.findElement(SearchButton).click();
        return this;
    }

    public String GetEmployeeRecordFoundText ()
    {
        actions.sendKeys(org.openqa.selenium.Keys.PAGE_DOWN).build().perform();
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.EmployeeRecord));
        String GetEmployeeRecordText = driver.findElement(EmployeeRecord).getText();
        return GetEmployeeRecordText;
    }

}



