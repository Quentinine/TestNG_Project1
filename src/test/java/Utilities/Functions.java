package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Functions extends BaseDriver {

    public static Select returnSelect(WebElement element) {
        Select select = new Select(element);
        return select;
    }

    public static void clearSendKeys(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public static void print(String value) {
        System.out.println(value);
    }

    public void scrollTo(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

}
