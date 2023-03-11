package lesson4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    public static WebDriver driver;

    @FindBy(xpath = "//input[@aria-describedby='username-helper-text']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement singinButton;

    public loginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        loginPage.driver = driver;
    }

    public  loginPage login(String username, String userpassword) {
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(userpassword);
        singinButton.click();

        return this;
    }
}
