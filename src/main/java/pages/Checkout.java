package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Checkout {

    WebDriver driver;
    WebDriverWait wait;

    HomePage homePage;

    By addToCartProduct1 = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By addToCartProduct2 = By.id("add-to-cart-sauce-labs-backpack");
    By cartShopping = By.id("shopping_cart_container");
    By checkoutButton = By.xpath("//*[@id='checkout']");
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueButton = By.id("continue");

    By checkoutOverview = By.xpath("//*[@class='title']");
    By finishButton = By.xpath("//*[@id='finish']");
    By statusCheckoutComplete = By.xpath("//*[@class='title']");
    By teksThanksForOrder = By.xpath("//h2[@class='complete-header']");


    public Checkout(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.homePage = new HomePage(driver);
    }

    //Method Checkout Order
    public void addProduct1(){
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCartProduct1));
        driver.findElement(addToCartProduct1).click();
    }

    public void addProduct2(){
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCartProduct2));
        driver.findElement(addToCartProduct2).click();
    }

    public void shoppingCart(){
        driver.findElement(cartShopping).click();
    }

    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }


    //Input Data
    public void inputFirstName(String firstName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode){
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField));
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }

    //validation Success To Page Checkout Overview
    public String getTextCheckoutOverview(){
        return driver.findElement(checkoutOverview).getText();
    }

    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }

    //validation Success Order
    public String getTextCheckoutComplete(){
        return driver.findElement(statusCheckoutComplete).getText();
    }

    public String getTextThanksForOrder(){
        return driver.findElement(teksThanksForOrder).getText();
    }

}
