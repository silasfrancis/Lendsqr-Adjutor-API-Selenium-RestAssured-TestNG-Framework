package Retrieving_API_Keys.testCases;

import Retrieving_API_Keys.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_Login extends BaseClass{

    @Test
    public void login()
    {
        LoginPage lp = new LoginPage(driver);
        lp.inputEmail(username);
        lp.inputPassword(password);
        lp.clickLogin();
        if(lp.confirmLogin().isDisplayed())
        {
            Assert.assertTrue(true);
            //logger.info("Login Successful");
        }
    }
}
