package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P03_CreateNewEmployee extends PageBase {

    public static String HeaderText;

    public P03_CreateNewEmployee(WebDriver driver)
    {
        this.driver=driver;
    }

    // Locators

    private final By AddEmployee = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private final By FirstName = By.xpath("//input[@name='firstName']");
    private final By MiddleName = By.xpath("//input[@name='middleName']");
    private final By LastName = By.xpath("//input[@name='lastName']");
    private final By EmployeeID_Fill = By.xpath("(//input[@class='oxd-input oxd-input--active' or @class='oxd-input oxd-input--focus'])[2]");
    private final By Save = By.xpath("//button[@type='submit']");
    private final By personaldetails = By.xpath("//a[contains(@href, '/web/index.php/pim/viewPersonalDetails/empNumber/')]");




    public P03_CreateNewEmployee OpenAddEmployeePage()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.AddEmployee));
        driver.findElement(AddEmployee).click();
        return this;
    }

    public P03_CreateNewEmployee EnterFirstName(String firstname)
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.FirstName));
        driver.findElement(FirstName).sendKeys(firstname);
        return this;
    }

    public P03_CreateNewEmployee EnterMiddleName(String middlename)
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.MiddleName));
        driver.findElement(MiddleName).sendKeys(middlename);
        return this;
    }

    public P03_CreateNewEmployee EnterLastName(String lastname)
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.LastName));
        driver.findElement(LastName).sendKeys(lastname);
        return this;
    }

    public P03_CreateNewEmployee ClearEmployeeID()
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.EmployeeID_Fill));

        driver.findElement(EmployeeID_Fill).sendKeys(Keys.CONTROL + "a");
        driver.findElement(EmployeeID_Fill).sendKeys(Keys.DELETE);
        driver.findElement(EmployeeID_Fill).sendKeys(Keys.BACK_SPACE);
        return this;
    }

    public P03_CreateNewEmployee EnterEmployeesID(String employeeid)
    {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.EmployeeID_Fill));
        driver.findElement(EmployeeID_Fill).sendKeys(employeeid);
        return this;
    }

    public P03_CreateNewEmployee ClickOnSave()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.Save));
        driver.findElement(Save).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }


    public String GetPersonalDetails()
    {

    longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.personaldetails));
    return driver.findElement(personaldetails).getAttribute("href"); // return the value of href
    }


















}
