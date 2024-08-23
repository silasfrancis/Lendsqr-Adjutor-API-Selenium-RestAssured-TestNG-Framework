package API.testCases;

import API.endpoints.DecisioningEndpoints;
import API.payload.Decision;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC003_Decisioning {
    Logger logger;
    Decision decision;

    @BeforeClass
    public void setupData()
    {
        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void GetDecisionModels(ITestContext context)
    {
        logger.info("Fetching Decisioning Models");
        Response response = DecisioningEndpoints.GetDecisionModels();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("status").toString(), "success");
        Assert.assertEquals(response.jsonPath().get("message").toString(), "Successful");
        response.then().log().all();
        logger.info("Decisioning Models Displayed");

        int id= Integer.parseInt(response.jsonPath().get("data[0].id").toString());
        context.setAttribute("id", id);


    }

    @Test(priority= 2)
    public void GetDecisionModelsDetails(ITestContext context)
    {
        int id = (int)context.getAttribute("id");

        logger.info("Fetching Decisioning Models Details");
        Response response = DecisioningEndpoints.GetDecisionModelsDetails(id);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("status").toString(), "success");
        Assert.assertEquals(response.jsonPath().get("message").toString(), "Successful");
        Assert.assertEquals(response.jsonPath().get("data[0].id").toString(), id);
        response.then().log().all();
        logger.info("Decisioning Models Details Displayed");
    }



}
