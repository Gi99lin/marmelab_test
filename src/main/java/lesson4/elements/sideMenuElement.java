package lesson4.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class sideMenuElement {
    public static WebDriver driver;

    @FindBy(xpath = "//a[text()='Orders']")
    private WebElement ordersSM;

    @FindBy(xpath = "//a[text()='Invoices']")
    private WebElement invoicesSM;

    @FindBy(xpath = "//a[text()='Customers']")
    private WebElement customers;

    public sideMenuElement(WebDriver driver) {
        PageFactory.initElements(driver, this);
        sideMenuElement.driver = driver;
    }

    public sideMenuElement goToOrders(){
        ordersSM.click();
        return this;
    }

    public sideMenuElement goToInvoice(){
        invoicesSM.click();
        return this;
    }

    public  sideMenuElement goToCustomers() {
        customers.click();
        return this;
    }
}
