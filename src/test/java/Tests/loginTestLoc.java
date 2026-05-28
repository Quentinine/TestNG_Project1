package Tests;

import Pages.loginPage;
import Utilities.Functions;
import org.testng.Assert;

public class loginTestLoc extends Functions {

    public void loginWithoutLoc() {

        loginPage page = new loginPage(driver);
        driver.get("https://openmrs.org/");
        page.demo.click();

        scrollTo(page.scrollToE);
        page.scrollToE.click();

        page.login.click();
        Assert.assertTrue(page.warningLoc.isDisplayed());

    }
}
