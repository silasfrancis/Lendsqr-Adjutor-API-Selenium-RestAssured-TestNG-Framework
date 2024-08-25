package API.testCases;

import API.endpoints.EmbeddedLoansAndPaymentsEndpoints;
import API.payload.Payment;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC005_Payments extends BaseClass{

    Payment pay;

    @BeforeClass
    public void setupData()
    {
        pay = new Payment();
        pay.setAmount(Integer.parseInt(randomNumber(5)));
        pay.setDescription(randomString(5) +randomString(5) + randomString(5) + randomString(5));
        pay.setOrganization_id("37a749d808e46495a8da1e5352d03cae");
        pay.setCallback_url("https://lendsqr.com");
    }

    @Test(priority = 1)
    public void InitializePayment(ITestContext context)
    {
        Response response = EmbeddedLoansAndPaymentsEndpoints.InitializePayment(pay);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        String reference= response.jsonPath().get("data.reference").toString();
        context.setAttribute("reference", reference);

    }

    @Test(priority = 2)
    public void QueryPayment(ITestContext context)
    {
        String reference = (String) context.getAttribute("reference");
        Response response = EmbeddedLoansAndPaymentsEndpoints.QueryPayment(reference);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
