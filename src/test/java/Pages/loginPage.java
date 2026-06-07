package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class loginPage {

    public loginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='https://openmrs.org/demo/']")
    public WebElement demo;

    @FindBy(xpath = "//a[text() ='Explore OpenMRS 2']")
    public WebElement scrollToE;

    @FindBy(css = "input#username")
    public WebElement login;

    @FindBy(css = "input#password")
    public WebElement password;

    @FindBy(css = "li[id='Inpatient Ward']")
    public WebElement location1;

    @FindBy(css = "input#loginButton")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@href=\"/openmrs/appui/header/logout.action?successUrl=openmrs\"]")
    public WebElement logout;

    @FindBy(xpath = "//*[text()=\"Invalid username/password. Please try again.\"]")
    public WebElement warninglogin;

    @FindBy(xpath = "//*[text()=\"You must choose a location!\"]")
    public WebElement warningLoc;

    @FindBy(xpath = "//h4[contains(text(),'Logged')]")
    public WebElement logged;

    @FindBy(xpath = "//*[@tabindex]")
    public List<WebElement> locations;

}
