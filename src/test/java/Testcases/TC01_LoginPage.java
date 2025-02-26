package Testcases;

import io.qameta.allure.*;
import retrytests.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.json.simple.parser.ParseException;
import pages.P01_LoginPage;

import java.io.IOException;

import static drivers.DriverHolder.getDriver;
import static utli.Utility.getSingleJsonData;


@Epic("Login")
@Story("Login Story")

public class TC01_LoginPage extends TestBase {

    // We need to make data dynamic

    String username = getSingleJsonData(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\Credential.json", "Username");
    String password = getSingleJsonData(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\Credential.json", "Password");

    public TC01_LoginPage() throws IOException, ParseException {
    }

    @Description("Login with Valid Credentials ")
    @Severity(SeverityLevel.CRITICAL)
    @Test (priority = 1,description = "Login to OrangeHRM With Valid username and password" , retryAnalyzer = RetryAnalyzer.class)
    public void loginToOrangeHRM_P()
    {

        new P01_LoginPage(getDriver())
                .EnterUserName(username)
                .EnterPassword(password)
                .ClickonLoginButton();

        log.info("Login Successfully");
        Assert.assertTrue(getDriver().getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));


    }

    @Test (priority = 2,description = "Login to OrangeHRM With invalid username and invalid password" , retryAnalyzer = RetryAnalyzer.class , enabled = false)
    public void loginToOrangeHRM_N()
    {

        new P01_LoginPage(getDriver())
                .EnterUserName("admin")
                .EnterPassword("admin")
                .ClickonLoginButton();

        log.info("Login Failed");
        Assert.assertTrue(getDriver().getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));


    }



    /*
    @Step
    public void ClickOnLogIn () {}
    */

}
