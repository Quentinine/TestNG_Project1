package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hesabimPage {

    public hesabimPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".icon-user.small")
    public WebElement mainmenu;

    @FindBy(css = "#user-account-menu")
    public WebElement chmenu;

    @FindBy(xpath = "//li[normalize-space()='My Account']/i")
    public WebElement disp;

    @FindBy(xpath = "(//*[@class='task'])[1]")
    public WebElement changepass;

    @FindBy(xpath = "(//*[@class='task'])[2]")
    public WebElement mylan;





}

