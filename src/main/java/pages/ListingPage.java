package pages;

import HelperMethods.ElementActions;
import org.openqa.selenium.By;

public class ListingPage {
   // private WebDriver driver;
   ElementActions elementActions = new ElementActions();
    //locators
    private By ListingPageTitle = By.xpath("//span[@class='title']");
    private String AddToCartButton_1 = "(//button[contains(.,'Add to cart')])[";
    private String AddToCartButton_2 = "]";
    private String ItemNameInProductsListingPage_1 = "(//div[@class='inventory_item_name'])[";
    private String ItemNameInProductsListingPage_2 = "]";
    private By shoppingCartIcon = By.xpath("//a[@class='shopping_cart_link']");
    private By shoppingCartTitle = By.xpath("//span[@class='title']");




    public String getTitle ()
    {
        return elementActions.getText(ListingPageTitle);
    }

    public String addProductToCart(int index)
    {

        return elementActions.clickonElement(By.xpath(AddToCartButton_1+index+AddToCartButton_2)).
                getText(By.xpath(ItemNameInProductsListingPage_1+index+ItemNameInProductsListingPage_2));
    }

    public ShoppingCart clickShoppingCartIcon()
    {
        elementActions.clickonElement(shoppingCartIcon).waitForElement(shoppingCartTitle);
        return new ShoppingCart();
    }


}
