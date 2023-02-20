
package com.journaldev.selenium.findelements;

        import java.util.List;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

public class testclass {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.irctc.co.in/nget/user-registration");
        List<WebElement> elements = driver.findElements(By.id("M"));
        System.out.println("Number of elements:" +elements.size());

        for(int i=0; i<elements.size(); i++){
            System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));
        }
    }
}