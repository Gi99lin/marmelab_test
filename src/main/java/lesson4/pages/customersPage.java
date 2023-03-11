package lesson4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class customersPage {

    public static WebDriver driver;

    public customersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        customersPage.driver = driver;
    }

    @FindBy(xpath = "//input[@aria-invalid]")
    private WebElement search;

    @FindBy(xpath = "//td/a")
    private WebElement Profile;

    public customersPage inputSearch(String name){
        search.sendKeys(name);
        return this;
    }

    public customersPage openProfile() {
        Profile.click();
        return this;
    }


}
