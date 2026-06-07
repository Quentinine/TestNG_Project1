package Tests;

import Pages.loginPage;
import Utilities.Functions;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.logging.log4j.LogManager.getLogger;

public class _403_loginTestLoc extends Functions {

    private static final Logger logger = getLogger(_403_loginTestLoc.class);

    @Test(groups = {"Smoke", "Login"})
    public void loginWithoutLoc() {

        logger.info("Logout işlemi bitti.");

        loginPage page = new loginPage(driver);
        driver.get("https://openmrs.org/");
        page.demo.click();

        scrollTo(page.scrollToE);
        page.scrollToE.click();

        page.loginButton.click();
        Assert.assertTrue(page.warningLoc.isDisplayed());

    }
}
