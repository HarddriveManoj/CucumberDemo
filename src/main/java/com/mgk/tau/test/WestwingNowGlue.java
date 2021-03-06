package com.mgk.tau.test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import okhttp3.internal.http2.ErrorCode;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * The type Westwing now glue.
 */
public class WestwingNowGlue extends BaseClass {

    /**
     * Cucumber @Before hook
     *
     * @throws IOException the io exception
     */
    @Before
    public void setConfiguration() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("user.properties").getFile());
        assertTrue(file.exists());
        props.load(this.getClass().getResourceAsStream("/user.properties"));
        baseURL = props.getProperty("url");
        nodeURL = props.getProperty("hubUrl");
        WebDriverManager.chromedriver().setup();
    }

    /**
     * Given statement
     *
     * @throws MalformedURLException the malformed url exception
     * @throws BaseException         the base exception
     */
    @Given("^I am on the WestwingNow home page$")
    public void i_am_on_the_WestwingNow_home_page() throws MalformedURLException, BaseException {

        Capabilities chromeCapabilities = new ChromeOptions();
        if(props.getProperty("mode").length()==0) {
            throw new BaseException("No mode defined in user.properties, please use local or remote", ErrorCode.CONNECT_ERROR);
        }
        try
        {
            webDriver = props.getProperty("mode").equalsIgnoreCase("local") ? new ChromeDriver() :
                    new RemoteWebDriver(new URL(nodeURL), chromeCapabilities);
            webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
            PageFactory.initElements(webDriver, this);
            webDriver.get(baseURL);
        } catch (Exception e) {
            e.getMessage();
            throw new BaseException("Please verify if the Docker is up and running also please check internet connection", ErrorCode.CONNECT_ERROR);
        }


        webDriverWait = new WebDriverWait(webDriver, 30);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(cookieAccept));
        cookieAccept.click();
    }

    /**
     * When statement
     *
     * @param inputText the input text
     */
    @When("^I search for \\\"([^\\\"]*)\\\"$")
    public void i_search_for(String inputText) {
        searchProduct.sendKeys(inputText);
        searchProduct.sendKeys(Keys.ENTER);

    }

    /**
     * Then statement
     */
    @Then("^I should see product listing page with a list of products$")
    public void i_should_see_product_listing_page_with_a_list_of_products() {
        List<WebElement> webElementsList = webDriver.findElements(searchResults);
        System.out.println(webElementsList.size() != 0 ? "Found below categories \n" : "No results found!");
        for (WebElement webElement : webElementsList) {
            System.out.println("Category: " + webElement.getText());
        }

    }

    /**
     * When statement
     */
    @When("^I click on wishlist icon of the first found product$")
    public void i_click_on_wishlist_icon_of_the_first_found_product() {
        wishlist.click();
    }

    /**
     * Then statement
     */
    @Then("^I should see the login\\/registration overlay$")
    public void i_should_see_the_login_registration_overlay() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(loginform));
    }

    /**
     * When statement
     */
    @When("^I switch to login form of the overlay$")
    public void i_switch_to_login_form_of_the_overlay() {

    }

    /**
     * When statement
     *
     * @param args1 the args 1
     */
    @When("^I log in with \\\"([^\\\"]*)\\\" credentials$")
    public void i_log_in_with_credentials(String args1) {
        String pwd = props.getProperty("password");
        loginForm.click();
        userName.sendKeys(args1);
        if(pwd == null || pwd.length() == 0) {
            throw new BaseException("Password not defined, please set appropriate user account password", ErrorCode.REFUSED_STREAM);
        }
        password.sendKeys(pwd);
        submitButton.submit();
    }

    /**
     * Then statement
     */
    @Then("the product should be added to the wishlist")
    public void the_product_should_be_added_to_the_wishlist() {
        wishListPage.click();
        assertTrue(wishListButton.getText().length() != 0);
    }

    /**
     * Then statement
     */
    @Then("^I go to the wishlist page$")
    public void i_go_to_the_wishlist_page() {
        wishListPage.click();
        System.out.println("Item in wishlist - " + wishListItem.getText());

    }

    /**
     * Then statement
     */
    @Then("^I delete the product from my wishlist$")
    public void i_delete_the_product_from_my_wishlist() {
        wishListRemove.click();
        String message = emptyWishListCheck.getText();
        assertEquals("Die Wunschliste ist momentan leer", message);
    }

    /**
     * Close activities.
     *
     * @After hook
     */
    @After
    public void closeActivities() {
        webDriver.close();
        webDriver.quit();
    }
}
