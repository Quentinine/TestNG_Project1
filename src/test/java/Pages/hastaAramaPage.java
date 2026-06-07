package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class hastaAramaPage {

    public hastaAramaPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
    public WebElement findrec;

    @FindBy(css = "input#patient-search")
    public WebElement findpatient;

    @FindBy(xpath = "//*[@class =\"odd\"][1]")
    public WebElement firstPatient;

    @FindBy(css = ".dataTables_empty")
    public WebElement found;

    @FindBy(xpath = "//div[contains(text(),'Delete Patient')]")
    public WebElement deleteButton;

    @FindBy(css = "#delete-patient-creation-dialog button.confirm.right")
    public WebElement confirm;

    @FindBy(css = "tbody tr")
    public List<WebElement> patients;

    @FindBy(xpath = "//*[@class =\"odd\"][1]")
    public WebElement expCon;

    @FindBy(css = "#patient-search-results-table_next")
    public WebElement next;

    @FindBy(css = "#patient-search-results-table_info")
    public WebElement expString;

}
