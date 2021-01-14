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


    WebDriver webDriver;
    WebDriverWait webDriverWait;
    String baseURL, nodeURL;
    Properties props = new Properties();

    /**
     * FindBy declarations
     */

    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    WebElement cookieAccept;

    @FindBy(xpath = "//*[@id=\"wwOneHeader\"]/div/div[1]/header/div[6]/div[1]/form/input")
    WebElement searchProduct;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[7]/div/div/main/div/div[2]/div[1]/a/div/div[2]/div[2]/div")
    WebElement wishlist;

    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[2]/div/div[1]/div/div[2]/div[3]/button")
    WebElement loginForm;

    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[2]/div/div[1]/div/div[2]/form/div[1]/input")
    WebElement userName;

    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[2]/div/div[1]/div/div[2]/form/div[2]/input")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[2]/div/div[1]/div/div[2]/form/button")
    WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"wwOneHeader\"]/div/div[1]/header/div[8]/div[3]/div/span[1]/span")
    WebElement wishListPage;

    @FindBy(xpath = "//*[@id=\"wishlistRoot\"]/div/div[4]/div/ul/li/div[2]/p[2]")
    WebElement wishListItem;

    @FindBy(xpath = "//*[@id=\"wishlistRoot\"]/div/div[4]/div/ul/li/div[2]/button")
    WebElement wishListButton;

    @FindBy(xpath = "//*[@id=\"wishlistRoot\"]/div/div[4]/div/ul/li/button")
    WebElement wishListRemove;

    @FindBy(xpath = "//*[@id=\"wishlistRoot\"]/div/div[4]/div/ul/div/div[1]/p[1]")
    WebElement emptyWishListCheck;

    By searchResults = By.xpath("//div[starts-with(@class, 'CrossCategoryNavigation')]");

    By loginform = By.xpath("//*[@id=\"app-root\"]/div/div[2]/div/div[1]/div/div[2]/form/div[1]/input");

}
