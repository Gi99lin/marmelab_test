package lesson4.pages;

import lesson4.actions.someFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class invoicePage {

    someFunctions someF = new someFunctions();
    public static WebDriver driver;

    @FindBy(xpath = "//input[@id='date_gte']")
    private WebElement inputSince;

    @FindBy(xpath = "//input[@id='date_lte']")
    private WebElement inputBefore;

    @FindBy(xpath = "//tbody/tr[1]//span/a/div")
    private WebElement firstCustomer;

    @FindBy(xpath = "//tbody/tr[6]/td/div")
    public WebElement opensmth;


    //@FindBy(xpath = )
    //private WebElement ;

    @FindBy(xpath = "//tr[6]/td[7]//span[text()]")
    public static WebElement orderLine;

    @FindBy(xpath = "//td//div[4]/div[2]/p[text()]")
    public static WebElement orderIn;

    @FindBy(xpath = "//tr[6]/td[3]//span[text()]")
    private static WebElement idLine;

    @FindBy(xpath = "//tr[7]//div[1]/div[2]/h6[text()]")
    private static WebElement idIn;

    @FindBy(xpath = "//tr[6]/td[4]/span[text()]")
    private static WebElement dateLine;

    @FindBy(xpath = "//td//div[4]/div[1]/p[text()]")
    private static WebElement dateIn;

    @FindBy(xpath = "//tr[6]/td[5]//div[text()]")
    private static WebElement nameLine;

    @FindBy(xpath = "//tr[7]//div[1]/div[1]/h6[text()]")
    private static WebElement nameIn;

    @FindBy(xpath = "//div[2]/div/p[text()]")
    private static WebElement addres;

    public invoicePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        invoicePage.driver = driver;
    }

    public invoicePage inputDate(String dateSince, String dateBefore) {
        inputSince.sendKeys(dateSince);
        inputBefore.sendKeys(dateBefore);
        return this;
    }

    public  invoicePage openAlreadyNotRandom() {
        opensmth.click();
        return this;
    }

    public invoicePage checkKorey() {
        System.out.println(firstCustomer.getText().equals("Korey Mohr"));
        return this;
    }

    public invoicePage checkAddresChange(String newAddres) {
        String checkAddres = addres.getText();
        System.out.println(checkAddres.equals(newAddres));
        return this;
    }

    public static String orderLineText() {
        String ordrText = orderLine.getText();
        return ordrText;
    }

    public static String orderInText() {
        String ordrIText = orderIn.getText();
        return ordrIText;
    }

    public static String dateInText() {
        String dateIText = dateIn.getText();
        return dateIText;
    }

    public static String dateLineText() {
        String dateLText = dateLine.getText();
        return dateLText;
    }

    public static String idInText() {
        String idIText = idIn.getText();
        idIText = idIText.replace("Invoice ", "");
        return idIText;
    }

    public static String idLineText() {
        String idLText = idLine.getText();
        return idLText;
    }

    public static String nameInText() {
        String nameIText = nameIn.getText();
        return nameIText;
    }

    public static String nameLineText() {
        String nameLText = nameLine.getText();
        return nameLText;
    }





}
