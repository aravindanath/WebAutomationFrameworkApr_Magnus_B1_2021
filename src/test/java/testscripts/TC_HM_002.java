package testscripts;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

/**
 * @ author Anagha
 *
 * TC_002: Verify valid credentials
 *
 */

public class TC_HM_002 extends BaseTest {


    @Test
    public void TC_HM_002(){

        LoginPage lp = new LoginPage(driver);
        lp.verifyUserLogin("TC_LGN_001");
        HomePage hp = new HomePage(driver);
        hp.verifyHomePage();

    }
}
