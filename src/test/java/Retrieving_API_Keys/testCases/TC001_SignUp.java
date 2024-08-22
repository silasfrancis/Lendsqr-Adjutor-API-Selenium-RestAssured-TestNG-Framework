package Retrieving_API_Keys.testCases;

import Retrieving_API_Keys.pageObjects.SignUpPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_SignUp extends BaseClass{

    @Test
    public void signUp() throws InterruptedException {
        SignUpPage sign = new SignUpPage(driver);

        sign.clickSignUp();
        sign.inputFullName("Francis Samuel Silas");
        sign.inputEmail(username);
        sign.inputPhone("Nigeria", "9038897423");
        sign.inputBusinessName("Silas QA");
        sign.inputRcNumber(randomNumber(8));
        sign.inputPassword(password);
        sign.clickContinue();
        Thread.sleep(3000);

        WebElement confirmation = sign.SignUpConfirmation();
        if(confirmation.isDisplayed())
        {
            if(confirmation.getText().contains("We’ve sent a validation email to " + username))
            {
                Assert.assertTrue(true);
                logger.info("SignUp Successful");
            }
        }
    }
}
