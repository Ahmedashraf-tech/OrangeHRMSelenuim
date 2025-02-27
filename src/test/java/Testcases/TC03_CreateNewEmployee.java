package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P03_CreateNewEmployee;
import utli.Utility;

import static drivers.DriverHolder.getDriver;
import static utli.Utility.generateName;
public class TC03_CreateNewEmployee extends TestBase{

    public static String Firstname = generateName(5);
    public static String Middlename = generateName(5);
    public static String Lastname = generateName(5);
    public static String Fullname = Firstname + " " + Middlename + " " + Lastname;

    public static final String EmployeesID = Utility.generateRandomID();

    String ExpectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/";

    @Test(priority = 1, description = "Create New Employee")
    public void CreateNewEmployee_P() {



        new P03_CreateNewEmployee(getDriver())

                .OpenAddEmployeePage()
                .EnterFirstName(Firstname)
                .EnterMiddleName(Middlename)
                .EnterLastName(Lastname)
                .ClearEmployeeID()
                .EnterEmployeesID(EmployeesID)
                .ClickOnSubmit();

    }

}
