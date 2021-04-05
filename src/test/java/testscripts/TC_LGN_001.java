package testscripts;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TC_LGN_001 extends BaseTest{


    @Test
    public void TC_LGN_001(){

        LoginPage lp = new LoginPage(driver);
        lp.verifyUserLogin("TC_LGN_001");
        HomePage hp = new HomePage(driver);
        hp.verifyHomePage();

    }
}
