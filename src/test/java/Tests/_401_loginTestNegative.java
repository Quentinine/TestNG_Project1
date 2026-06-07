package Tests;

import Pages.loginPage;
import Utilities.Functions;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.apache.logging.log4j.LogManager.getLogger;

public class _401_loginTestNegative extends Functions {

    private static final Logger logger = getLogger(_401_loginTestNegative.class);

    @DataProvider(name = "logindata")
    public Object[][] getData() {
        return new Object[][]{
                {"invalidname", "pass"},
                {"login", "invalidpass"},
                {"", ""},
                {"admin", "wrongpass"},
                {"admin", ""},
                {"", "wrongpass"},
        };
    }

    @Test(dataProvider = "logindata", groups = {"Login", "Smoke"})
    public void loginTestW(String usernameSend, String passSend) {

        logger.info("Negatif giriş testi bitti.");

        loginPage page = new loginPage(driver);
        driver.get("https://openmrs.org/");
        page.demo.click();

        scrollTo(page.scrollToE);
        page.scrollToE.click();

        page.login.sendKeys(usernameSend);
        page.password.sendKeys(passSend);

        page.location1.click();
        page.loginButton.click();

        Assert.assertTrue(page.warninglogin.isDisplayed());

    }

}
