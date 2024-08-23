package API.endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DecisioningEndpoints extends Routes{

    public static Response GetDecisionModels()
    {
        Response response= given()
                .header("Authorization", ApiKey)

                .when()
                .get(get_decisionModels);
        return response;
    }

    public static Response GetDecisionModelsDetails(int id)
    {
        Response response= given()
                .pathParam("id", id)
                .header("Authorization", ApiKey)

                .when()
                .get(get_decisionModels);
        return response;
    }
}
