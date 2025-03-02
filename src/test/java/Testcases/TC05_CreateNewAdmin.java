package Testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P05_CreateNewAdmin;
import utli.Utility;
import static drivers.DriverHolder.getDriver;

public class TC05_CreateNewAdmin extends TestBase
{

    public final static String Username = Utility.generateName(5);
    public String Password = Utility.generateComplexPassword(8);

    @Test(priority = 1,description = "Check the ability to create new admin" )
    public void CreateNewAdmin_P () {


        new P05_CreateNewAdmin(getDriver()).OpenAdminPage().NoOfTotalRecordsBefore();
        new P05_CreateNewAdmin(getDriver())
                .OpenAdminPage()
                .ClickOnCreateAdminUser()
                .OpenDDLofUserRole()
                .SelectUserRole()
                .EnterEmployeeName(TC03_CreateNewEmployee.Fullname)
                .SelectEmployeeName()
                .OpenDDLofStatus()
                .SelectStatus()
                .EnterUserName(Username)
                .EnterPassword(Password)
                .EnterConfirmPassword(Password)
                .ClickOnSave();


        int TotalRecordsBeforeCreate = new P05_CreateNewAdmin(getDriver()).NoOfTotalRecordsBefore();
        int TotalRecordsAfterCreate = new P05_CreateNewAdmin(getDriver()).NoOfTotalRecordsAfter();

        Assert.assertEquals(TotalRecordsBeforeCreate+1,TotalRecordsAfterCreate);


    }





}