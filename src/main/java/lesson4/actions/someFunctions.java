package lesson4.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class someFunctions {

    public static WebDriver driver;

    @FindBy(xpath = "//img")
    private WebElement customImg;

    public static final int getNumberOfRandom(){
        List customers2 = driver.findElements(By.xpath("//img"));

        System.out.println("Number of elements:" +(customers2.size()-1));

        int a =(int) ( Math.random() * customers2.size());
        if (a == 0)
            a = a+1;

        System.out.println("Customer number:" +a);
        return a;
    }

    public final int getNumberOfRandomService(int a) {
        int b = a+1;
        return b;
    }

    public someFunctions checkCreds(String inText, String lineText) {
        int val = 0;
        val = inText.compareTo(lineText);

        System.out.println(val);
        if (val == 0) {
            System.out.println(inText + " match");
        }else{
            System.out.println(inText + " not match" + lineText);
        }
        return this;
    }

    public String deleteString() {
        String deleteString = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        return deleteString;
    }

}
