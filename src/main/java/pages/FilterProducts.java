package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FilterProducts {

    WebDriver driver;
    WebDriverWait wait;

    HomePage homePage;

    By filterProducts = By.xpath("//*[@class='product_sort_container']");
    By activeOptionSort = By.xpath("//*[@class='active_option']");
    By priceHighToLow = By.xpath("//*[@value='hilo']");
    By priceProduct1 = By.xpath("(//div[@class='inventory_item_price'])[1]");
    By priceProduct2 = By.xpath("(//div[@class='inventory_item_price'])[2]");


    public FilterProducts(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.homePage = new HomePage(driver);
    }

    //Method Filter Products
    public void clickFilterIcon(){
        wait.until(ExpectedConditions.presenceOfElementLocated(filterProducts));
        driver.findElement(filterProducts).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(priceHighToLow));
        driver.findElement(priceHighToLow).click();
    }

    //validation success to sort
    public String getSortOption(){
        return driver.findElement(activeOptionSort).getText();
    }

    //First Product
    public double getPriceOfFirstProducts(){
        String firstProduct = driver.findElement(priceProduct1).getText().replace("$", "");
        return Double.parseDouble(firstProduct);
    }

    //Second Product
    public double getPriceOfSecondProducts(){
        String secondProduct = driver.findElement(priceProduct2).getText().replace("$", "");
        return Double.parseDouble(secondProduct);
    }
}
