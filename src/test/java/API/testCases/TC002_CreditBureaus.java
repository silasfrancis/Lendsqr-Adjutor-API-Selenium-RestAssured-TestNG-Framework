package API.testCases;

import API.endpoints.CreditBureausEndPoints;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.net.Priority;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC002_CreditBureaus extends BaseClass{

    Logger logger;

    @BeforeClass
    public void setupData()
    {
        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority= 1)
    public void GetCRCReport()
    {
        logger.info("Fetching Credit Report from CRC Credit Bureau");
        Response response = CreditBureausEndPoints.GetCRCReport(bvn);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("status").toString(), "success");
        Assert.assertEquals(response.jsonPath().get("message").toString(), "Successful");
        Assert.assertEquals(response.jsonPath().get("data.nano_consumer_profile.consumer_details.identification[0].id_value").toString(), bvn);
        Assert.assertEquals(response.jsonPath().get("data.nano_consumer_profile.consumer_details.identification[0].source_id").toString(), "BVN");
        response.then().log().all();
        logger.info("Credit Report Displayed");
    }

    @Test(priority= 2)
    public void GetFirstCentralReport()
    {
        logger.info("Fetching Credit Report from FirstCentral Credit Bureau");
        Response response = CreditBureausEndPoints.GetFirstCentralReport(bvn);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("status").toString(), "success");
        Assert.assertEquals(response.jsonPath().get("message").toString(), "Successful");
        response.then().log().all();
    }
}
