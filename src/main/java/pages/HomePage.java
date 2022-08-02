package pages;

import HelperMethods.ElementActions;
import org.openqa.selenium.By;

public class HomePage {
   // private WebDriver driver;
    ElementActions elementActions = new ElementActions();
    //locators
    private By userName = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By ListingPageTitle = By.xpath("//span[@class='title']");
    private By errorMessage = By.xpath("//h3[@data-test='error']");



    public ListingPage LoginWithCredentials(String uName , String Pass)
    {
        elementActions.typeInField(userName,uName).
                typeInField(password,Pass).
                clickonElement(loginButton);
        return new ListingPage();
    }

    public void waitTillProductsPageLoad()
    {
        elementActions.waitForElement(ListingPageTitle);
    }
    public String getErrorMessage()
    {
        return elementActions.getText(errorMessage);
    }
}
