package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_HomePage extends PageBase

{

    public P02_HomePage (WebDriver driver)
    {
        this.driver=driver;
    }


    private final By PIMLink = By.xpath("(//li[@class='oxd-main-menu-item-wrapper'])[2]");
    // By.xpath("//a[@href='/web/index.php/pim/viewPimModule']");
    // (//li[@class='oxd-main-menu-item-wrapper'])[2]
    // By.xpath("(//span[text()='PIM'])");

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



    public P02_HomePage OpenPIMPage ()
    {
        driver.findElement(PIMLink).click();
        return this;
    }

    public P02_HomePage OpenLeavePage ()
    {
        driver.findElement(LeaveLink).click();
        return this;
    }

    public P02_HomePage OpenTimePage ()
    {
        driver.findElement(TimeLink).click();
        return this;
    }

    public P02_HomePage OpenRecruitmentPage ()
    {
        driver.findElement(RecruitmentLink).click();
        return this;
    }

    public P02_HomePage OpenMyInfoPage ()
    {
        driver.findElement(MyInfoLink).click();
        return this;
    }

    public P02_HomePage OpenDashboard ()
    {
        driver.findElement(DashboardLink).click();
        return this;
    }

    public P02_HomePage OpenDirectory ()
    {
        driver.findElement(DirectoryLink).click();
        return this;
    }
    public P02_HomePage OpenMaintenance ()
    {
        driver.findElement(MaintenanceLink).click();
        return this;
    }
    public P02_HomePage OpenPerformancePage ()
    {
        driver.findElement(PerformanceLink).click();
        return this;
    }

    public P02_HomePage OpenClaimPage ()
    {
        driver.findElement(ClaimLink).click();
        return this;
    }

    public P02_HomePage OpenBuzzPage ()
    {
        driver.findElement(BuzzLink).click();
        return this;
    }






















}
