package Retrieving_API_Keys.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseObject{

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='email']")
    WebElement txt_email;

    @FindBy(xpath = "//input[@name='password']")
    WebElement txt_password;

    @FindBy(xpath = "//div[normalize-space()='Login']")
    WebElement login;

    @FindBy(xpath = "//h6[normalize-space()='Hello Samuel']")
    WebElement loginConfirm;

    public void inputEmail(String email)
    {
        txt_email.sendKeys(email);
    }

    public void inputPassword(String pwd)
    {
        txt_password.sendKeys(pwd);
    }

    public void clickLogin()
    {
        login.click();
    }

    public WebElement confirmLogin()
    {
        return loginConfirm;
    }
}
