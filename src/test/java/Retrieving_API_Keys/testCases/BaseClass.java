package Retrieving_API_Keys.testCases;

import Retrieving_API_Keys.utilities.ReadConfig;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;
    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getAppURl();
    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();

    public Logger logger;

    @BeforeClass
    public void setup()
    {
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        logger = LogManager.getLogger(this.getClass());
    }

    @AfterClass
    public void teardown()
    {
        driver.quit();
    }

    public String randomString(int count)
    {
        return RandomStringUtils.randomAlphabetic(count);
    }

    public String randomNumber(int count)
    {
        return RandomStringUtils.randomNumeric(count);
    }

}
