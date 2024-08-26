package API.testCases;

import API.endpoints.Data4LendersEndPoints;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC006_Data4Lenders{

    Logger logger = LogManager.getLogger(this.getClass());

    @Test(priority = 1)
    public void GetOptions()
    {
        logger.info("Starting GetOptions test");
        Response response = Data4LendersEndPoints.GetOptions();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("success").toString(),("true"));
        logger.info("GetOptions Successful");

    }

    @Test(priority = 2)
    public void GetUsers()
    {
        logger.info("Starting GetUsers test");
        Response response = Data4LendersEndPoints.GetUsers();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("GetUsers successful");
        Assert.assertEquals(response.jsonPath().get("success").toString(),("true"));

    }
}
