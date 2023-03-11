package lesson4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ordersPage {

    public static WebDriver driver;

    @FindBy(xpath = "//span[text()='delivered']")
    private WebElement ordersDelivered;

    @FindBy(xpath = "//tbody/tr[1]//input")
    private WebElement checkBoxOne;

    @FindBy(xpath = "//tbody/tr[2]//input")
    private WebElement checkBoxTwo;

    @FindBy(xpath = "//tbody/tr[3]//input")
    private WebElement checkBoxThree;

    @FindBy(xpath = "//h6[text()]")
    private WebElement selectedQuantity;

    public ordersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        ordersPage.driver = driver;
    }

    public ordersPage sortDelivered() {
        ordersDelivered.click();
        return this;
    }

    public ordersPage selectCheckboxes() {
        checkBoxOne.click();
        checkBoxTwo.click();
        checkBoxThree.click();
        return this;
    }

    public ordersPage checkBoxesSelected() {
        selectedQuantity.equals("3");
        return this;
    }

}
