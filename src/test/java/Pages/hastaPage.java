package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hastaPage {

    public hastaPage(WebDriver driver) {PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@href=\"/openmrs/registrationapp/registerPatient.page?appId=referenceapplication.registrationapp.registerPatient\"]")
    public WebElement registerPatient;

    @FindBy(xpath = "//*[@name=\"givenName\"]")
    public WebElement patientName;

    @FindBy(xpath = "//*[@name=\"familyName\"]")
    public WebElement patientSurname;

    @FindBy(css = "button#next-button")
    public WebElement continueButton;

    @FindBy(css ="select#gender-field")
    public WebElement gender;

    @FindBy(css = "input#birthdateDay-field")
    public WebElement Bday;

    @FindBy(css = "select#birthdateMonth-field") // select
    public WebElement Bmonth;

    @FindBy(css = "input#birthdateYear-field")
    public WebElement Byear;

    @FindBy(css = "#address1")
    public WebElement Address;

    @FindBy(css = "#submit")
    public WebElement submit;

    @FindBy(css = ".PersonName-givenName")
    public WebElement confname;











}
