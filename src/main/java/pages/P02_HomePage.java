package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P02_HomePage extends PageBase

{

    public P02_HomePage (WebDriver driver)
    {
        this.driver=driver;
    }

    private final By PIMLink = By.xpath("(//li[@class='oxd-main-menu-item-wrapper'])[2]");

    private final By LeaveLink = By.xpath("//h6[@text='Leave']");

    private final By TimeLink = By.xpath("//a[@href='/web/index.php/time/viewTimeModule']");

    private final By RecruitmentLink = By.xpath("//h6[@text='Recruitment']");

    private final By MyInfoLink  = By.xpath("//h6[@text='My Info ']");

    private final By PerformanceLink  = By.xpath("//h6[@text='Performance']");

    private final By DashboardLink = By.xpath("//a[@href='/web/index.php/dashboard/index']");

    private final By DirectoryLink  = By.xpath("//h6[@text='Directory']");

    private final By MaintenanceLink  = By.xpath("//h6[@text='Directory']");

    private final By ClaimLink  = By.xpath("//h6[@text='Claim']");

    private final By BuzzLink  = By.xpath("//h6[@text='Buzz']");

    private final By Record = By.xpath("//span[@class='oxd-text oxd-text--span'][1]");


    public P02_HomePage OpenPIMPage ()
    {
        longWait(driver).until(ExpectedConditions.elementToBeClickable(this.PIMLink));
        driver.findElement(PIMLink).click();
        return this;
    }

    public P02_HomePage OpenLeavePage ()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.LeaveLink));
        driver.findElement(LeaveLink).click();
        return this;
    }

    public P02_HomePage OpenTimePage ()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.TimeLink));
        driver.findElement(TimeLink).click();
        return this;
    }

    public P02_HomePage OpenRecruitmentPage ()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.RecruitmentLink));
        driver.findElement(RecruitmentLink).click();
        return this;
    }

    public P02_HomePage OpenMyInfoPage ()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.MyInfoLink));
        driver.findElement(MyInfoLink).click();
        return this;
    }

    public P02_HomePage OpenDashboard ()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.DashboardLink));
        driver.findElement(DashboardLink).click();
        return this;
    }

    public P02_HomePage OpenDirectory ()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.DirectoryLink));
        driver.findElement(DirectoryLink).click();
        return this;
    }
    public P02_HomePage OpenMaintenance ()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.MaintenanceLink));
        driver.findElement(MaintenanceLink).click();
        return this;
    }
    public P02_HomePage OpenPerformancePage ()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.PerformanceLink));
        driver.findElement(PerformanceLink).click();
        return this;
    }

    public P02_HomePage OpenClaimPage ()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.ClaimLink));
        driver.findElement(ClaimLink).click();
        return this;
    }

    public P02_HomePage OpenBuzzPage ()
    {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.BuzzLink));
        driver.findElement(BuzzLink).click();
        return this;
    }























}
