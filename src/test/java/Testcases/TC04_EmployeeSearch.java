package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P02_HomePage;
import pages.P04_EmployeeSearch;

import static drivers.DriverHolder.getDriver;


public class TC04_EmployeeSearch extends TestBase {


    @Test(priority = 1, description = "SearchForEmployee")
    public void SearchForEmployee()

    {
        new P02_HomePage(getDriver()).OpenPIMPage();

        new P04_EmployeeSearch(getDriver())
                .CollapseEmployeesList()
                .SearchByEmployeesID(TC03_CreateNewEmployee.EmployeesID)
                .ClickOnSearchButton();

        String EmployeerecordText = new P04_EmployeeSearch(getDriver()).GetEmployeeRecordFoundText();
        Assert.assertTrue(EmployeerecordText.contains("(1) Record Found"), "employee not created");

    }

}

