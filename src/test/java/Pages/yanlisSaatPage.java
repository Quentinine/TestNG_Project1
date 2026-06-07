package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class yanlisSaatPage {

    public yanlisSaatPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")
    public WebElement appClick1;

    @FindBy(css = "#appointmentschedulingui-manageAppointments-app")
    public WebElement appClick2;

    @FindBy(css = "#patient-search.form-control")
    public WebElement search;

    @FindBy(xpath = "//tbody[@aria-live='polite']/tr[@class='odd'][1]")
    public WebElement click3;

    @FindBy(css = "#time-zone-warning")
    public WebElement warning;

}