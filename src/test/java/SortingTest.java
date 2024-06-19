import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FilterProducts;
import pages.Login_Page;

public class SortingTest {
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
    public void filterProductHighToLowPrice(){
        Login_Page login_Page = new Login_Page(driver);
        FilterProducts filterProducts = new FilterProducts(driver);

        login_Page.inputUsernameToLogin("standard_user");
        login_Page.inputPasswordToLogin("secret_sauce");
        login_Page.clickLoginButtonToGoToHomepage();

        filterProducts.clickFilterIcon();

        //Validation Products in Left > Products in Right
        //assertions
        Assert.assertEquals(filterProducts.getSortOption(),"Price (high to low)");
        Assert.assertTrue(filterProducts.getPriceOfFirstProducts() > filterProducts.getPriceOfSecondProducts(), "Test failed: First price is not higher than the last price");

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
