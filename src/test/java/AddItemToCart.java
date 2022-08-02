import org.testng.annotations.Test;
import pages.ListingPage;
import pages.ShoppingCart;

public class AddItemToCart extends BaseTest{

    ListingPage listingPage;
    ShoppingCart shoppingCart;


    /**
     *this method try to login with valid username and valid pass
     * then add any item from listing page and get the item name
     * then go to cart and validate that item chosen from products
     * listing page is the item added successfully to cart
     */
    @Test
    public void AddFirstItemToCart()
    {
        listingPage = homePage.LoginWithCredentials("standard_user","secret_sauce");
        homePage.waitTillProductsPageLoad();
        String firstItemInProductsListingPage = listingPage.addProductToCart(Integer.parseInt(properties.getProperty("ItemIndex_ProductListingPage")));
        shoppingCart = listingPage.clickShoppingCartIcon();
        String firstItemInCart = shoppingCart.getItemInCart(Integer.parseInt(properties.getProperty("ItemIndex_Cart")));
        softAssert.assertEquals(firstItemInProductsListingPage,firstItemInCart);
        softAssert.assertAll();
    }
}
