package API.endpoints;

import API.payload.Decision;
import io.restassured.http.ContentType;
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
                .get(get_decisionModelsDetails);
        return response;
    }

    public static Response OraculiBorrowerScoring(Decision payload, int id)
    {
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParam("id", id)
                .header("Authorization", ApiKey)

                .when()
                .post(post_Oraculi_Borrower_Scoring);
        return response;
    }
}
