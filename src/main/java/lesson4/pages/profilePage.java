package lesson4.pages;

import lesson4.actions.someFunctions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class profilePage {

    public static WebDriver driver;

    someFunctions someF = new someFunctions();

    public profilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        profilePage.driver = driver;
    }

    @FindBy(xpath = "//div/textarea[1]")
    public static WebElement oldAddres;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    public static String getOldAddres() {
        String oldAddressText = oldAddres.getText();
        return oldAddressText;
    }

    public profilePage changeAddress(String newAddres) {
        oldAddres.click();
        oldAddres.sendKeys(someF.deleteString());
        oldAddres.sendKeys(newAddres);
        saveButton.click();
        return this;
    }

}
