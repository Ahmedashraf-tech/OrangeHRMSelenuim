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
        // Define object of properties file
        String propertyFilePath = System.getProperty("user.dir") + "/src/test/resources/properties/environment.properties";
        readProperty = new FileInputStream(propertyFilePath);
        prop = new Properties();
        prop.load(readProperty);

        // Define project name and URL from properties file
        PROJECT_NAME = prop.getProperty("projectName");
        PROJECT_URL = prop.getProperty("url");

        // Log the values for debugging
        if (PROJECT_NAME == null || PROJECT_URL == null) {
            log.error("Could not read project details from the properties file.");
        } else {
            log.info("Project Name: " + PROJECT_NAME);
            log.info("Project URL: " + PROJECT_URL);
        }
    }

    // Initialize method
    public void initialize() throws IOException {
        setProjectDetails();  // Initialize project details by reading the properties file
    }

    @BeforeSuite
    public void beforeSuite() throws Exception {
        DOMConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/log4j.xml");
        log = Logger.getLogger(TestBase.class);
    }

    @Parameters("browsername")
    @BeforeTest
    public void OpenBrowser(@Optional String browsername) throws AWTException {
        setDriver(DriverFactory.getNewInstance(""));

        // You can now use the PROJECT_URL that was read from the properties file
        log.info("Opening browser with URL: " + PROJECT_URL);  // Log the URL
        getDriver().get(PROJECT_URL);  // Open the project URL

        // Open browser network
        openBrowserNetworkTab();
    }

    @AfterTest
    public void TearDown() {
        quitBrowser(getDriver());
    }
}
