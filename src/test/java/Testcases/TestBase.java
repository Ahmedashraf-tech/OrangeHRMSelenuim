package Testcases;

import drivers.DriverFactory;
import org.testng.annotations.*;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;
import static pages.PageBase.quitBrowser;
import static utli.Utility.openBrowserNetworkTab;


@Listeners({listeners.CustomListener.class})
public class TestBase {

    private FileInputStream readProperty;
    private Properties prop;
    protected String PROJECT_NAME;
    protected String PROJECT_URL;
    protected Logger log;

    private void setProjectDetails() throws IOException {
        // TODO: Step1: define object of properties file
        readProperty = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/properties/environment.properties");
        prop = new Properties();
        prop.load(readProperty);

        // define project name from properties file
        PROJECT_NAME = prop.getProperty("projectName");
        PROJECT_URL = prop.getProperty("url");
    }

    // Initialize method
    public void initialize() throws IOException {
        setProjectDetails();  // Initialize project details by reading the properties file
    }

    @BeforeSuite
    public void beforeSuite() throws Exception {
        DOMConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/log4j.xml");
        log = Logger.getLogger(TestBase.class);
        initialize();
    }

    @Parameters("browsername")
    @BeforeTest
    public void OpenBrowser(@Optional String browsername) throws AWTException {

        setDriver(DriverFactory.getNewInstance(browsername));

        getDriver().get(PROJECT_URL);

        openBrowserNetworkTab();
    }

    @AfterTest
    public void TearDown() {
        quitBrowser(getDriver());
    }
}
