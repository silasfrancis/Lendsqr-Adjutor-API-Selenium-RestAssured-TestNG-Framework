package API.testCases;

import API.endpoints.EmbeddedLoansAndPaymentsEndpoints;
import API.payload.Loans;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC004_Loans extends BaseClass{

    Logger logger = LogManager.getLogger(this.getClass());
    Faker faker = new Faker();
    Loans loans = new Loans();

    @Test(priority = 1)
    public void GetLoanProducts()
    {
        logger.info("Getting Loan Products");
            Response response = EmbeddedLoansAndPaymentsEndpoints.GetLoanProducts();
            response.then().log().all();
            Assert.assertEquals(response.getStatusCode(), 200);
            logger.info("Loan Products Displayed");

            String id= response.jsonPath().get("product_id").toString();
            loans.setProduct_id(id);
    }

    @Test(priority = 2)
    public void InitializeLoanApp()
    {
        logger.info("Initializing Loan Application");
        Response response = EmbeddedLoansAndPaymentsEndpoints.InitializeLoanApp(Loans.data);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

        String reference= response.jsonPath().get("reference").toString();
        loans.setReference(reference);
    }

    @Test(priority = 3)
    public void GetLoan()
    {
        Response response = EmbeddedLoansAndPaymentsEndpoints.GetLoan(loans.getReference());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("status").toString(), "success");
    }

}
