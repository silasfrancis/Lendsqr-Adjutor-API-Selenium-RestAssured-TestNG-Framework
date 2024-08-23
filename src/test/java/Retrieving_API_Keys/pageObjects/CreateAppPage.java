package Retrieving_API_Keys.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateAppPage extends BaseObject{

    public CreateAppPage(WebDriver driver)
    {
        super(driver);
    }
    Actions act = new Actions(driver);

    @FindBy(xpath = "//div[contains(text(),'Create an app')]")
    WebElement menu_createApp;

    @FindBy(xpath = "//div[contains(text(),'Create an App')]")
    WebElement createApp;

    @FindBy(xpath = "//input[@name='name']")
    WebElement app_name;

    @FindBy(xpath = "//input[@name='description']")
    WebElement app_description;

    @FindBy(xpath = "//input[@name='webhook_url']")
    WebElement website;

    @FindBy(xpath = "//div[@class='_multi-select-checkbox_selected_categories__BnEkg']//div[1]//div[1]//button")
    WebElement clickVerificationScopes;

    @FindBy(xpath = "//div[@class='_multi-select-checkbox_selected_categories__BnEkg']//div[2]//div[1]//button")
    WebElement credit_bureaus;

    @FindBy(xpath = "//div[@class='_multi-select-checkbox_selected_categories__BnEkg']//div[3]//div[1]//button")
    WebElement Decisioning;

    @FindBy(xpath = "//div[@class='_multi-select-checkbox_selected_categories__BnEkg']//div[4]//div[1]//button")
    WebElement Operational_services;

    @FindBy(xpath = "//div[@class='_multi-select-checkbox_selected_categories__BnEkg']//div[5]//div[1]//button")
    WebElement Direct_debit;

    @FindBy(xpath = "//div[@class='_multi-select-checkbox_selected_categories__BnEkg']//div[6]//div[1]//button")
    WebElement kolo;

    @FindBy(xpath = "//div[normalize-space()='Create app']")
    WebElement continue_createApp;

    @FindBy(xpath = "//*[@id='hide-flow-tag-1']/div/div[3]/div[2]/div[2]/div[2]/div/input")
    WebElement ApiKey_box;

    public void CreateAppAfterLogin()
    {
        menu_createApp.click();
    }

    public void CreateApp()
    {
        createApp.click();
    }

    public void inputAppName(String name)
    {
        app_name.sendKeys(name);
    }

    public void inputAppdescription(String description)
    {
        app_description.sendKeys(description);
    }

    public void inputWebsite(String Website)
    {
        website.sendKeys(Website);
    }
    public void ClickVerificationScopes()
    {
        clickVerificationScopes.click();
    }

    public void VerificationScopes(int no)
    {
        try{
        WebElement checkbox = driver.findElement(By.xpath("//div[@class='_multi-select-checkbox_selected_categories__BnEkg']//div[1]//div[2]//div["+no+"]//input"));
        checkbox.click();}
        catch(Exception e)
        {
            act.keyDown(Keys.DOWN).perform();
        }
    }

    public void clickCreditBureaus()
    {
        credit_bureaus.click();
    }
    public void CreditBureaus(int no)
    {
        try{
        WebElement checkbox = driver.findElement(By.xpath("//div[@class='_multi-select-checkbox_selected_categories__BnEkg']//div[2]//div[2]//div["+no+"]//input"));
        checkbox.click();}
        catch(Exception e)
        {
            act.keyDown(Keys.DOWN).perform();
        }

    }

    public void clickDecisioning()
    {
        Decisioning.click();
    }

    public void Decisioning(int no)
    {
        try{
        WebElement checkbox = driver.findElement(By.xpath("//div[@class='_multi-select-checkbox_selected_categories__BnEkg']//div[3]//div[2]//div["+no+"]//input"));
        checkbox.click();}
        catch(Exception e)
        {
            act.keyDown(Keys.DOWN).perform();
        }

    }

    public void clickOperationalServices()
    {
        Operational_services.click();
    }

    public void OperationalServices(int no)
    {
        try{
        WebElement checkbox = driver.findElement(By.xpath("//div[@class='_multi-select-checkbox_selected_categories__BnEkg']//div[4]//div[2]//div["+no+"]//input"));
        checkbox.click();}
        catch(Exception e)
        {
            act.keyDown(Keys.DOWN).perform();
        }
    }

    public void clickDirectDebit()
    {
        Direct_debit.click();
    }

    public void DirectDebit(int no)
    {
        try{
        WebElement checkbox = driver.findElement(By.xpath("//div[@class='_multi-select-checkbox_selected_categories__BnEkg']//div[5]//div[2]//div["+no+"]//input"));
        checkbox.click();}
        catch(Exception e)
        {
            act.keyDown(Keys.DOWN).perform();
        }

    }

    public void clickKolo()
    {
        kolo.click();
    }

    public void Kolo(int no)
    {
        try{
        WebElement checkbox = driver.findElement(By.xpath("//div[@class='_multi-select-checkbox_selected_categories__BnEkg']//div[6]//div[2]//div["+no+"]//input"));
        checkbox.click();}
        catch(Exception e)
        {
            act.keyDown(Keys.DOWN).perform();
        }
    }

    public void AppToAPIKey()
    {
        continue_createApp.click();
    }

    public WebElement APIKey()
    {
        return ApiKey_box;
    }




}
