package com.mgk.tau.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

/***
 * Base Class to hold the generic configuration for the project
 */
public abstract class BaseClass {


    /**
     * The Web driver.
     */
    WebDriver webDriver;
    /**
     * The Web driver wait.
     */
    WebDriverWait webDriverWait;
    /**
     * The Base url.
     */
    String baseURL, /**
     * The Node url.
     */
    nodeURL;
    /**
     * The Props.
     */
    Properties props = new Properties();

    /**
     * FindBy declarations
     */
    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    WebElement cookieAccept;

    /**
     * The Search product.
     */
    @FindBy(xpath = "//*[@id=\"wwOneHeader\"]/div/div[1]/header/div[6]/div[1]/form/input")
    WebElement searchProduct;

    /**
     * The Wishlist.
     */
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[7]/div/div/main/div/div[2]/div[1]/a/div/div[2]/div[2]/div")
    WebElement wishlist;

    /**
     * The Login form.
     */
    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[2]/div/div[1]/div/div[2]/div[3]/button")
    WebElement loginForm;

    /**
     * The User name.
     */
    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[2]/div/div[1]/div/div[2]/form/div[1]/input")
    WebElement userName;

    /**
     * The Password.
     */
    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[2]/div/div[1]/div/div[2]/form/div[2]/input")
    WebElement password;

    /**
     * The Submit button.
     */
    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[2]/div/div[1]/div/div[2]/form/button")
    WebElement submitButton;

    /**
     * The Wish list page.
     */
    @FindBy(xpath = "//*[@id=\"wwOneHeader\"]/div/div[1]/header/div[8]/div[3]/div/span[1]/span")
    WebElement wishListPage;

    /**
     * The Wish list item.
     */
    @FindBy(xpath = "//*[@id=\"wishlistRoot\"]/div/div[4]/div/ul/li/div[2]/p[2]")
    WebElement wishListItem;

    /**
     * The Wish list button.
     */
    @FindBy(xpath = "//*[@id=\"wishlistRoot\"]/div/div[4]/div/ul/li/div[2]/button")
    WebElement wishListButton;

    /**
     * The Wish list remove.
     */
    @FindBy(xpath = "//*[@id=\"wishlistRoot\"]/div/div[4]/div/ul/li/button")
    WebElement wishListRemove;

    /**
     * The Empty wish list check.
     */
    @FindBy(xpath = "//*[@id=\"wishlistRoot\"]/div/div[4]/div/ul/div/div[1]/p[1]")
    WebElement emptyWishListCheck;

    /**
     * The Search results.
     */
    By searchResults = By.xpath("//div[starts-with(@class, 'CrossCategoryNavigation')]");

    /**
     * The Loginform.
     */
    By loginform = By.xpath("//*[@id=\"app-root\"]/div/div[2]/div/div[1]/div/div[2]/form/div[1]/input");

}
