package API.testCases;

import API.endpoints.EmbeddedLoansAndPaymentsEndpoints;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC004_Loans extends BaseClass{

    Logger logger = LogManager.getLogger(this.getClass());
    Faker faker = new Faker();

    @Test(priority = 1)
    public void GetLoanProducts(ITestContext context)
    {
        logger.info("Getting Loan Products");
        Response response = EmbeddedLoansAndPaymentsEndpoints.GetLoanProducts();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("Loan Products Displayed");
        Assert.assertEquals(response.jsonPath().get("status").toString(), "success");
        String product_id= response.jsonPath().get("data[0].product_id").toString();
        context.setAttribute("productID", product_id);
        logger.info("Loan Products Displayed");

    }

    @Test(priority = 2)
    public void InitializeLoanApp(ITestContext context)
    {

        JSONObject data = new JSONObject();
        data.put("product_id", context.getAttribute("productID"));
        JSONObject meta = new JSONObject();
        meta.put("email", faker.internet().emailAddress());
        meta.put("phone_number", "080" + randomNumber(8));
        data.put("meta", meta);
        System.out.println(data);

        logger.info("Initializing Loan Application");
        Response response = EmbeddedLoansAndPaymentsEndpoints.InitializeLoanApp(data.toString());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("status").toString(), "success");
        String reference= response.jsonPath().get("data.reference").toString();
        context.setAttribute("reference", reference);
        logger.info("InitializeLoanApp Test passed");
    }

    @Test(priority = 3)
    public void GetLoan(ITestContext context)
    {
        Response response = EmbeddedLoansAndPaymentsEndpoints.GetLoan((String) context.getAttribute("reference"));
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("status").toString(), "success");
        logger.info("GetLoan Test Passed");
    }

}
