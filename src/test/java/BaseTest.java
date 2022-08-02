import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static HelperMethods.ElementActions.driver;

public class BaseTest {
    //private WebDriver driver;
    protected HomePage homePage;
    Properties properties = new Properties();
    SoftAssert softAssert = new SoftAssert();



    @BeforeClass
    public void setUpEnvironment() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        InputStream input = new FileInputStream("src/main/java/PropertiesFiles/TestData.properties");
        properties.load(input);
        driver.get(properties.getProperty("applicationUrl"));
        homePage = new HomePage();
    }
    @AfterClass
    public void tearDownEnvironment()
    {
        driver.quit();
    }
}
