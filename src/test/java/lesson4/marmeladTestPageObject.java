package lesson4;

import lesson4.actions.someFunctions;
import lesson4.elements.sideMenuElement;
import lesson4.pages.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class marmeladTestPageObject {
    @Test
    public void testSearch() throws InterruptedException, IOException {


        FileInputStream prop;
        Properties property = new Properties();
        prop = new FileInputStream("src/test/resources/environment.properties");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        property.load(prop);
        String url = property.getProperty("url");
        String name = property.getProperty("username");
        String pass = property.getProperty("userpassword");
        String dateSince = property.getProperty("dateSince");
        String dateBefore = property.getProperty("dateBefore");
        String newAddres = property.getProperty("newAddres");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage loginP = new loginPage(driver);
        sideMenuElement sideMenuE = new sideMenuElement(driver);
        invoicePage invoiceP = new invoicePage(driver);
        ordersPage ordersP = new ordersPage(driver);
        customersPage customersP = new customersPage(driver);
        someFunctions someF = new someFunctions();
        profilePage profileP = new profilePage(driver);

        driver.get(url);

        loginP.login(name, pass);

        sideMenuE.goToOrders();

        ordersP.sortDelivered();
        ordersP.selectCheckboxes()
                .checkBoxesSelected();

        sideMenuE.goToInvoice();

        invoiceP.inputDate(dateSince, dateBefore)
                .checkKorey()
                .openAlreadyNotRandom();

        String saveNameForSearch = invoicePage.nameLineText();

        System.out.println(saveNameForSearch);

        someF.checkCreds(invoicePage.orderInText(), invoicePage.orderLineText());

        someF.checkCreds(invoicePage.idInText(), invoicePage.idLineText());

        someF.checkCreds(invoicePage.nameInText(), invoicePage.nameLineText());

        someF.checkCreds(invoicePage.dateInText(), invoicePage.dateLineText());

        sideMenuE.goToCustomers();

        saveNameForSearch = saveNameForSearch.replace(" ", "_");

        customersP.inputSearch(saveNameForSearch);
        TimeUnit.SECONDS.sleep(2);
        customersP.openProfile();

        TimeUnit.SECONDS.sleep(2);

        String saveOldAddres = profileP.getOldAddres();

        System.out.println(saveOldAddres);

        profileP.changeAddress(newAddres);

        sideMenuE.goToInvoice();

        TimeUnit.SECONDS.sleep(2);

        invoiceP.checkAddresChange(newAddres);

        sideMenuE.goToCustomers();

        customersP.inputSearch(someF.deleteString())
                .inputSearch(saveNameForSearch)
                .openProfile();

        profileP.changeAddress(saveOldAddres);

    }
}
