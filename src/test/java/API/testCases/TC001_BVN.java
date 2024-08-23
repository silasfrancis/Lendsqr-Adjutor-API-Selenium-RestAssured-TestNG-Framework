package API.testCases;

import API.endpoints.BvnEndPoints;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.util.HashMap;


public class TC001_BVN extends BaseClass{

    Logger logger;

    @BeforeClass
    public void setupData()
    {
        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void InitializeBVN()
    {
        String phoneno = "080"+randomNumber(8);
        HashMap<Object, Object> contact = new HashMap<>();
        contact.put("contact", phoneno);

        logger.info("Initializing BVN consent");
        Response response = BvnEndPoints.InitializeBVN(contact, bvn);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("status").toString(), "otp");
        Assert.assertEquals(response.jsonPath().get("message").toString(), "Please provide OTP sent to contact");
        response.then().log().all();
        logger.info("otp sent to customer");
    }

    @Test(priority = 2)
    public void GetBVNdetails()
    {
        HashMap <Object, Object> otp = new HashMap<>();
        otp.put("otp",randomNumber(6));

        Response response = BvnEndPoints.getBVNDetails(otp, bvn);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("status").toString(), "success");
        response.then().log().all();

    }

    @Test(priority=3)
    public void IntializeBVNAccounts()
    {
        HashMap <Object, Object> contact = new HashMap<>();
        contact.put("contact",randomAlphaNumeric(6)+"@gmail.com");

        logger.info("Initializing BVN account consent");
        Response response = BvnEndPoints.InitializeBVNAccounts(contact, bvn);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("status").toString(), "otp");
        Assert.assertEquals(response.jsonPath().get("message").toString(), "Please provide OTP sent to contact");
        response.then().log().all();
        logger.info("otp sent to customer");
    }
}
