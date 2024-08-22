package Retrieving_API_Keys.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BaseObject {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[normalize-space()='Sign Up']")
    WebElement signUp;

    @FindBy(xpath = "//input[@name='name']")
    WebElement txt_fullname;

    @FindBy(xpath = "//input[@name='email']")
    WebElement txt_email;

    @FindBy(xpath = "//div[@class='arrow']")
    WebElement country_drp; // //span[normalize-space()='Kenya']

    @FindBy(xpath = "//input[@placeholder='1 (702) 123-4567']")
    WebElement txt_phone;

    @FindBy(xpath = "//input[@name='business_name']")
    WebElement txt_businessName;

    @FindBy(xpath = "//input[@name='rc_number']")
    WebElement txt_rcNumber;

    @FindBy(xpath = "//input[@name='password']")
    WebElement txt_password;

    @FindBy(xpath = "//button[contains(@type,'submit')]")
    WebElement btn_continue;

    @FindBy(xpath = "//p[contains(@class,'sm')]")
    WebElement signUpConfrimation;


    public void clickSignUp() {
        signUp.click();
    }

    public void inputFullName(String fullname)
    {
        txt_fullname.sendKeys(fullname);
    }

    public void inputEmail(String email)
    {
        txt_email.sendKeys(email);
    }

    public void inputPhone(String country, String phoneno)
    {
        country_drp.click();
        WebElement Country = driver.findElement(By.xpath("//span[normalize-space()='"+country+"']"));
        Country.click();
        txt_phone.sendKeys(phoneno);
    }

    public void inputBusinessName(String bname)
    {
        txt_businessName.sendKeys(bname);
    }

    public void inputRcNumber(String rcNumber)
    {
        txt_rcNumber.sendKeys(rcNumber);
    }

    public void inputPassword(String pwd)
    {
        txt_password.sendKeys(pwd);
    }

    public void clickContinue()
    {
        btn_continue.click();
    }

    public WebElement SignUpConfirmation()
    {
        return signUpConfrimation;
    }
}
