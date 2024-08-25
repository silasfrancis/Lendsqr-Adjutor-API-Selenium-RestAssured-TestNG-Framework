package Retrieving_API_Keys.testCases;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import Retrieving_API_Keys.Configuration.ReadConfig;
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

    @Parameters("browser")
    @BeforeClass
    public void setup(String br)
    {
        switch(br.toLowerCase())
        {
            case "chrome":  driver = new ChromeDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            default: System.out.println("Invalid browser");
        }
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
