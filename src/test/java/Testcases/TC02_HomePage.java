package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P02_HomePage;
import retrytests.RetryAnalyzer;

import static drivers.DriverHolder.getDriver;

public class TC02_HomePage extends TestBase{


    @Test(priority = 1, description = "Check that user is directed to PIM Page through clicking on PIM Link" , retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatPIMPageOpens() {

        new P02_HomePage(getDriver()).OpenPIMPage();
        Assert.assertTrue(getDriver().getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList"));
    }

}
