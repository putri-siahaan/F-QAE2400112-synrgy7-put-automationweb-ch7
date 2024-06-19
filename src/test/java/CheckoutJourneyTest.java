import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Checkout;
import pages.Login_Page;

public class CheckoutJourneyTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverManager.chromedriver().create();
        //Zoom Website
        driver.manage().window().maximize();
        //Navigate To Website
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void checkoutProduct(){
        Login_Page login_Page = new Login_Page(driver);
        Checkout checkout = new Checkout(driver);

        login_Page.inputUsernameToLogin("standard_user");
        login_Page.inputPasswordToLogin("secret_sauce");
        login_Page.clickLoginButtonToGoToHomepage();

        checkout.addProduct1();
        checkout.addProduct2();
        checkout.shoppingCart();
        checkout.clickCheckoutButton();
        checkout.inputFirstName("Putri");
        checkout.inputLastName("Siahaan");
        checkout.inputPostalCode("22314");
        checkout.clickContinueButton();

        //Assertion 1 : Validation Success To Page Checkout Overview
        Assert.assertEquals(checkout.getTextCheckoutOverview(),"Checkout: Overview");



        checkout.clickFinishButton();

        //Assertion 2 : Validation Checkout Complete
        Assert.assertEquals(checkout.getTextCheckoutComplete(),"Checkout: Complete!");

        //Assertion 3 : Validation logo Ceklis For Success Order
        WebElement ceklisSuccessOrder = driver.findElement(By.xpath("//img[@class='pony_express']"));
        ceklisSuccessOrder.isDisplayed();

        //Assertion 4 : Validation Text Thanks For Order
        Assert.assertEquals(checkout.getTextThanksForOrder(),"Thank you for your order!");

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
