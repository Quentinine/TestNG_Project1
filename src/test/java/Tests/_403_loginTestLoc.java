package Tests;

import Pages.loginPage;
import Utilities.Functions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _403_loginTestLoc extends Functions {

    @Test(groups = {"Smoke", "Login"})
    public void loginWithoutLoc() {

        loginPage page = new loginPage(driver);
        driver.get("https://openmrs.org/");
        page.demo.click();

        scrollTo(page.scrollToE);
        page.scrollToE.click();

        page.loginButton.click();
        Assert.assertTrue(page.warningLoc.isDisplayed());

    }
}
