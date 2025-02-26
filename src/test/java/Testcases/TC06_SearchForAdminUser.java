package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P06_SearchForAdminUser;

import static Testcases.TC05_CreateNewAdmin.Username;
import static drivers.DriverHolder.getDriver;



public class TC06_SearchForAdminUser extends TestBase {


    @Test(priority = 1,description = "Check the ability to search for an admin" )
    public void CreateNewAdmin_P () {
        new P06_SearchForAdminUser(getDriver())
                .OpenCollapse()
                .FilterByUserName(Username)
                .ClickOnSearch();

        String recordText = new P06_SearchForAdminUser(getDriver()).GetRecordFoundText();
        Assert.assertTrue(recordText.contains("(1) Record Found"), "admin user not created");

    }

}
