package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P01_LoginPage extends PageBase {


    public P01_LoginPage (WebDriver driver)
    {
    this.driver=driver;
    }

    // Locators

    private final By USERNAME = By.xpath("//input[@name='username']");
    private final By PASSWORD = By.xpath("//input[@name='password']");
    private final By LoginButton = By.xpath("//button[@type='submit']");

    // private final By LoginSuccessEvidence = By.xpath("//h6[contains(@class, 'oxd-text') and text()='Dashboard']");


    public P01_LoginPage EnterUserName (String username)
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.USERNAME));
        driver.findElement(USERNAME).sendKeys(username);
        return this;
    }

    public P01_LoginPage EnterPassword (String password)
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.PASSWORD));
        driver.findElement(PASSWORD).sendKeys(password);
        return this;
    }

    public P01_LoginPage ClickonLoginButton ()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.LoginButton));
        driver.findElement(LoginButton).click();
        return this;
    }







}

