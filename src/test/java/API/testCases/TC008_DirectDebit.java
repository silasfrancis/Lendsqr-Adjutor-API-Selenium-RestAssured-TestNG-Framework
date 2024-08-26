package API.testCases;

import API.endpoints.DirectDebitEndpoints;
import API.payload.Mandate;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TC008_DirectDebit extends BaseClass{
    Mandate mandate;
    Faker faker;
    Logger logger = LogManager.getLogger(this.getClass());

    @Test(priority = 1)
    public void GetAllBanks(ITestContext context)
    {
        Response response = DirectDebitEndpoints.GetAllBanks();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        String bank_id= response.jsonPath().get("data.bank_id").toString();
        context.setAttribute("bank_id", bank_id);
    }

    @Test(priority = 2)
    public void GetBankDetails(ITestContext context) {

        String bankID = (String) context.getAttribute("bank_id");
        Response response = DirectDebitEndpoints.GetBankDetails(bankID);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void VerifyAccountNumber()
    {
        JSONObject data = new JSONObject();
        data.put("account_number", "");
        data.put("bank_code", "");

        Response response = DirectDebitEndpoints.VerifyAccountNumber(data.toString());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void CreateMandate()
    {
        faker =new Faker();
        mandate = new Mandate();
        mandate.setAccount_number("");
        mandate.setPhone_number("");
        mandate.setDebit_type("");
        mandate.setBank_code("");
        mandate.setEmail(faker.internet().emailAddress());
        mandate.setStart_date("2024-05-01");
        mandate.setEnd_date("2024-08-01");
        mandate.setNarration(randomString(20));
        mandate.setAddress(faker.address().fullAddress());
        mandate.setAmount(Integer.parseInt(randomNumber(5)));

        Response response = DirectDebitEndpoints.CreateMandate(mandate);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 5)
    public void GetAllMandates(ITestContext context) {

        String bankID = (String) context.getAttribute("bank_id");
        Response response = DirectDebitEndpoints.GetAllMandates();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 6)
    public void DebitMandate()
    {
        JSONObject data = new JSONObject();
        data.put("reference_number", "");
        data.put("amount", "");
        data.put("narration", "");

        Response response = DirectDebitEndpoints.DebitMandate(data.toString());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 7)
    public void CheckAccountBalance()
    {
        JSONObject data = new JSONObject();
        data.put("reference_number", "");

        Response response = DirectDebitEndpoints.CheckAccountBalance(data.toString());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }


}
