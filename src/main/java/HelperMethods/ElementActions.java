package HelperMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {

    public static WebDriver driver;


    public ElementActions clickonElement (By element)
    {
        driver.findElement(element).click();
        return this;
    }
    public ElementActions typeInField (By element , String text)
    {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
        return this;
    }
    public void waitForElement (By locator)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver,2000);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }
    public String getText(By locator)
    {
        return driver.findElement(locator).getText();
    }
}
