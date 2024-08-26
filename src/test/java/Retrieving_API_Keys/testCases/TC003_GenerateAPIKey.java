package Retrieving_API_Keys.testCases;

import Retrieving_API_Keys.pageObjects.CreateAppPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.FileWriter;

public class TC003_GenerateAPIKey extends BaseClass{

    @Test
    public void generateAPIKey() throws InterruptedException {
        TC002_Login login = new TC002_Login();
        login.login();
        logger.info("Login Successful");

        CreateAppPage create = new CreateAppPage(driver);
        create.CreateAppAfterLogin();
        create.CreateApp();

        Thread.sleep(5000);

        driver.navigate().refresh();
        create.CreateApp();
        create.inputAppName(randomString(4));
        create.inputAppdescription(randomString(7));
        create.inputWebsite("https://github.com");

        Thread.sleep(5000);
        Actions act = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//h6[normalize-space()='API Scopes']"));
        element.click();
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();
        WebElement inputbox = driver.findElement(By.xpath("//div[@class='_multi-select-checkbox_search_input__+5p54']//input[@type='text']"));
        inputbox.clear();
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();

        Thread.sleep(2000);
        create.ClickVerificationScopes();
        for(int i=1; i<=11; i++)
        {
            create.VerificationScopes(i);
            act.keyDown(Keys.DOWN).perform();
        }
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();
        Thread.sleep(2000);

        create.clickCreditBureaus();
        act.keyDown(Keys.DOWN).perform();
        for(int i=1; i<=2; i++)
        {
            create.CreditBureaus(i);
            act.keyDown(Keys.DOWN).perform();
        }
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();

        create.clickDecisioning();
        act.keyDown(Keys.DOWN).perform();
        for(int i=1; i<=1; i++)
        {
            create.Decisioning(i);
            act.keyDown(Keys.DOWN).perform();
        }
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();

        create.clickOperationalServices();
        act.keyDown(Keys.DOWN).perform();
        for(int i=1; i<=1; i++)
        {
            create.OperationalServices(i);
            act.keyDown(Keys.DOWN).perform();
        }
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();

        create.clickDirectDebit();
        act.keyDown(Keys.DOWN).perform();
        for(int i=1; i<=13; i++)
        {
            create.DirectDebit(i);
            act.keyDown(Keys.DOWN).perform();
        }
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();
        act.keyDown(Keys.DOWN).perform();

        create.clickKolo();
        act.keyDown(Keys.DOWN).perform();
        for(int i=1; i<=9; i++)
        {
            create.Kolo(i);
            act.keyDown(Keys.DOWN).perform();
        }
        create.AppToAPIKey();
        logger.info("App Created Successfully");

        Thread.sleep(5000);

        logger.info("Retrieving App Data");

        String text = create.APIKey().getAttribute("value");
        logger.info("ApiKey: {}", text);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ApiKey", text);
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject);

        try (FileWriter fileWriter = new FileWriter(".\\Retrieving_API_Keys\\ApiKey.json")) {
            fileWriter.write(jsonArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
