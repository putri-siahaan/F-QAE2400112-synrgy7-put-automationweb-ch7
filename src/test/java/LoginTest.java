import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Login_Page;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverManager.chromedriver().create();
        //Zoom Website
        driver.manage().window().maximize();
        //Navigate To Website
        driver.get("https://www.saucedemo.com");
    }

    @Test(priority = 1)
    public void successToLoginWithValidUsernameAndPassword(){
        Login_Page login_Page = new Login_Page(driver);
        HomePage homePage = new HomePage(driver);

        login_Page.inputUsernameToLogin("standard_user");
        login_Page.inputPasswordToLogin("secret_sauce");
        login_Page.clickLoginButtonToGoToHomepage();


        //Validation Success Login
        //URL
        Assert.assertEquals(homePage.getCurrentURL(),"https://www.saucedemo.com/inventory.html");
        //Title of Dashboard
        Assert.assertEquals(homePage.getProductInHomepage(),"Products");
        //Shooping Cart Image
        homePage.shoppingCartIsDisplayed();
    }

    //Failed Login with Wrong Password
    @Test(priority = 2)
    public void failedLoginBecauseInvalidPassword(){
        Login_Page login_Page = new Login_Page(driver);
        HomePage homePage = new HomePage(driver);

        login_Page.inputUsernameToLogin("standard_user");
        login_Page.inputPasswordToLogin("12345678");
        login_Page.clickLoginButtonToGoToHomepage();

        //Validation Failed Login
        //URL
        Assert.assertEquals(homePage.getCurrentURL(),"https://www.saucedemo.com/");
        //Error Message
        Assert.assertEquals(login_Page.getErrorMessage(),"Epic sadface: Username and password do not match any user in this service");
        //Cross Icon
        login_Page.stayInTheLoginPage();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
