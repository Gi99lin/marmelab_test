import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class marmeladTest {
    @Test
    public void testSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://marmelab.com/react-admin-demo/#/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By inputLogin = By.xpath("//input[@aria-describedby='username-helper-text']");
        driver.findElement(inputLogin).sendKeys("demo");

        By inputPassword = By.xpath("//input[@name='password']");
        driver.findElement(inputPassword).sendKeys("demo");

        By singinButton = By.xpath("//button[@type='submit']");
        driver.findElement(singinButton).click();

        By ordersSM = By.xpath("//a[text()='Orders']");
        driver.findElement(ordersSM).click();

        By ordersDelivered = By.xpath("//span[text()='delivered']");
        driver.findElement(ordersDelivered).click();

        By checkBoxOne = By.xpath("//tbody/tr[1]//input");
        driver.findElement(checkBoxOne).click();

        By checkBoxTwo = By.xpath("//tbody/tr[2]//input");
        driver.findElement(checkBoxTwo).click();

        By checkBoxThree = By.xpath("//tbody/tr[3]//input");
        driver.findElement(checkBoxThree).click();

        By selectedQuantity = By.xpath("//h6[text()]");
        driver.findElements(selectedQuantity);

        /*By addFilter = By.xpath("//button[text()='Add filter']");
        driver.findElement(addFilter).click();

        By downMenuSince = By.xpath("//span[text()='Passed Since']");
        driver.findElement(downMenuSince).click();

        By downMenuBefore = By.xpath("//span[text()='Passed Before']");
        driver.findElement(downMenuBefore).click();*/

        By invoicesSM = By.xpath("//a[text()='Invoices']");
        driver.findElement(invoicesSM).click();

        By inputSince = By.xpath("//input[@id='date_gte']");
        driver.findElement(inputSince).sendKeys("01.01.2022");

        By inputBefore = By.xpath("//input[@id='date_lte']");
        driver.findElement(inputBefore).sendKeys("01.08.2023");

        TimeUnit.SECONDS.sleep(2);

        List customers2 = driver.findElements(By.xpath("//img"));

        System.out.println("Number of elements:" +(customers2.size()-1));

        int a =(int) ( Math.random() * customers2.size());
        int b = a+1;

        System.out.println("Customer number:" +a);

        By opensmth = By.xpath("//tbody/tr["+ a +"]/td/div");
        driver.findElement(opensmth).click();

        String orderLine = driver.findElement(By.xpath("//tr["+a+"]/td[7]//span[text()]")).getText();
        //String actualElement = orderLine.getText();
        System.out.println("Order ID "+orderLine);
        //System.out.println(actualElement);

        String idLine = driver.findElement(By.xpath("//tr["+a+"]/td[3]//span[text()]")).getText();
        //String actualElement2 = idLine.getText();
        System.out.println("Customer ID "+idLine);
        //System.out.println(actualElement2);

        String dateLine = driver.findElement(By.xpath("//tr["+a+"]/td[4]/span[text()]")).getText();
        System.out.println("Order date "+dateLine);

        String nameLine = driver.findElement(By.xpath("//tr["+a+"]/td[5]//div[text()]")).getText();
        System.out.println("Customer name "+nameLine);

        String nameIn = driver.findElement(By.xpath("//tr["+b+"]//div[1]/div[1]/h6[text()]")).getText();
        System.out.println("Customer name "+nameIn);

        String dateIn = driver.findElement(By.xpath("//td//div[4]/div[1]/p[text()]")).getText();
        System.out.println("Order date "+dateIn);

        String idIn = driver.findElement(By.xpath("//tr["+b+"]//div[1]/div[2]/h6[text()]")).getText();
        System.out.println("Customer ID "+idIn);

        String orderIn = driver.findElement(By.xpath("//td//div[4]/div[2]/p[text()]")).getText();
        System.out.println("Order ID "+orderIn);

        idIn = idIn.replace("Invoice ", "");

        System.out.println(idIn);

        int val = 0;
        val = idLine.compareTo(idIn);
        System.out.println(val);

        if (val == 0) {
            System.out.println("Same ID");
        }else{
            System.out.println("Incorrect ID");
        }
        val = 0;
        val = orderLine.compareTo(orderIn);
        System.out.println(val);

        if (orderIn == orderLine){
            System.out.println("Same ordr ID");
        }else {
            System.out.println("Incorrect order ID");
        }
        val = 0;
        val = nameIn.compareTo(nameLine);
        System.out.println(val);

        if (val == 0){
            System.out.println("Same name");
        }else {
            System.out.println("Incorrect name");
        }

        val = 0;
        val = dateLine.compareTo(dateIn);
        System.out.println(val);

        if (val == 0){
            System.out.println("Same date");
        }else {
            System.out.println("Incorrect date");
        }


    }
}


