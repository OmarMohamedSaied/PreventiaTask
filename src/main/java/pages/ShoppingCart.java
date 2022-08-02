package pages;

import HelperMethods.ElementActions;
import org.openqa.selenium.By;

public class ShoppingCart {
   // private WebDriver driver;
    ElementActions elementActions = new ElementActions();
    //locators
    private By shoppingCartTitle = By.xpath("//span[@class='title']");
    private String ItemInCart_1 = "(//div[@class='inventory_item_name'])[";
    private String ItemInCart_2 = "]";


    public String getItemInCart (int index)
    {
        return elementActions.getText(By.xpath(ItemInCart_1+index+ItemInCart_2));
    }

}
