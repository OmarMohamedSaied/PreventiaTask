import org.testng.annotations.Test;
import pages.ListingPage;

public class LoginWithValidCredentials extends BaseTest {

    ListingPage listingPage;

    /**
     *this method try to login with valid username and valid pass
     * and Validate that user reached the page after login successfully
     */
    @Test
    public void loginWithValidCredentials()
    {
      listingPage = homePage.LoginWithCredentials(properties.getProperty("ValidUserName"), properties.getProperty("ValidPassword"));
      homePage.waitTillProductsPageLoad();
      softAssert.assertEquals(listingPage.getTitle(),"PRODUCTS");
      softAssert.assertAll();

    }
}
