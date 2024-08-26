package API.testCases;

import API.endpoints.OperationalServicesEndpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC007_OperationalServices {

    @Test(priority = 1)
    public void GetAdutorPricing()
    {
        Response response = OperationalServicesEndpoints.GetAdutorPricing();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 2)
    public void GetWallet()
    {
        Response response = OperationalServicesEndpoints.GetWallet();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 3)
    public void GetBankList()
    {
        Response response = OperationalServicesEndpoints.GetBankList();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }
}
