package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hastaMergePage {

    public hastaMergePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension")
    public WebElement click1;

    @FindBy(css = "#coreapps-mergePatientsHomepageLink-app")
    public WebElement click2;

    @FindBy(css = "#patient-search")
    public WebElement patientsearch;

    @FindBy(xpath = "//tr[@class=\"even\"][1]")
    public WebElement patient1;

    @FindBy(xpath = "//tr[@class=\"odd\"][2]")
    public WebElement patient2;

    @FindBy(css = "#confirm-button")
    public WebElement confirmButton;

    @FindBy(xpath = "//*[@id = 'first-patient']")
    public WebElement merge;

    @FindBy(xpath = "//*[@id = 'confirm-button']")
    public WebElement confirm;
}