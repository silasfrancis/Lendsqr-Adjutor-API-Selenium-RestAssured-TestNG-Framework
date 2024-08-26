package API.testCases;

import API.endpoints.OperationalServicesEndpoints;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC007_OperationalServices {

    Logger logger = LogManager.getLogger(this.getClass());

    @Test(priority = 1)
    public void GetAdutorPricing()
    {
        logger.info("Starting GetAdutorPricing test");
        Response response = OperationalServicesEndpoints.GetAdutorPricing();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("status").toString(),("success"));
        logger.info("GetAdutorPricing test successful");
    }

    @Test(priority = 2)
    public void GetWallet()
    {
        logger.info("Starting GetWallet test");
        Response response = OperationalServicesEndpoints.GetWallet();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("status").toString(),("success"));
        logger.info("GetWallet test successful");

    }

    @Test(priority = 3)
    public void GetBankList()
    {
        logger.info("Starting GetBankList test");
        Response response = OperationalServicesEndpoints.GetBankList();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("status").toString(),("success"));
        logger.info("GetBankList test Successful");

    }
}
