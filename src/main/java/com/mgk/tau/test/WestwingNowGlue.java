package com.mgk.tau.test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WestwingNowGlue extends BaseClass {
    @Before
    public void setConfiguration() throws IOException {
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\user.properties");
        props.load(objfile);
        baseURL = props.getProperty("url");
        nodeURL = props.getProperty("hubUrl");
        WebDriverManager.chromedriver().setup();
    }


    @Given("^I am on the WestwingNow home page$")
    public void i_am_on_the_WestwingNow_home_page() throws MalformedURLException {

        Capabilities chromeCapabilities = new ChromeOptions();
        webDriver = new RemoteWebDriver(new URL(nodeURL), chromeCapabilities);
        //webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        PageFactory.initElements(webDriver, this);
        webDriver.get(baseURL);

        webDriverWait = new WebDriverWait(webDriver, 30);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(cookieAccept));
        cookieAccept.click();
    }

    @When("^I search for \\\"([^\\\"]*)\\\"$")
    public void i_search_for(String inputText) {
        searchProduct.sendKeys(inputText);
        searchProduct.sendKeys(Keys.ENTER);

    }

    @Then("^I should see product listing page with a list of products$")
    public void i_should_see_product_listing_page_with_a_list_of_products() {
        List<WebElement> webElementsList = webDriver.findElements(searchResults);
        System.out.println(webElementsList.size() != 0 ? "Found below categories \n" : "No results found!");
        for (WebElement webElement : webElementsList) {
            System.out.println("Category: " + webElement.getText());
        }

    }

    @When("^I click on wishlist icon of the first found product$")
    public void i_click_on_wishlist_icon_of_the_first_found_product() {
        wishlist.click();
    }

    @Then("^I should see the login\\/registration overlay$")
    public void i_should_see_the_login_registration_overlay() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(loginform));
    }

    @When("^I switch to login form of the overlay$")
    public void i_switch_to_login_form_of_the_overlay() {

    }

    @When("^I log in with \\\"([^\\\"]*)\\\" credentials$")
    public void i_log_in_with_credentials(String args1) {
        loginForm.click();
        userName.sendKeys(args1);
        password.sendKeys(props.getProperty("password"));
        submitButton.submit();
    }

    @Then("the product should be added to the wishlist")
    public void the_product_should_be_added_to_the_wishlist() {

    }

    @Then("^I go to the wishlist page$")
    public void i_go_to_the_wishlist_page() {

        wishListPage.click();
        System.out.println("Item in wishlist - " + wishListItem.getText());

    }

    @Then("^I delete the product from my wishlist$")
    public void i_delete_the_product_from_my_wishlist() {
        wishListRemove.click();
        System.out.println("Wishlist cleared");
    }

    @After
    public void closeActivities() {
        webDriver.close();
        webDriver.quit();

    }
}
