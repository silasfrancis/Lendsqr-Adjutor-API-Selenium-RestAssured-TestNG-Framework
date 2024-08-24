package API.testCases;

import API.endpoints.DecisioningEndpoints;
import API.payload.Decision;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC003_Decisioning extends BaseClass{

    Logger logger= LogManager.getLogger(this.getClass());
    Decision decision;
    Faker faker;

    @BeforeClass
    public void setupData()
    {
        faker = new Faker();
        decision = new Decision();
        decision.setGender(random2Str("male","female"));
        decision.setMarital_status(random4Str("married", "single", "divorced", "widowed"));
        decision.setAge(random2Int(37, 25));
        decision.setLocation(random2Str("Lagos", "Ibadan"));
        decision.setNo_of_dependent(random2Int(5,0));
        decision.setType_of_residence(random3Str("own house", "rented apartment","parents apartment"));
        decision.setEducational_attainment(random3Str(" BSc", "Msc", "HND")+faker.educator().university());
        decision.setEmployment_status(random3Str("employed","unemployed","retired"));
        decision.setSector_of_employment(random3Str("agriculture", "banking", "law"));
        decision.setMonthly_net_income(String.valueOf(random2Int(999999,700000)));
        decision.setEmployer_category(random4Str("artisan", "enterprise", "private company", "federal: public"));
        decision.setBvn(bvn);
        String phone = "080" + randomString(8);
        decision.setPhone_number(phone);
        decision.setTotal_years_of_experience(random2Int(5,0));
        decision.setTime_with_current_employer(random2Int(5,0));
        decision.setPrevious_lendsqr_loans(random2Int(5,0));
        decision.setPhone(phone);
        decision.setBvn_phone(phone);
        decision.setOffice_email(faker.internet().emailAddress());
        decision.setPersonal_email(faker.internet().emailAddress());
        decision.setAmount(String.valueOf(random2Int(10000,1000)));
    }

    @Test(priority = 1)
    public void GetDecisionModels()
    {
        logger.info("Fetching Decisioning Models");
        Response response = DecisioningEndpoints.GetDecisionModels();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("status").toString(), "success");
        Assert.assertEquals(response.jsonPath().get("message").toString(), "Successful");
        logger.info("Decisioning Models Displayed");

        int id= Integer.parseInt(response.jsonPath().get("data[0].id").toString());
        decision.setId(id);
    }

    @Test(priority= 2)
    public void GetDecisionModelsDetails()
    {
        logger.info("Fetching Decisioning Models Details");
        Response response = DecisioningEndpoints.GetDecisionModelsDetails(decision.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("status").toString(), "success");
        Assert.assertEquals(response.jsonPath().get("message").toString(), "Successful");
        Assert.assertEquals(response.jsonPath().get("data.name").toString().toString(), "Default Lendsqr decision model");

        logger.info("Decisioning Models Details Displayed");

    }

    @Test(priority = 3)
    public void OraculiBorrowerScoring()
    {
        Response response = DecisioningEndpoints.OraculiBorrowerScoring(decision, decision.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("status").toString(), "success");
        Assert.assertEquals(response.jsonPath().get("data.credit_score_items[0].score_value").toString(), this.decision.getAge());
        Assert.assertEquals(response.jsonPath().get("data.credit_score_items[1].score_value").toString(), this.decision.getGender());
        Assert.assertEquals(response.jsonPath().get("data.credit_score_items[2].score_value").toString(), this.decision.getLocation());
        logger.info("OraculiBorrowerScoring Test Successful");

    }




}
