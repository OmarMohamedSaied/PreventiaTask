import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginWithInvalidCredentials extends BaseTest {

    /**
     *this method try to login with valid username and invalid pass
     * and check that user won't be able to process to page
     * and Validate correct error message appear
     */
    @Test
    public void loginWithInvalidCredentials()
    {
        homePage.LoginWithCredentials(properties.getProperty("ValidUserName"), properties.getProperty("InValidPassword"));
        softAssert.assertEquals(homePage.getErrorMessage(), properties.getProperty("InValidCredentials_ErrMsg"));
        softAssert.assertAll();
    }

}
