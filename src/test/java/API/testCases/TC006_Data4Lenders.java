package API.testCases;

import API.endpoints.Data4LendersEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC006_Data4Lenders{

    @Test(priority = 1)
    public void GetOptions()
    {
        Response response = Data4LendersEndPoints.GetOptions();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 2)
    public void GetUsers()
    {
        Response response = Data4LendersEndPoints.GetUsers();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }
}
