package Tests;

import Utilities.Functions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class _408_hastaListeleme extends Functions {

    @BeforeClass
    public void login(){

        loginOP();
    }

    @Test(groups = {"Regression", "PatientManagement"})
    public void hastaListeleme(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));




    }


}
