package API.endpoints;

import API.payload.Mandate;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DirectDebitEndpoints extends Routes{

    public static Response GetAllBanks()
    {
        Response response = given()
                .header("Authorization", ApiKey)
                .pathParam("banks", "banks")
                .queryParam("limit",100)
                .queryParam("page",1)
                .queryParam("sort_dir", "ASC")

                .when()
                .get(get_allBanks);
        return response;
    }

    public static Response GetBankDetails(int bankID)
    {
        Response response = given()
                .header("Authorization", ApiKey)
                .pathParam("bank_id", bankID)

                .when()
                .get(get_bankDetails);
        return response;
    }

    public static Response VerifyAccountNumber(String data)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(data)
                .header("Authorization", ApiKey)

                .when()
                .post(post_verifyAccountNumber);
        return response;
    }

    public static Response CreateMandate(Mandate payload)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .header("Authorization", ApiKey)

                .when()
                .post(post_createMandate);
        return response;
    }

    public static Response GetAllMandates()
    {
        Response response = given()
                .header("Authorization", ApiKey)
                .pathParam("mandates", "mandates")
                .queryParam("limit", 10)
                .queryParam("page", 1)

                .when()
                .get(get_allMandates);
        return response;
    }

    public static Response DebitMandate(String data)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(data)
                .header("Authorization", ApiKey)

                .when()
                .post(post_DebitMandate);
        return response;
    }

    public static Response CheckAccountBalance(String data)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(data)
                .header("Authorization", ApiKey)

                .when()
                .post(post_checkAccountBalance);
        return response;
    }





}
